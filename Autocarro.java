
public class Autocarro {

    private NodeAutocarro inicio; // aponta para o inicio do no ou seja primeiro passageiro
    private int totalPassageiros; // contador de passageiros

    public Autocarro() {
        this.inicio = null;
        this.totalPassageiros = 0;
    }

    public void entrada_passageiros(Passageiro p) {

        NodeAutocarro newNode = new NodeAutocarro(p);

        if (inicio == null) {
            inicio = newNode; // se o autocarro estiver vazio cria um novo no
        }
        totalPassageiros++;

        System.out.println(p.get_nome() + " entrou no autocarro");
    }

    public void saida_passageiros(String nome) {

        if (inicio == null) {
            System.out.println("Autocarro vazio");
            return;
        }

        if (inicio.passageiro.get_nome().equalsIgnoreCase(nome)) { // remove as pessoas pelo nome, caso 1 ser o primeiro
            System.out.println(inicio.passageiro.get_nome() + " saiu do autocarro");
            inicio = inicio.proximo; // remove o 1 nó
            totalPassageiros--;
            return;
        }

        NodeAutocarro atual = inicio;

        while (atual.proximo != null) { // procura o nó antes da pessoa
            if (atual.proximo.passageiro.get_nome().equalsIgnoreCase(nome)) {

                System.out.println(atual.proximo.passageiro.get_nome() + " saiu do autocarro");

                atual.proximo = atual.proximo.proximo;
                totalPassageiros--;

                return;
            }

            atual = atual.proximo;
        }

        System.out.println("Passageiro não encontrado");
    }

    public void mostrarPassageiros() {

        NodeAutocarro atual = inicio;

        System.out.println("Passageiros no autocarro:");

        while (atual != null) { // percore a lista e imprime nomes
            System.out.println("- " + atual.passageiro.get_nome());
            atual = atual.proximo;
        }
    }

    public int getTotalPassageiros() {
        return totalPassageiros;
    }
}
