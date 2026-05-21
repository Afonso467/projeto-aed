public class FilaPassageiros {

    private NodePassageiro inicio;
    private NodePassageiro fim;

    public FilaPassageiros() {
        inicio = null;
        fim = null;
    }

    public void adicionarPassageiro(Passageiro p) {

        NodePassageiro novo = new NodePassageiro(p);

        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.next = novo;
            fim = novo;
        }
    }

    public Passageiro removerPassageiro() {

        if (inicio == null) {
            return null;
        }

        Passageiro p = inicio.passageiro;
        inicio = inicio.next;

        if (inicio == null) {
            fim = null;
        }

        return p;
    }

    public int totalPassageiros() {

        int contador = 0;
        NodePassageiro atual = inicio;

        while (atual != null) {
            atual = atual.next;
            contador++;
        }

        return contador;
    }

    public void mostrarFila() {

        if (inicio == null) {

            System.out.println("Sem passageiros.");
            return;
        }

        NodePassageiro atual = inicio;

        while (atual != null) {

            System.out.println("- " +
                    atual.passageiro.get_nome());

            atual = atual.next;
        }
    }
}