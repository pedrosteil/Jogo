package Entidades;

import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.ArrayList;

public class Jogador implements Jogada {

    Peça[] peças =  new Peça[4];
    ArrayList<Carta> cartas;
    int cor = 0;
    String nome;
    boolean turno;
    Carta cartaEscolhida;
    Lance lance;

    public Lance getLance() {
        return lance;
    }

    public void setLance(Lance lance) {
        this.lance = lance;
    }

    public Carta getCartaEscolhida() {
        return cartaEscolhida;
    }

    public void setCartaEscolhida(Carta cartaEscolhida) {
        this.cartaEscolhida = cartaEscolhida;
        
    }

    public Jogador() {
    }

    public Jogador(int cor, String nome) {
        this.cor = cor;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }
    
    public void inverterTurno(){
        this.turno = !turno;
    }

    public Jogador(Peça[] peças, ArrayList<Carta> cartas, int cor) {
        this.peças = peças;
        this.cartas = cartas;
        this.cor = cor;
    }

    public Peça[] getPeças() {
        return peças;
    }

    public void setPeças(Peça[] peças) {
        this.peças = peças;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }
    
    
    
}
