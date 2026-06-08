import java.util.Scanner;


public class Main {

    static LinhaAutocarro linhaAutocarro = new LinhaAutocarro();
    static Autocarro autocarro = new Autocarro();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        printMainMenu();       
    }

    /* Opções menu */
    /**
     * 
     */
    private static void criarLinha() {
        
        if(linhaAutocarro.exists()) {
            System.out.print("");
            System.out.print("A linha base já foi criada.");
            return;
        }

        linhaAutocarro.inserir_paragem("A");
        linhaAutocarro.inserir_paragem("B");
        linhaAutocarro.inserir_paragem("C");
        linhaAutocarro.inserir_paragem("D");
        linhaAutocarro.inserir_paragem("E");
        estadoLinha();
        

        if(linhaAutocarro.exists()) {
            System.out.print("");
            System.out.print("Linha base criada.");
        }
        
    }

    public static void adicionarParagem(String nome) {

        linhaAutocarro.inserir_paragem(nome);
    }

    public static void removerParagem(String nome) {

        linhaAutocarro.remover_paragem(nome);
    }

    public static void adicionarPassageiros(String nomeParagem, int nPassageiros) {
        scanner.nextLine();
        for(int i = 0; i < nPassageiros; i++) {
            System.out.print("Nome passageiro: ");
            String nomePassageiro = scanner.nextLine();
            linhaAutocarro.adicionar_passageiros(nomeParagem, nomePassageiro);
        }
    }

    public static void simularChegada() {
        printMenuSimularChegada();
    }

    public static void ordenarParagemPorNumeroPassageiros() {

        linhaAutocarro.ordenar_paragens_por_num_passageiros();
    }

    public static void ordenarParagensPorNome() {

        linhaAutocarro.ordenar_paragens_por_nome();
    }

    public static void estadoLinha() {
        System.out.println("\n==============================");
        System.out.println("   Estado Atual da Linha   ");
        System.out.println("==============================");
        linhaAutocarro.listar_percurso();
        System.out.println("==============================");
    }

    public static void printMainMenu() {

        int opcao;

        do {
            System.out.println("\n==============================");
            System.out.println("  SISTEMA DE AUTOCARROS");
            System.out.println("==============================");
            System.out.println("1. Criar linha de autocarro");
            System.out.println("2. Adicionar/remover paragens");
            System.out.println("3. Adicionar passageiros a uma paragem");
            System.out.println("4. Simular chegada do autocarro");
            System.out.println("5. Ordenar paragens");
            System.out.println("6. Mostrar estado atual da linha");
            System.out.println("0. Sair");
            System.out.println("==============================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarLinha();
                    break;

                case 2:
                    printMenuAlteracoesParagens();
                    break;
                    
                case 3:

                    System.out.print("Nome da paragem: ");
                    String nome = scanner.nextLine();

                    System.out.print("Número de passageiros a adicionar: ");
                    int numPassageiros = scanner.nextInt();

                    adicionarPassageiros(nome, numPassageiros);
                    break;

                case 4:
                    simularChegada();
                    break;

                case 5:
                    printMenuOrdenacaoParagens();
                    break;

                case 6:
                    estadoLinha();
                    break;

                case 0:
                    System.out.println("Programa terminado.");
                    break;

                default:
                    System.out.println("Opção inválida.");

            }

        } while (opcao != 0);

        scanner.close();
    }

    public static void printMenuAlteracoesParagens() {

        int opcao;

        do {
            System.out.println("\n==============================");
            System.out.println("  GESTÃO DE PARAGENS  ");
            System.out.println("==============================");
            System.out.println("1 - Remover paragem");
            System.out.println("2 - Adicionar paragem");
            System.out.println("0 - Voltar atrás");
            System.out.println("==============================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt(); 
            scanner.nextLine();
            
            switch (opcao) { 
                case 1 -> { 
                    System.out.print( "Nome da paragem a remover: " ); 
                    String nome = scanner.nextLine(); 
                    removerParagem(nome); 
                    break;

                } 
                case 2 -> { 
                    System.out.print("Nome da paragem a adicionar: "); 
                    String nome = scanner.nextLine(); 
                    adicionarParagem(nome); 
                    break;

                } 
                default -> {
                    System.out.println( "Opção inválida." );
                    break;
                } 
            }
        } while (opcao != 0);   
    }

    public static void printMenuOrdenacaoParagens() {

        int opcao;

        do {
            System.out.println("\n==============================");
            System.out.println("  ORDENAÇÃO DE PARAGENS  ");
            System.out.println("==============================");
            System.out.println("1 - Ordenar por nome");
            System.out.println("2 - Ordenar por nº passageiros");
            System.out.println("0 - Voltar atrás");
            System.out.println("==============================");
            System.out.print("Escolha uma opção: ");

        
                        
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1 -> {
                    ordenarParagensPorNome(); 
                    break;
                }
                case 2 -> {
                    ordenarParagemPorNumeroPassageiros(); 
                    break;
                }
                default -> {
                    System.out.println("Opção inválida.");
                    break;
                }
            }      

        } while (opcao != 0);
    }
    public static void printMenuSimularChegada() {

        int opcao;

        do {
            System.out.println("\n==============================");
            System.out.println("  Menu autocarro ");
            System.out.println("==============================");
            System.out.println("1 - Proxima Paragem");
            System.out.println("2 - Entrada de Passageiros");
            System.out.println("3 - Saída de Passageiros");
            System.out.println("0 - Voltar atrás");
            System.out.println("==============================");
            System.out.print("Escolha uma opção: ");

        
                        
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1 -> {
                    linhaAutocarro.proxima_paragem(); 
                    break;
                }
                case 2 -> {
                    System.out.println("Número de passageiros a embarcar: ");
                    int nPassageiros = scanner.nextInt(); 
                    autocarro.entrada_passageiros(linhaAutocarro, nPassageiros);
                    break;
                }
                case 3 -> {
                    System.out.println("Número de passageiros a desembarcar: ");
                    int nPassageiros = scanner.nextInt();
                    autocarro.saida_passageiros(linhaAutocarro, nPassageiros);
                    break;
                }
                case 0 -> {
                    break;
                }
                default -> {
                    System.out.println("Opção inválida.");
                    break;
                }
            }      

        } while (opcao != 0);
    }
}

