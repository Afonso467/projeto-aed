import java.util.Scanner;

/**
 * Menu principal do sistema de gestão de linha de autocarro.
 */
public class Main {

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
                    System.out.println(">> Criar linha de autocarro");
                    break;

                case 2:
                    System.out.println(">> Adicionar/remover paragens");
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
                    System.out.println(">> Mostrar estado atual");
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

    public void criarLinha() {
        return;
    }

    public void mudarParagens() {
        return;
    }

    public void adicionarPassageiros(String nome) {
        return;
    }

    public void simularChegada() {
        return;
    }

    public void ordenarParagens(int order) {
        return;
    }

    public void estadoLinha() {
        return;
    }
}