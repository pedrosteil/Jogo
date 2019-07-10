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


//o controlador se comunica com o atorjogador e netgames
//recebe e envia solcitacoes do netgames
//envia os estados atuais para a interface via atorjogador
//manipula as entidades, especialmente o tabuleiro que eh enviado para o jogador adversario como jogada


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
            if(this.permitidoIniciarPartida())
                return netgames.iniciarPartida();
            else if (this.informarPartidaAndamento()){
                this.encerrarPartidaLocalmente();
                return netgames.iniciarPartida();
            }
            else
                return "Você não está conectado";
        }
        
        
        public void encerrarPartidaLocalmente(){
            this.tabuleiro = new Tabuleiro();
            this.definirPartidaAndamento(false);
        }
        
        public void definirConectado(){
                this.atorJogador.setConectado(true);
}
        
        public void definirDesconectado(){
            this.atorJogador.setConectado(false);
        }
        
       //instancia os elementos da partida, o jogador de ordem 1 sera tratado como local, e o 2 como remoto
        public void iniciarNovaPartida(int ordem, String[] nomeJogadores) {
            if (ordem == 1) {         
                Tabuleiro varTab = this.getTabuleiro();
                this.tabuleiro.setBaralho(new Baralho());
                this.tabuleiro.setJogadorLocal(new Jogador(1, nomeJogadores[0]));          
                this.tabuleiro.setJogadorRemoto(new Jogador(2, nomeJogadores[1]));
                this.tabuleiro.setPartidaEmAndamento(true); 
                this.tabuleiro.setRodada(1);
                this.iniciarRodada(1);                           
                this.netgames.enviaJogada(varTab);
                this.atorJogador.setOrdem(ordem); 
                atorJogador.atualizarInterface(varTab);
                         
            } else {
                this.atorJogador.setOrdem(ordem);                            
            }
 
    }
        
