package Controladores;


import Entidades.Baralho;
import Entidades.Carta;
import Entidades.Casa;
import Entidades.Jogador;
import Entidades.Lance;
import Entidades.Peça;
import Entidades.Tabuleiro;
import InterfaceGrafica.AtorJogador;

import netgames.AtorNetgames;
import Entidades.Tabuleiro;
import java.util.ArrayList;



public class ControladorTabuleiro {

    private Tabuleiro tabuleiro;
    	private AtorJogador atorJogador;
        private AtorNetgames netgames;

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public AtorNetgames getNetgames() {
        return netgames;
    }

    public void setNetgames(AtorNetgames netgames) {
        this.netgames = netgames;
    }

    public ControladorTabuleiro() {
        this.atorJogador = new AtorJogador(this);
       this.netgames = new AtorNetgames(this);
       this.tabuleiro = new Tabuleiro();
    }
    
    public void encerrarHavendoPartida(){}
    
    public boolean escolherCarta(){return true;}
    
    public void movimentoMaximoPeça(int peça){}

    public void notificar(String notificacao){}
    
    public int verificarCartasAtivas(){return 1;}
    
    public void cartaSelecionada(int carta){}
    
    public boolean verificarCartaSelecionada(int cartaSelecionada){return true;}
    
    public boolean escolherPeça(){return true;}
    
    public void verificarPeçasAtivas(){}
    
    public void setPeçaEscolhida(int peça){}
    
    public boolean verificarPeçaEscolhida(int peçaEscolhida){return true;}
    
     public void definirConectado(boolean valor) {
		this.atorJogador.setConectado(valor);
	}
	
	public boolean estaConectado() {
		return this.atorJogador.isConectado();
	}
	
	public void definirPartidaAndamento(boolean valor) {
		tabuleiro.setPartidaEmAndamento(valor);
	}
	
	public boolean informarPartidaAndamento() {
		return tabuleiro.isPartidaEmAndamento();
	}
	
	public boolean permitidoConectar() {
		return !atorJogador.isConectado();
		// defina a lgica do seu jogo
	}
	
	public boolean permitidoDesconectar() {
		return atorJogador.isConectado();
		// defina a lgica do seu jogo
	}
        

	public boolean permitidoIniciarPartida() {
            if(atorJogador.isConectado()){
		return !tabuleiro.isPartidaEmAndamento();
            }
            else
                return false;
		// defina a lgica do seu jogo
	}
        
        public Baralho getBaralho() {
           return tabuleiro.getBaralho();
    }

    public void setBaralho(Baralho baralho) {
        this.tabuleiro.setBaralho(baralho);
    }



    public void setPartidaAndamento(boolean partidaAndamento) {
        this.tabuleiro.setPartidaEmAndamento(partidaAndamento);
    }


    public void setConectado(boolean conectado) {
        this.atorJogador.setConectado(conectado);
    }

    public AtorJogador getAtorJogador() {
        return atorJogador;
    }

    public void setAtorJogador(AtorJogador atorJogador) {
        this.atorJogador = atorJogador;
    }
        
          public String conectar(String servidor, String nome){
            return netgames.conectar(servidor, nome);
        }
        
        public String desconectar(){
            return netgames.desconectar();
        }
        
        public String iniciarPartida(){
            return netgames.iniciarPartida();
        }
        
        public void iniciarNovaPartida(int ordem, String[] nomeJogadores) {
            if (ordem == 1) {         
                Tabuleiro varTab = this.getTabuleiro();
                this.tabuleiro.setBaralho(new Baralho());
                this.tabuleiro.setJogadorLocal(new Jogador(1, nomeJogadores[0]));          
                this.tabuleiro.setJogadorRemoto(new Jogador(2, nomeJogadores[1]));
                this.tabuleiro.setPartidaEmAndamento(true); 
                this.tabuleiro.setRodada(1);
                this.iniciarRodada(6);                           
                this.tabuleiro.getJogadorLocal().setTurno(true);
                this.tabuleiro.getJogadorRemoto().setTurno(false);
                this.netgames.enviaJogada(varTab);
                this.atorJogador.setOrdem(ordem); 
                atorJogador.atualizarInterface(varTab);
                         
            } else {
                this.atorJogador.setOrdem(ordem);                            
            }
 
    }
        

