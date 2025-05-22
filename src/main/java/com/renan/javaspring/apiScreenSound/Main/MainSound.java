package com.renan.javaspring.apiScreenSound.Main;

import com.renan.javaspring.apiScreenSound.repositorySound.SerieRepositorySound;
import com.renan.javaspring.apiScreenSound.service.ConsumoApiSound;
import com.renan.javaspring.apiScreenSound.service.ConverteDadosSound;

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
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    listarSeriesBuscadas();
                    break;
                case 4:
                    buscarSeriePorTitulo();
                    break;
                case 5:
                    buscaSeriesPorAtor();
                    break;
                case 6:
                    buscarTop5Series();
                    break;
                case 7:
                    buscarSeriesPorCategoria();
                    break;
                case 8:
                    buscarPorNumeroMaxTemporadas();
                    break;
                case 9:
                    buscaEpisodioPorTrecho();
                    break;
                case 10:
                    top5EpisodiosPorSerie();
                    break;
                case 11:
                    buscarEpisodiosDepoisDeUmaData();
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
}
