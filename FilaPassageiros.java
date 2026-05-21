public class FilaPassageiros {

    private NoPassageiro inicio;
    private NoPassageiro fim;

    public FilaPassageiros() {
        inicio = null;
        fim = null;
    }

    public void adicionarPassageiro(String nome) {

        Passageiro p = new Passageiro(nome);

        NoPassageiro novo = new NoPassageiro(p);

        if (inicio == null) {

            inicio = novo;
            fim = novo;

        } else {

            fim.proximo = novo;
            fim = novo;
        }
    }

    public Passageiro embarcarPassageiro() {

        if (inicio == null) {
            return null;
        }

        Passageiro p = inicio.passageiro;

        inicio = inicio.proximo;

        if (inicio == null) {
            fim = null;
        }

        return p;
    }

    public int totalPassageiros() {

        int contador = 0;

        NoPassageiro atual = inicio;

        while (atual != null) {

            contador++;

            atual = atual.proximo;
        }

        return contador;
    }

    public void mostrarFila() {

        if (inicio == null) {

            System.out.println("Sem passageiros.");
            return;
        }

        NoPassageiro atual = inicio;

        while (atual != null) {

            System.out.println("- " +
                    atual.passageiro.getNome());

            atual = atual.proximo;
        }
    }
}