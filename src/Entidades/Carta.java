package Entidades;

import javax.swing.Icon;

public class Carta {
    
    int numero;
    int naipe;
    Icon icone;

    public Icon getIcone() {
        return icone;
    }

    public void setIcone(Icon icone) {
        this.icone = icone;
    }

    public Carta() {
    }

    public Carta(int numero, int naipe, Icon icone) {
        this.numero = numero;
        this.naipe = naipe;
        this.icone = icone;
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
