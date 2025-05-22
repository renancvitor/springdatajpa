package com.renan.javaspring.apiScreenSound.Main;

import java.util.Scanner;

public class MainSound {
    private Scanner scan = new Scanner(System.in);
    private ConsumoApiSound consumoSound = new ConsumoApiSound();
    private ConverteDadosSound conversorSound = new ConverteDadosSound();

    private final String API_KEY = "1653b8ce";
    private final String ENDERECO = "https://www.omdbapi.com/?apikey=" + API_KEY + "&t=";



    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    1. Buscar séries
                    2. Buscar episódios.
                    3. Listar séries buscadas
                    4. Buscar série por título
                    5. Buscar séries por ator
                                                        
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
