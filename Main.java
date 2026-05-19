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
                    opcao = 0;
                    do {
                        System.out.print("1 - Remover paragem: | 2 - Adicionar paragem");
                        System.out.print("Opção: \n");
                        opcao = scanner.nextInt();

                        if(opcao == 1) {

                        } else if (opcao == 2) {

                        }
                    } while (opcao != 1 && opcao != 2);
                    break;

                case 3:
                    System.out.println(">> Adicionar passageiros");
                    break;

                case 4:
                    System.out.println(">> Simular chegada do autocarro");
                    break;

                case 5:
                    System.out.println(">> Ordenar paragens");
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
        /*if (linhaAutocarro) {

        }*/
        linhaAutocarro.inserir_paragem("A", 10);
        linhaAutocarro.inserir_paragem("B", 20);
        linhaAutocarro.inserir_paragem("C", 12);
        linhaAutocarro.inserir_paragem("D", 0);
        linhaAutocarro.inserir_paragem("E", 4);

        linhaAutocarro.listar_percurso();
        linhaAutocarro.remover_paragem("B");


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