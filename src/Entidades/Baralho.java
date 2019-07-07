package Entidades;

import java.util.ArrayList;
import java.util.Collections;

class Baralho {

    ArrayList<Carta> cartas = new ArrayList<Carta>();

    public Baralho() {
    }

    public Baralho(ArrayList<Carta> cartas) {
        
        this.cartas = cartas;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }
    
    private void createCartas(){
        for( int naipe = 0; naipe < 4; naipe++){
            for(int i= 1; i < 14; i++ ){
                Carta carta = new Carta(i, naipe);
                cartas.add(carta);
            }
        }
    }
    
    public ArrayList<Carta> embaralha(){
        ArrayList<Carta> embaralhadas = cartas;
        Collections.shuffle(embaralhadas);
        return embaralhadas;
    }
    
    public ArrayList<Carta> getMao(int quantidade){
        ArrayList<Carta> cartas = this.embaralha();
        ArrayList<Carta> mao = new ArrayList<Carta>();
        for(int i=0; i < quantidade ; i = i++){
            mao.add(cartas.get(i));
        }
        return mao;
    }
    
}