//inicia a rodada, distruibindo as cartas
        public void iniciarRodada(int rodada){
              //sempre que for rodadas pares o jogador 1 começa
            if(rodada%2 == 0 && rodada != 1){
                this.tabuleiro.getJogadorLocal().setTurno(false);
                this.tabuleiro.getJogadorRemoto().setTurno(true);
            }
            else{
                this.tabuleiro.getJogadorLocal().setTurno(true);
                this.tabuleiro.getJogadorRemoto().setTurno(false);
            }
            
            int cartas;
            
            
            if(rodada > 5)
                //qnd a rodada for maior q 5, pega o modulo da rodada por 5 para saber qnts cartas
                //ex: na rodada 1 e rodada 6, são 5 cartas. 6%5 = 1 logo cartas = 7 - 1
                // na rodada 2 e 7 sao 4.. etc
                rodada = rodada%5;
            cartas = 7 - rodada;
            
          
            this.tabuleiro.getBaralho().embaralha();
            this.tabuleiro.getJogadorLocal().setCartas(this.tabuleiro.getBaralho().getMao(cartas));
            this.tabuleiro.getJogadorRemoto().setCartas(this.tabuleiro.getBaralho().getMao(cartas));  
        }
        
        
        
        public boolean selecionarCarta(String carta){
            Jogador jogador = null;
            ArrayList<Carta> cartas;
            if(!this.atorJogador.isConectado())
                return false;
            else if(!this.informarPartidaAndamento())
                return false;
            else if(carta == ""){
                this.atorJogador.notificar("nao ha carta");
                return false;
            }
            
            if(this.tabuleiro.getJogadorLocal().getCor() == atorJogador.getOrdem()){               
                jogador = this.tabuleiro.getJogadorLocal();
            }
            else {
                jogador = this.tabuleiro.getJogadorRemoto();
            }
  
            if(jogador.isTurno() && jogador.getCartaEscolhida() == null)  {  
                    cartas = jogador.getCartas();
                    if(this.tabuleiro.pecasNoInicio(jogador.getCor())){
                        boolean possui = false;
                        for(int i=0; i<cartas.size(); i++){
                            if(cartas.get(i).getNumero() == 1 || cartas.get(i).getNumero() == 13)
                                possui = true;
                        }       
                        if(possui == false){
                            jogador.descartarMao();
                            this.tabuleiro.inverterTurno();
                            this.atorJogador.notificar("Você não possui cartas para entrar em jogo, cartas descartadas");
                            this.atorJogador.atualizarInterface(tabuleiro);
                            this.netgames.enviaJogada(tabuleiro);
                            return false;
                        }
                        else if(!carta.equalsIgnoreCase("1") && !carta.equalsIgnoreCase("13")){
                                this.atorJogador.notificar("Selecione uma carta de saida");
                                return false;
                            }
                        }

                    for(int i =0 ; i< cartas.size(); i++){
                        Carta cartaMao = cartas.get(i);
                        if(cartaMao.getNumero() == Integer.parseInt(carta)){
                             jogador.setCartaEscolhida(cartaMao);
                             jogador.getCartas().remove(i);
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
        
        public boolean moverPecaInicio(String casaEscolhida){
            
            if(!this.atorJogador.isConectado())
                return false;
            else if(!this.tabuleiro.isPartidaEmAndamento())
                return false;
            
            
            Jogador jogador;
            if(this.tabuleiro.getJogadorLocal().getCor() == this.atorJogador.getOrdem()){
                jogador = this.tabuleiro.getJogadorLocal();
            }
            else
                jogador = this.tabuleiro.getJogadorRemoto();
            
            
            Carta carta = jogador.getCartaEscolhida();
            if(carta == null && jogador.isTurno()){
                this.atorJogador.notificar("Selecione uma carta");
                return false;
            }
            else if(!jogador.isTurno()){
                this.atorJogador.notificar("Vez do oponente");
                return false;
            }
            else if(carta.getNumero() == 1 || carta.getNumero() == 13){
                 ArrayList<String> posicaoPecas = this.tabuleiro.getPosicaoPecas();
                for( int i = 0; i<posicaoPecas.size(); i++){
                    System.out.println(posicaoPecas.get(i) + "" + casaEscolhida);
                    if(posicaoPecas.get(i).equalsIgnoreCase(casaEscolhida)){
                       String novaPosicao = this.moverPeca(casaEscolhida, carta.getNumero(), this.atorJogador.getOrdem());
                       System.out.println(novaPosicao);
                       if(novaPosicao != null){
                           posicaoPecas.set(i, novaPosicao);
                           this.tabuleiro.setPosicaoPecas(posicaoPecas);
                           this.tabuleiro.inverterTurno();
                           jogador.setCartaEscolhida(null);
                           netgames.enviaJogada(tabuleiro);
                           this.atorJogador.atualizarInterface(this.tabuleiro);
                           return true;
                       }
                     
                    } 
               }
            }

                this.atorJogador.notificar("Peça nao pode ser movida");
            return false;
     
        }
        
        public boolean verifificarEncerramento(){
            if( this.tabuleiro.pecasNaCasaFinal(1)){
                this.tabuleiro.setVencedor(this.tabuleiro.getJogadorLocal());
                return true;
            }
            else if(this.tabuleiro.pecasNaCasaFinal(2)){
                this.tabuleiro.setVencedor(this.tabuleiro.getJogadorRemoto());
                return true;
            }
            return false;
        }
        
        public void  atualizarEstado(Tabuleiro tabuleiro){
            this.tabuleiro = tabuleiro;
            this.atorJogador.atualizarInterface(tabuleiro);
            
        }
        
        public String moverPeca(String casa, int numero, int jogador){
            if((casa.equals("cverde1") || casa.equals("cverde2") || casa.equals("cverde3") ||casa.equals("cverde4")) && (numero == 1 || numero == 13) && jogador == 1 )
                return "casa1";
            else if((casa.equals("cvermelho1") || casa.equals("cvermelho2") || casa.equals("cvermelho3") ||casa.equals("cvermelho4")) && (numero == 1 || numero == 13)  && jogador == 2)
                return "casa17";
            else if(casa.contains("casa")){
               int casadestino = Integer.parseInt(casa.substring(4));
               if(jogador == 1){
                   if((casadestino + numero) <= 32)
                       return "casa" + (casadestino + numero);
                   else if ((casadestino + numero) <= 36){
                       return "cverde" + (casadestino + numero - 33);
                   }
                   else
                       return "casa" + (casadestino + numero - 33);
               }
               else{
                   if((casadestino + numero) <= 16 ){
                       return "casa" + (casadestino + numero);
                   }
                   else if ((casadestino < 16 )&& (casadestino + numero <=20))
                       return "cvermelho" + (casadestino + numero - 16);
                   else if((casadestino + numero) <= 32)
                       return "casa" + (casadestino + numero);
                   else
                       return "casa" + (casadestino + numero - 33);
               }
               
            }
            return null;
        }
        public void esvaziar(){
           // this.baralho = null;
            //this.jogadorLocal = null;
//            this.jogadorRemoto = null;

        }
    
}
