/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.ArrayList;

/**
 *
 * @author Carol
 */
public class Lance implements Jogada{
    Peca peca;
    Carta carta;
    String destinoPeca;
    boolean inicioRodada;
    boolean pecaEscolhida;
    boolean cartaEscolhida;
    boolean inicioPartida;
    ArrayList<Carta> mao;
    int cor;

    public boolean isInicioPartida() {
        return inicioPartida;
    }

    public void setInicioPartida(boolean setInicioPartida) {
        this.inicioPartida = setInicioPartida;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public String getDestinoPeca() {
        return destinoPeca;
    }

    public void setDestinoPeca(String destinoPeca) {
        this.destinoPeca = destinoPeca;
    }

    public boolean isInicioRodada() {
        return inicioRodada;
    }

    public void setInicioRodada(boolean inicioRodada) {
        this.inicioRodada = inicioRodada;
    }

    public boolean isPecaEscolhida() {
        return pecaEscolhida;
    }

    public void setPecaEscolhida(boolean pecaEscolhida) {
        this.pecaEscolhida = pecaEscolhida;
    }

    public boolean isCartaEscolhida() {
        return cartaEscolhida;
    }

    public void setCartaEscolhida(boolean cartaEscolhida) {
        this.cartaEscolhida = cartaEscolhida;
    }

    public ArrayList<Carta> getMao() {
        return mao;
    }

    public void setMao(ArrayList<Carta> mao) {
        this.mao = mao;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }
    

    private static class Peca {

        public Peca() {
        }
    }
    
    
}
