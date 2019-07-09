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
    ArrayList<Casa> casas = null;
    ArrayList<Casa> casasInicioVerde = null;
    ArrayList<Casa> casasInicioVermelho = null;

    public ArrayList<Casa> getCasas() {
        return casas;
    }

    public void setCasas(ArrayList<Casa> casas) {
        this.casas = casas;
    }

    public ArrayList<Casa> getCasasInicioVerde() {
        return casasInicioVerde;
    }

    public void setCasasInicioVerde(ArrayList<Casa> casasInicioVerde) {
        this.casasInicioVerde = casasInicioVerde;
    }

    public ArrayList<Casa> getCasasInicioVermelho() {
        return casasInicioVermelho;
    }

    public void setCasasInicioVermelho(ArrayList<Casa> casasInicioVermelho) {
        this.casasInicioVermelho = casasInicioVermelho;
    }
    

    public int getRodada() {
        return rodada;
    }

    public void setRodada(int rodada) {
        this.rodada = rodada;
    }


    public Tabuleiro() {
    }



    public Jogador getJogadorLocal() {
        return jogadorLocal;
    }

    public void setJogadorLocal(Jogador jogadorLocal) {
        this.jogadorLocal = jogadorLocal;
        Peça[] peca = this.jogadorLocal.getPeças();
        for(int i =0; i<peca.length ; i++)
            casasInicioVerde.get(i).setPeça(peca[i]);
        
    }

    public Jogador getJogadorRemoto() {
        return jogadorRemoto;
    }

    public void setJogadorRemoto(Jogador jogadorRemoto) {
        this.jogadorRemoto = jogadorRemoto;
         Peça[] peca = this.jogadorRemoto.getPeças();
        for(int i =0; i<peca.length ; i++)
            casasInicioVerde.get(i).setPeça(peca[i]);
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
    
    public void iniciarTabuleiro(){
        for(int i = 0; i< 32; i++){
            casas.add(new Casa(null, "" + i));
        }
        for(int i =1; i<5; i++){
            casasInicioVerde.add(new Casa(null, "cverde" + i));
        }
          for(int i =1; i<5; i++){
            casasInicioVermelho.add(new Casa(null, "cvernelho" + i));
        }
          for(int i =1; i<5; i++){
            casas.add(new Casa(null, "fverde" + i));
        }
           for(int i =1; i<5; i++){
            casas.add(new Casa(null, "fvernelho" + i));
        }
            
    }

     
    
    
}
