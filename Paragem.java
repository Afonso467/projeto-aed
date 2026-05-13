/* Representação da linha  */
/*  Fila - First in | first out */

public class Paragem {

    /**
     * Classe para criar uma 'Paragem', semelhante à sua versão na vida
     * 
     * @param nome                 : nome da paragem
     * @param nPassageirosEmEspera : numero de passageiros em espera
     **/
    String nome;
    int nPassageirosEmEspera;

    public Paragem(String nome, int nPassageiros) {
        this.nome = nome;
        this.nPassageirosEmEspera = nPassageiros;
    }

    public void adicionar_passageiro(String nome) {
        /**
         * Método para adicionar passageiro (singular) à classe 'Paragem'
         * 
         * @param nome : nome do passageiro
         *
         **/
        this.nPassageirosEmEspera++;
    }

    public void remover_passageiros(int nRemocao) {

        if (nRemocao > nPassageirosEmEspera) {
            System.out.print("Impossivel remover mais passageiros do que existem");
        }

        nPassageirosEmEspera -= nRemocao;
    }

    public void numero_passageiros_em_espera() {

    }
}