package Entidades;

import java.util.ArrayList;

public class Tabuleiro {

    ArrayList<Casa> casas;
    Jogador jogadorLocal;
    Jogador jogadorRemoto;
    Baralho baralho;
    boolean partidaEmAndamento = false;
    Jogador vencedor = null;
    ArrayList<Peça> peças;

    public Tabuleiro() {
    }

    public Tabuleiro(ArrayList<Casa> casas, Jogador jogador1, Jogador jogador2, Baralho baralho, boolean partidaEmAndamento, Jogador vencedor, ArrayList<Peça> peças) {
        this.casas = casas;
        this.jogadorLocal = jogador1;
        this.jogadorRemoto = jogador2;
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

    public Jogador getJogadorLocal() {
        return jogadorLocal;
    }

    public void setJogadorLocal(Jogador jogadorLocal) {
        this.jogadorLocal = jogadorLocal;
    }

    public Jogador getJogadorRemoto() {
        return jogadorRemoto;
    }

    public void setJogadorRemoto(Jogador jogadorRemoto) {
        this.jogadorRemoto = jogadorRemoto;
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
