import java.util.Scanner;

/**
 * Menu principal do sistema de gestão de linha de autocarro.
 */
public class Main {

    static LinhaAutocarro linhaAutocarro = new LinhaAutocarro();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

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
            System.out.println("7. Calcular percurso entre paragens");
            System.out.println("0. Sair");
            System.out.println("==============================");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    criarLinha();
                    break;

                case 2:

                    int subOpcao;

                    do {
                        System.out.println("\n==============================");
                        System.out.println("  GESTÃO DE PARAGENS");
                        System.out.println("==============================");
                        System.out.println("1 - Remover paragem");
                        System.out.println("2 - Adicionar paragem");
                        System.out.print("Opção: ");

                        subOpcao = scanner.nextInt();
                        scanner.nextLine(); 

                        if (subOpcao == 1) {

                            System.out.print("Nome da paragem a remover: ");
                            String nome = scanner.nextLine();

                            linhaAutocarro.remover_paragem(nome);

                        } 
                        else if (subOpcao == 2) {

                            System.out.print("Nome da paragem: ");
                            String nome = scanner.nextLine();

                            linhaAutocarro.inserir_paragem(nome,0);

                        } 
                        else {
                            System.out.println("Opção inválida.");
                        }

                    } while (subOpcao != 1 && subOpcao != 2);

                    break;

                    case 3:

                        System.out.print("Nome da paragem: ");
                        scanner.nextLine();
                        String nome = scanner.nextLine();

                        System.out.print("Número de passageiros a adicionar: ");
                        int n = scanner.nextInt();

                        linhaAutocarro.adicionar_passageiros(nome, n);

                        break;
                case 4:
                    System.out.println(">> Simular chegada do autocarro");
                    break;

                case 5:
                    linhaAutocarro.ordenar_paragens();
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
        // testLinhaAutocarro();
        testAutocarro();
        testParagem();
        testPassageiro();
    }

    /* Funções declaração */

    private static void testParagem() {

    }

    private static void testAutocarro() {

    }

    private static void testPassageiro() {

    }

    /* Opções menu */
    private static void criarLinha() {

        /* Verificar se a linha está vazia antes de criar a linha */
        /*
         * if (linhaAutocarro) {
         * 
         * }
         */
        linhaAutocarro.inserir_paragem("A", 10);
        linhaAutocarro.inserir_paragem("B", 20);
        linhaAutocarro.inserir_paragem("C", 12);
        linhaAutocarro.inserir_paragem("D", 0);
        linhaAutocarro.inserir_paragem("E", 4);
        linhaAutocarro.listar_percurso();
        System.out.print("Linha criada.");
    }

    public void adicionarParagem(String nome, int numeroPassageiros) {
        linhaAutocarro.inserir_paragem(nome, numeroPassageiros);
    }

    public void removerParagem(String nome) {
        linhaAutocarro.remover_paragem(nome);
    }

    public void adicionarPassageiros(String nome) {

    }

    public void simularChegada() {

    }

    public void ordenarParagens(int order) {

    }

    public static void estadoLinha() {
        linhaAutocarro.listar_percurso();
    }
}