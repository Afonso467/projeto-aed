class Node {
    Paragem paragem;
    Node next;
    Node prev;

    Node(Paragem paragem) {
        this.paragem = paragem;
        this.next = null;
        this.prev = null;
    }
}

class LinhaAutocarro {
    private Node head;
    private Node tail;
    private int size;

    public LinhaAutocarro() {
        head = null;
        tail = null;
        size = 0;
    }

    public void inserir_paragem(String nome, int numeroPassageiros) {

        Node novaParagem = new Node(new Paragem(nome, numeroPassageiros));

        if (head == null) {
            head = novaParagem;
            tail = novaParagem;
        } else {

            tail.next = novaParagem;
            novaParagem.prev = tail;
            tail = novaParagem;
        }

        size++;
    }

    public void listar_percurso() {

        Node current = head;

        while (current != null) {

            System.out.println(
                    "Nome Paragem: " +
                            current.paragem.nome +
                            ", Passageiros: " +
                            current.paragem.fila.totalPassageiros());

            current = current.next;
        }
    }

    public void remover_paragem(String nome) {

        if (head == null) {
            return;
        }

        Node current = head;

        while (current != null) {

            if (current.paragem.nome.equals(nome)) {

                // único elemento
                if (head == tail) {
                    head = null;
                    tail = null;
                }

                // remover head
                else if (current == head) {
                    head = head.next;
                    head.prev = null;
                }

                // remover tail
                else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                }

                // remover intermédio
                else {

                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return;
            }
            current = current.next;
        }
    }
}