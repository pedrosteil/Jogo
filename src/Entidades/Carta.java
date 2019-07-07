package Entidades;

public class Carta {
    
    int numero;
    int naipe;

    public Carta() {
    }

    public Carta(int numero, int naipe) {
        this.numero = numero;
        this.naipe = naipe;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNaipe() {
        return naipe;
    }

    public void setNaipe(int naipe) {
        this.naipe = naipe;
    }
    
    
    
}
