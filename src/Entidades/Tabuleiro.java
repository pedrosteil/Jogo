package Entidades;

import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.ArrayList;


//funciona como um estado atual, é com base no tabuleiro e seus jogadores q o programa sabera qual é o estado atual
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
    
    public void inverterTurno(){
        if(this.jogadorLocal.isDescartado()){
            this.jogadorLocal.setTurno(false);
            this.jogadorRemoto.setTurno(true);
        }
        else if(this.jogadorRemoto.isDescartado()){
            this.jogadorLocal.setTurno(true);
            this.jogadorRemoto.setTurno(false);
        }
        else{
            this.jogadorLocal.inverterTurno();
            this.jogadorRemoto.inverterTurno();
        }
    }

    public boolean pecasNaCasaFinal( int jogador){
        String casa;
        if(jogador == 1){
            casa = "fverde";
        }
        else
            casa = "fvermelho";
        for(int i = 0; i < jogador*4; i++){
            if(this.posicaoPecas.get(i).contains(casa))
                continue;
            else
                return false;
        }
        return true;
    }
    
    public boolean pecasIniciouOuFinal(int jogador){
       
        String casa;
        if(jogador == 1){
            casa = "verde";
        }
        else
            casa = "vermelho";
        for(int i = 0; i < jogador*4; i++){
            if(this.posicaoPecas.get(i).contains(casa))
                continue;
            else
                return false;
        }
        return true;
    }
    
    public boolean pecasNoInicio( int jogador){
        String casa;
        if(jogador == 1){
            casa = "cverde";
        }
        else
            casa = "cvermelho";
        for(int i = jogador*4 - 4 ; i < jogador*4; i++){
            if(this.posicaoPecas.get(i).contains(casa))
                continue;
            else
                return false;
        }
        return true;
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
    
    
    public boolean jogadorPodeMoverPecas(int jogador, int carta){
  
        if(this.pecasNoInicio(jogador) && (carta == 1 || carta == 13))
            return true;
        else if(this.pecasNaCasaFinal(jogador))
            return false;
        
        String casa;
        if(jogador == 1){
            casa = "verde";
        }
        else
            casa = "vermelho";
        
        for(int i = 4*jogador - 4; i < jogador*4; i++){
            String posicao = posicaoPecas.get(i);
          //  System.out.println(posicao);
                if(posicao.contains("casa")){
                    return true;
                }
                else if(posicao.contains("c" + casa) && (carta == 1 || carta ==13)){
                    return true;
                }
                else if(posicao.contains("f" + casa)){
                    int numeroposicao = Integer.parseInt(posicao.substring(casa.length()+1));
                   // System.out.println("numero" + numeroposicao + "carta" + carta);
                    if((numeroposicao + carta) <= 4);
                        return true;
            }
        }
        return false;
    }
    
    
    public boolean podeIniciarNovaRodada(){
        //System.out.println(this.getJogadorLocal().getCartas() + " " + this.getJogadorRemoto().getCartas());
            if(this.getJogadorLocal().getCartas() == null && this.getJogadorRemoto().getCartas() == null) 
                return true;
            else
                return false;
        }
    
    
    
        
}

     
    
    