        public void iniciarRodada(int rodada){
            int cartas;
            if(rodada > 5)
                rodada = rodada%5;
            cartas = 7 - rodada;
            this.tabuleiro.getBaralho().embaralha();
            this.tabuleiro.getJogadorLocal().inverterTurno();
            this.tabuleiro.getJogadorRemoto().inverterTurno();
            this.tabuleiro.getJogadorLocal().setCartas(this.tabuleiro.getBaralho().getMao(cartas));
            this.tabuleiro.getJogadorRemoto().setCartas(this.tabuleiro.getBaralho().getMao(cartas));  
        }
        
        public void selecionarCarta(String carta){
            Jogador jogador = null;
            ArrayList<Carta> cartas;
            if(this.tabuleiro.getJogadorLocal().getCor() == atorJogador.getOrdem()){               
                jogador = this.tabuleiro.getJogadorLocal();
            }
            else {
                jogador = this.tabuleiro.getJogadorRemoto();
            }
                
            if(jogador.isTurno())  {  
                cartas = jogador.getCartas();
            
                for(int i =0 ; i< cartas.size(); i++){
                    Carta cartaMao = cartas.get(i);
                    if(cartaMao.getNumero() == Integer.parseInt(carta)){
                         jogador.setCartaEscolhida(cartaMao);
                         jogador.getCartas().remove(i);
                    }
                    
                }
                 this.netgames.enviaJogada(this.tabuleiro);
                 this.atorJogador.atualizarInterface(this.tabuleiro);
            }
            else
                atorJogador.notificar("Vez do oponente");
               
           
        }
        
        public boolean moverPecaInicio(String casaEscolhida){
            Jogador jogador = null;
            ArrayList<Casa> casas;
            if(this.tabuleiro.getJogadorLocal().getCor() == atorJogador.getOrdem()){               
                jogador = this.tabuleiro.getJogadorLocal();
                casas = this.tabuleiro.getCasasInicioVerde();
               
            }
            else {
                jogador = this.tabuleiro.getJogadorRemoto();
                casas = this.tabuleiro.getCasasInicioVermelho();
            }
            
            Casa casa = null;
            if(jogador.isTurno())  {  
                if(jogador.getCartaEscolhida() != null){
                    if(jogador.getCartaEscolhida().getNumero() == 1 || jogador.getCartaEscolhida().getNumero() == 13){
                        for(int i = 0; i< casas.size() ; i++){
                            if(casas.get(i).getPosicao() == casaEscolhida){
                              if( casas.get(i).getPeça() != null){
                                  atorJogador.notificar("Não há peças na casa selecionada");
                                     return false;
                                 }
                              else{
                                  casa = casas.get(i);
                                 break;
                                }
                            }
                        }
                        jogador.setLance(new Lance());
                        jogador.getLance().setPecaEscolhida(true);
                        jogador.getLance().setPeca(casa.getPeça());
                        jogador.getLance().setDestinoPeca("1");
                    }
                    
                }
                    
                 this.netgames.enviaJogada(this.tabuleiro);
                 this.atorJogador.atualizarInterface(this.tabuleiro);
                 return true;
            }
            else{
                atorJogador.notificar("Vez do oponente");
                   return false;
            }
        }
        
        public void  atualizarEstado(Tabuleiro tabuleiro){
            this.tabuleiro = tabuleiro;
            this.atorJogador.atualizarInterface(tabuleiro);
            
        }
        public void esvaziar(){
           // this.baralho = null;
            //this.jogadorLocal = null;
//            this.jogadorRemoto = null;

        }
    
}
