public class LinkedListParagens {
    private NodeParagem head;

    public LinkedListParagens() {
        head = null;
    }

    public void adicionarParagem(Paragem p) {
        NodeParagem novo = new NodeParagem(p);

        if (head == null) {
            head = novo;
            return;
        }

        NodeParagem atual = head;

        while (atual.next != null) {
            atual = atual.next;
        }
        atual.next = novo;
    }

    public void removerParagem(String nome) {

        if (head == null) {
            return;
        }

        // remover head
        if (head.paragem.get_nome().equals(nome)) {
            head = head.next;
            return;
        }

        NodeParagem atual = head;

        while (atual.next != null &&
                !atual.next.paragem.get_nome().equals(nome)) {

            atual = atual.next;
        }

        // encontrou a paragem
        if (atual.next != null) {
            atual.next = atual.next.next;
        }
    }

    public int numero_paragens() {

        int contador = 0;
        NodeParagem atual = head;

        while (atual != null) {
            atual = atual.next;
            contador++;
        }

        return contador;
    }

    /* Selection Sort */
    public void ordenar_por_numero(String nome) {
        NodeParagem atual = head;

        while (atual != null) {

            NodeParagem head = atual;
            NodeParagem next = atual.next;

            while (next != null) {

                if (next.paragem.fila.totalPassageiros() < head.paragem.fila.totalPassageiros()) {
                    head = next;
                }
                next = next.next;
            }

            if (head != atual) {
                Paragem temp = atual.paragem;
                atual.paragem = head.paragem;
                head.paragem = temp;
            }

            atual = atual.next;
        }
    }
}