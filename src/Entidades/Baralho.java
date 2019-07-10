package Entidades;

import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.ArrayList;
import java.util.Collections;

public class Baralho implements Jogada{

    ArrayList<Carta> cartas = new ArrayList<Carta>();
    ArrayList<Carta> monte = new ArrayList<Carta>();

    
    public Baralho() {
        createCartas();
        monte = cartas;
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
                Carta carta = new Carta(i, naipe, null);
                cartas.add(carta);
            }
        }
    }
    
    public ArrayList<Carta> embaralha(){
       this.monte = cartas;
        Collections.shuffle(monte);
        return monte;
    }
    
    public ArrayList<Carta> getMao(int quantidade){
        this.embaralha();
        ArrayList<Carta> cartas = monte;
        ArrayList<Carta> mao = new ArrayList<Carta>();
        for(int i=0; i < quantidade ; i++){
            System.out.println(i);
            mao.add(cartas.get(0));
            monte.remove(0);
        }
        return mao;
    }
    
}

