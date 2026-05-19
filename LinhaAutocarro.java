class Node {
    String nome;
    int numeroPassageiros;
    Node next;

    Node(String nome, int numeroPassageiros) {
        this.nome = nome;
        this.numeroPassageiros = numeroPassageiros;
        this.next = null;
    }
}

class LinhaAutocarro {
    private Node head;
    private int size;

    public void inserir_paragem(String nome, int numeroPassageiros) {
        Node newNode = new Node(nome, numeroPassageiros);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        size++;
    }

    public void listar_percurso() {
        Node current = head;

        while (current != null) {
            System.out.println(
                "Nome Paragem: " + current.nome +
                ", Numero Passageiros em espera: " + current.numeroPassageiros
            );

            current = current.next;
        }
    }

    public void remover_paragem(String nome) {
        if (head == null) return;

        if (head.nome.equals(nome)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (head.nome.equals(nome)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

}