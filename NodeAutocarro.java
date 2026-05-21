public class NodeAutocarro {
    Passageiro passageiro; // passageiro objeto/dado
    NodeAutocarro proximo; // ligação ao proximo nó

    public NodeAutocarro(Passageiro passageiro) {
        this.passageiro = passageiro;
        this.proximo = null;
    }
}