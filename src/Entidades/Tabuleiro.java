package Entidades;

import java.util.ArrayList;

public class Tabuleiro {

    ArrayList<Casa> casas;
    Jogador jogador1;
    Jogador jogador2;
    Baralho baralho;
    boolean partidaEmAndamento;
    Jogador vencedor;
    ArrayList<Peça> peças;

    public Tabuleiro() {
    }

    public Tabuleiro(ArrayList<Casa> casas, Jogador jogador1, Jogador jogador2, Baralho baralho, boolean partidaEmAndamento, Jogador vencedor, ArrayList<Peça> peças) {
        this.casas = casas;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.baralho = baralho;
        this.partidaEmAndamento = partidaEmAndamento;
        this.vencedor = vencedor;
        this.peças = peças;
    }

    public ArrayList<Casa> getCasas() {
        return casas;
    }

    public void setCasas(ArrayList<Casa> casas) {
        this.casas = casas;
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }

    public Baralho getBaralho() {
        return baralho;
    }

    public void setBaralho(Baralho baralho) {
        this.baralho = baralho;
    }

    public boolean isPartidaEmAndamento() {
        return partidaEmAndamento;
    }

    public void setPartidaEmAndamento(boolean partidaEmAndamento) {
        this.partidaEmAndamento = partidaEmAndamento;
    }

    public Jogador getVencedor() {
        return vencedor;
    }

    public void setVencedor(Jogador vencedor) {
        this.vencedor = vencedor;
    }

    public ArrayList<Peça> getPeças() {
        return peças;
    }

    public void setPeças(ArrayList<Peça> peças) {
        this.peças = peças;
    }
    
    
    
}
