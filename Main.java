import java.util.Scanner;


public class Main {

    static LinhaAutocarro linhaAutocarro = new LinhaAutocarro();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int opcao;

        do {
            printMainMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    criarLinha();
                    break;

                case 2:
                    printMenuAlteracoesParagens();
                    break;
                    
                case 3:
                    // Limpar buffer
                    scanner.nextLine();

                    System.out.print("Nome da paragem: ");
                    String nome = scanner.nextLine();

                    System.out.print("Número de passageiros a adicionar: ");
                    int numPassageiros = scanner.nextInt();

                    adicionarPassageiros(nome, numPassageiros);
                    break;

                case 4:
                    System.out.println(">> Simular chegada do autocarro");
                    break;

                case 5:
                    printMenuOrdenacaoParagens();
                    break;

                case 6:
                    System.out.println("\n==============================");
                    System.out.println("   Estado Atual da Linha   ");
                    System.out.println("==============================");
                    estadoLinha();
                    System.out.println("==============================");
                    break;

                case 7:
                    System.out.println(">> Calcular percurso");
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
    /* Opções menu */
    private static void criarLinha() {
        
        linhaAutocarro.inserir_paragem("A");
        linhaAutocarro.inserir_paragem("B");
        linhaAutocarro.inserir_paragem("C");
        linhaAutocarro.inserir_paragem("D");
        linhaAutocarro.inserir_paragem("E");
        linhaAutocarro.listar_percurso();
        System.out.print("Linha criada.");
    }

    public static void adicionarParagem(String nome) {

        linhaAutocarro.inserir_paragem(nome);
    }

    public static void removerParagem(String nome) {

        linhaAutocarro.remover_paragem(nome);
    }

    public static void adicionarPassageiros(String nomeParagem, int nPassageiros) {
        
        for(int i = 0; i < nPassageiros; i++) {
            System.out.print("Nome passageiro: ");
            String nomePassageiro = scanner.nextLine();
            linhaAutocarro.adicionar_passageiros(nomeParagem, nomePassageiro);
        }
    }

    public static void simularChegada() {

    }

    public static void ordenarParagemPorNumeroPassageiros() {

        linhaAutocarro.ordenar_paragens_por_num_passageiros();
    }
    public static void ordenarParagensPorNome() {

        linhaAutocarro.ordenar_paragens_por_nome();
    }

    public static void estadoLinha() {

        linhaAutocarro.listar_percurso();
    }

    public static void printMainMenu() {
        System.out.println("\n==============================");
        System.out.println("  SISTEMA DE AUTOCARROS");
        System.out.println("==============================");
        System.out.println("1. Criar linha de autocarro");
        System.out.println("2. Adicionar/remover paragens");
        System.out.println("3. Adicionar passageiros a uma paragem");
        System.out.println("4. Simular chegada do autocarro");
        System.out.println("5. Ordenar paragens");
        System.out.println("6. Mostrar estado atual da linha");
        System.out.println("7. Calcular percurso entre paragens");
        System.out.println("0. Sair");
        System.out.println("==============================");
        System.out.print("Escolha uma opção: ");
    }

    public static void printMenuAlteracoesParagens() {
        System.out.println("\n==============================");
        System.out.println("  GESTÃO DE PARAGENS");
        System.out.println("==============================");
        System.out.println("1 - Remover paragem");
        System.out.println("2 - Adicionar paragem");
        System.out.println("==============================");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt(); 
        scanner.nextLine(); 

        switch (opcao) { 
            case 1 -> { 
                System.out.print( "Nome da paragem a remover: " ); 
                String nome = scanner.nextLine(); 

                removerParagem(nome); 
                break;

            } case 2 -> { 
                System.out.print("Nome da paragem a adicionar: "); 
                String nome = scanner.nextLine(); 

                adicionarParagem(nome); 
                break;

            } default -> System.out.println( "Opção inválida." ); 
        }
    }
    public static void printMenuOrdenacaoParagens() {
        System.out.println("\n==============================");
        System.out.println("  ORDENAÇÃO DE PARAGENS  ");
        System.out.println("==============================");
        System.out.println("1 - Ordenar por nome");
        System.out.println("2 - Ordenar por nº passageiros");
        System.out.println("==============================");
        System.out.print("Escolha uma opção: ");

        int opcao;

        do {
                        
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1 -> {ordenarParagemPorNumeroPassageiros();}
                case 2 -> {ordenarParagensPorNome();}
                default -> System.out.println("Opção inválida.");
            }      

        } while (opcao != 1 && opcao != 2);
    }
}

