package Entidades;

import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.ArrayList;

public class Tabuleiro implements Jogada {


    Jogador jogadorLocal;
    Jogador jogadorRemoto;
    Baralho baralho;
    boolean partidaEmAndamento = false;
    Jogador vencedor = null;
    int rodada;
    ArrayList<String> posicaoPecas = null;



    public int getRodada() {
        return rodada;
    }

    public void setRodada(int rodada) {
        this.rodada = rodada;
    }


    public Tabuleiro() {
        this.posicaoPecas = new ArrayList<String>();
        this.posicaoPecas.add("cverde1");
        this.posicaoPecas.add("cverde2");
        this.posicaoPecas.add("cverde3");
        this.posicaoPecas.add("cverde4");
        this.posicaoPecas.add("cvermelho1");
        this.posicaoPecas.add("cvermelho2");
        this.posicaoPecas.add("cvermelho3");
        this.posicaoPecas.add("cvermelho4");

    }

    public ArrayList<String> getPosicaoPecas() {
        return posicaoPecas;
    }

    public void setPosicaoPecas(ArrayList<String> posicaoPecas) {
        this.posicaoPecas = posicaoPecas;
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
}

     
    
    

