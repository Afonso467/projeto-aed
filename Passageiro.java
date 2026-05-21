public class Passageiro {
    String nome; //guarda o nome do passageiro

    public Passageiro(String p_nome) { 
        this.nome = p_nome; //cria o passageiro e damos o nome
    }

    public String getNome() {
        return this.nome; //permite ler o nome do passageiro
    }
}
