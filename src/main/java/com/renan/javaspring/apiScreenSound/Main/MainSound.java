package com.renan.javaspring.apiScreenSound.Main;

import com.renan.javaspring.apiScreenSound.modelSound.DadosMusica;
import com.renan.javaspring.apiScreenSound.modelSound.Musica;
import com.renan.javaspring.apiScreenSound.repositorySound.SerieRepositorySound;
import com.renan.javaspring.apiScreenSound.service.ConsumoApiSound;
import com.renan.javaspring.apiScreenSound.service.ConverteDadosSound;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainSound {
    private Scanner scan = new Scanner(System.in);
    private ConsumoApiSound consumoSound = new ConsumoApiSound();
    private ConverteDadosSound conversorSound = new ConverteDadosSound();

    private final String ENDERECO = "https://api.deezer.com/search?q=";

    private SerieRepositorySound repositorySound;

    public MainSound(SerieRepositorySound repositorySound) {
        this.repositorySound = repositorySound;
    }


    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    1. Cadastrar artistas
                    2. Cadastrar músicas
                    3. Listar músicas
                    4. Buscar músicas por artista
                    5. Pesquisar dados sobre um artista
                                                        
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao =scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtistas();
                    break;
                case 5:
                    pesquisarDadosSobreArtista();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void buscarMusicaWeb() {
        DadosMusica dadosMusica = getDadosMusica();
        Musica musica = new Musica(dadosMusica);
        repositorySound.save(musica);
        System.out.println(dadosMusica);
    }

    private DadosMusica getDadosMusica() {
        System.out.println("Digite o nome da música para busca");
        var nomeMusica = scan.nextLine();

        String encoded = URLEncoder.encode(nomeMusica, StandardCharsets.UTF_8);

        var json = consumoSound.obterDadosSound(ENDERECO + encoded);

        DadosMusica dados = conversorSound.obterDadosSound(json, DadosMusica.class);

        return dados;
    }

}
