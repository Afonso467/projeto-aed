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
    public  Node nodeAtual;

    private boolean sentidoInverso = false;

    public LinhaAutocarro() {
        head = null;
        tail = null;
        nodeAtual = null;
      
    }

    public boolean exists () {
        if (head == null) {
            return false;  
        } 
        return true;
    }

    public void proxima_paragem() {

        exists();

        if(!sentidoInverso) {
            if(nodeAtual.next != null) {
                nodeAtual = nodeAtual.next;
            } else {
                sentidoInverso = true;
                nodeAtual = nodeAtual.prev;
            }
        } else {
            if (nodeAtual.prev != null) {
                nodeAtual = nodeAtual.prev;

            } else {
                sentidoInverso = false;
                nodeAtual = nodeAtual.next;
            }
        }
        System.out.println("O autocarro chegou à estação: " + nodeAtual.paragem.get_nome());
    }

    public void inserir_paragem(String nome) {

        Node novaParagem = new Node(new Paragem(nome));
        Node current = head;

        while (current != null) {
            if(current.paragem.get_nome().equalsIgnoreCase(nome)) {
                System.out.println("Já existe uma paragem com este nome, é favor não repetir nomes.");
                return;
            }
            current = current.next;
        }
        
        if (head == null) {
            nodeAtual = novaParagem;
            head = novaParagem;
            tail = novaParagem;
            
        } else {
            tail.next = novaParagem;
            novaParagem.prev = tail;
            tail = novaParagem;
        }
        // System.out.println("Linha autocarro: Paragem criada");
    }

    public void listar_percurso() {

        Node current = head;

        while (current != null) {

            System.out.println(
                "Nome Paragem: " +
                current.paragem.get_nome() +
                    ", Passageiros: " +
                    current.paragem.fila.totalPassageiros() +
                    (current == nodeAtual ? " <- AUTOCARRO" : "")
            );

            current = current.next;
        }
    }

    public void remover_paragem(String nome) {

        if (head == null) return;

        Node current = head;

        while (current != null) {

            if (current.paragem.get_nome().equalsIgnoreCase(nome)) {

                if (head == tail) {
                    head = null;
                    tail = null;
                }

                else if (current == head) {
                    head = head.next;
                    head.prev = null;
                }

                else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                }

                else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            } 
            current = current.next;
        }

        System.out.println("Paragem não encontrada.");
    }

    public void adicionar_passageiros(String nomeParagem, String nomePassageiro) {

        Node current = head;

        while (current != null) {

            if (current.paragem.get_nome().equalsIgnoreCase(nomeParagem)) {

                current.paragem.adicionar_passageiro(new Passageiro(nomePassageiro));
                System.out.println("Passageiros adicionados à paragem " + nomeParagem);
                return;
            }

            current = current.next;
        }

        System.out.println("Paragem não encontrada.");
    }

    public void ordenar_paragens_por_nome() {

        /* Selection sort */
        if (head == null) {
            System.out.println("Linha vazia.");
            return;
        }

        Node i = head;

        while (i != null) {

            Node j = i.next;

            while (j != null) {

                if (i.paragem.get_nome().compareToIgnoreCase(j.paragem.get_nome()) > 0) {

                    Paragem temp = i.paragem;
                    i.paragem = j.paragem;
                    j.paragem = temp;
                }

                j = j.next;
            }

            i = i.next;
        }

        System.out.println("\nParagens ordenadas por nome:\n");

        listar_percurso(); 
    }

    public void ordenar_paragens_por_num_passageiros() {

        if (head == null) {
            System.out.println("Linha vazia.");
            return;
        }

        boolean trocou;

        do {
            trocou = false;
            Node atual = head;

            while (atual.next != null) {

                if (atual.paragem.get_num_passageiros() < atual.next.paragem.get_num_passageiros()) {

                    Paragem temp = atual.paragem;
                    atual.paragem = atual.next.paragem;
                    atual.next.paragem = temp;

                    trocou = true;
                }

                atual = atual.next;
            }

        } while (trocou);

        System.out.println("\nParagens ordenadas por número de passageiros:\n");
        listar_percurso();
    }
}