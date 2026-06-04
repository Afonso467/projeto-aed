
public class Autocarro {

    private NodeAutocarro inicio; // aponta para o inicio do no ou seja primeiro passageiro
    private int totalPassageiros; // contador de passageiros
    private NodeAutocarro fim;

    public Autocarro() {
        this.inicio = null;
        this.fim = null;
        this.totalPassageiros = 0;
    }

    public void entrada_passageiros(LinhaAutocarro linhaAutocarro, int nPassageiros) {

        Paragem paragemAtual = linhaAutocarro.nodeAtual.paragem;
        if(nPassageiros > paragemAtual.get_num_passageiros()) {
            System.out.println("Não é possiver entrar mais passageiros no autocarro do que existem na paragem");
            return;
        }

        for (int i = 0; i < nPassageiros; i++) {

            Passageiro p = paragemAtual.fila.removerPassageiro();
            NodeAutocarro novo = new NodeAutocarro(p);

            if (inicio == null) {
                inicio = novo;
                fim = novo;

            } else {
                fim.proximo = novo;
                fim = novo;
            }
            totalPassageiros++;

            System.out.println(p.get_nome() +" entrou no autocarro.");
        }
    }
    public void saida_passageiros(LinhaAutocarro linhaAutocarro, int nPassageiros) {
        Paragem paragemAtual = linhaAutocarro.nodeAtual.paragem;
        if(nPassageiros > totalPassageiros) {
            System.out.println("Não é possiver remover mais passageiros do que existem");
            return;
        }

        for (int i = 0; i < nPassageiros; i++) {

            if (inicio == null) {
                return;
            }

            Passageiro p = inicio.passageiro;
            inicio = inicio.proximo;

            if (inicio == null) {
                fim = null;
            }

            totalPassageiros--;
            paragemAtual.adicionar_passageiro(p);

            System.out.println(p.get_nome() +" saiu do autocarro.");
        }
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
