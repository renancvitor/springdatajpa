package com.renan.javaspring.apiScreenSound.Main;

import com.renan.javaspring.apiScreenSound.modelSound.Artista;
import com.renan.javaspring.apiScreenSound.modelSound.Musica;
import com.renan.javaspring.apiScreenSound.modelSound.TipoArtista;
import com.renan.javaspring.apiScreenSound.repositorySound.ArtistaRepository;
import com.renan.javaspring.apiScreenSound.service.ConsumoApiSound;
import com.renan.javaspring.apiScreenSound.service.ConverteDadosSound;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MainSound {
    private Scanner scan = new Scanner(System.in);
    private ConsumoApiSound consumoSound = new ConsumoApiSound();
    private ConverteDadosSound conversorSound = new ConverteDadosSound();

    private final String ENDERECO = "https://api.deezer.com/search?q=";

    private ArtistaRepository artistaRepository;

    public MainSound(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }


    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    \n1. Cadastrar artistas
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
                    buscarMusicasPorArtista();
                    break;
                case 5:
                    pesquisarDadosPorArtista();
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

    private void cadastrarArtista() {
        var cadastrarNovo = "S";

        while (cadastrarNovo.equalsIgnoreCase("s")) {
            System.out.print("Informe o nome do artista:  ");
            var nome = scan.nextLine();
            System.out.print("Informe o tipo do artista:  ");
            var tipo = scan.nextLine();

            TipoArtista tipoArtista = TipoArtista.fromString(tipo)
                    .orElseThrow(() -> new IllegalArgumentException("Tipo de artista inválido!"));
            Artista artista = new Artista(nome, tipoArtista);
            artistaRepository.save(artista);

            System.out.print("Cadastrar novo artista? (S/N):  ");
            cadastrarNovo = scan.nextLine();
        }
    }

    private void cadastrarMusica() {
        System.out.print("Cadastrar músicas de qual artista?  ");
        var nome = scan.nextLine();
        Optional<Artista> artista = artistaRepository.findByNomeContainingIgnoreCase(nome);
        if (artista.isPresent()) {
            System.out.print("Informe o título da música:  ");
            var nomeMusica = scan.nextLine();
            Musica musica = new Musica(nomeMusica);
            musica.setArtista(artista.get());
            artista.get().getMusicas().add(musica);
            artistaRepository.save(artista.get());
        } else {
            System.out.println("Artista não encontrado.");
        }
    }

    private void listarMusicas() {
        List<Artista> artistaList = artistaRepository.findAll();
        artistaList.forEach(System.out::println);
    }

    private void buscarMusicasPorArtista() {
    }

    private void pesquisarDadosPorArtista() {
    }
}
