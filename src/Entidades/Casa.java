package Entidades;

class Casa {

    Peça peça;
    int posicao;

    public Casa() {
    }

    public Casa(Peça peça, int posicao) {
        this.peça = peça;
        this.posicao = posicao;
    }

    public Peça getPeça() {
        return peça;
    }

    public void setPeça(Peça peça) {
        this.peça = peça;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
    
    
}
