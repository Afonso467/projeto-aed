/* Representação da linha  */
/*  Fila - First in | first out */

public class Paragem {

    String nome;
    FilaPassageiros fila;

    public Paragem(String nome) {
        this.nome = nome;
        this.fila = new FilaPassageiros();
    }

    public void adicionar_passageiro(Passageiro p) {
        fila.adicionarPassageiro(p);
    }

    public void remover_passageiro() {
        fila.removerPassageiro();
    }

    public void passageiros_em_espera(Paragem p) {
        System.out.print("Nª em espera: " + fila.totalPassageiros());
    }

    public void mostrar_fila() {
        fila.mostrarFila();
    }

    public String get_nome() {
        return nome;
    }
}