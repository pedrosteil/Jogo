package Entidades;

import br.ufsc.inf.leobr.cliente.Jogada;


//ate o momento n esta sendo usada
public class Casa implements Jogada {

    Peça peça;
    String posicao;

    public Casa() {
    }

    public Casa(Peça peça, String posicao) {
        this.peça = peça;
        this.posicao = posicao;
    }

    public Peça getPeça() {
        return peça;
    }

    public void setPeça(Peça peça) {
        this.peça = peça;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
    
    
}
