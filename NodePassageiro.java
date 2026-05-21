public class NodePassageiro {
    Passageiro passageiro;
    NodePassageiro next;

    public NodePassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
        this.next = null;
    }
}
