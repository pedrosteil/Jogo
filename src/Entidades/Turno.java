package Entidades;

public class Turno {
    
    Jogador jogador;
    int numeroTurno;
    Carta carta; 
    Peça peça;

    public Turno() {
    }

    public Turno(Jogador jogador, int numeroTurno, Carta carta, Peça peça) {
        this.jogador = jogador;
        this.numeroTurno = numeroTurno;
        this.carta = carta;
        this.peça = peça;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public int getNumeroTurno() {
        return numeroTurno;
    }

    public void setNumeroTurno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public Peça getPeça() {
        return peça;
    }

    public void setPeça(Peça peça) {
        this.peça = peça;
    }
    
    
}
