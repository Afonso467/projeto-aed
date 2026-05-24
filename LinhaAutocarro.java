class Node {
    Paragem paragem;
    Node next;

    Node(Paragem paragem) {
        this.paragem = paragem;
        this.next = null;
    }
}

class LinhaAutocarro {
    private Node head;
    private int size;

    public void inserir_paragem(String nome, int numeroPassageiros) {

        Node novaParagem = new Node(new Paragem(nome, numeroPassageiros));

        if (head == null) {
            head = novaParagem;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = novaParagem;
        }

        size++;
    }

    public void listar_percurso() {

        Node current = head;

        while (current != null) {

            System.out.println(
                    "Nome Paragem: " + current.paragem.nome +
                            ", Numero Passageiros: " + current.paragem.fila.totalPassageiros());

            current = current.next;
        }
    }

    public void remover_paragem(String nome) {

        if (head == null) {
            return;
        }

        // remover cabeça
        if (head.paragem.nome.equals(nome)) {
            head = head.next;
            size--;
            return;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.paragem.nome.equals(nome)) {

                current.next = current.next.next;
                size--;
                return;
            }

            current = current.next;
        }
    }

}