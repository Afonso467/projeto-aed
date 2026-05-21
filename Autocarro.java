public class No {
    Passageiro passageiro; //passageiro objeto/dado
    No proximo; //ligação ao proximo nó

    public No(Passageiro passageiro){
        this.passageiro = passageiro;
        this.proximo = null;
    }
}

public class Autocarro {

    private No inicio; //aponta para o inicio do no ou seja primeiro passageiro
    private int totalPassageiros; //contador de passageiros

    public Autocarro(){
        this.inicio = null;
        this.totalPassageiros = 0;
    }

    public void entrada_passageiros(Passageiro p){

        No novo = new No(p); 

        if (inicio == null){
            inicio = novo; //se o autocarro estiver vazio cria um novo no
        } 

        totalPassageiros++;

        System.out.println(p.getNome() + " entrou no autocarro");
    }

    public void saida_passageiros(String nome){

        if (inicio == null){
            System.out.println("Autocarro vazio");
            return;
        }

        if (inicio.passageiro.getNome().equalsIgnoreCase(nome)){ //remove as pessoas pelo nome, caso 1 ser o primeiro
            System.out.println(inicio.passageiro.getNome() + " saiu do autocarro");
            inicio = inicio.proximo; //remove o 1 nó
            totalPassageiros--;
            return;
        }

        No atual = inicio;

        while (atual.proximo != null){ //procura o nó antes da pessoa
            if (atual.proximo.passageiro.getNome().equalsIgnoreCase(nome)){

                System.out.println(atual.proximo.passageiro.getNome() + " saiu do autocarro");

                atual.proximo = atual.proximo.proximo;
                totalPassageiros--;

                return;
            }

            atual = atual.proximo;
        }

        System.out.println("Passageiro não encontrado");
    }

    public void mostrarPassageiros(){

        No atual = inicio;

        System.out.println("Passageiros no autocarro:");

        while (atual != null){ //percore a lista e imprime nomes
            System.out.println("- " + atual.passageiro.getNome());
            atual = atual.proximo;
        }
    }

    public int getTotalPassageiros(){
        return totalPassageiros;
    }
}
