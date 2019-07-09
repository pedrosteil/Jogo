package DominioDoProblema;

import Entidades.Baralho;
import Entidades.Jogador;
import Entidades.Lance;
import Entidades.Tabuleiro;
import InterfaceGrafica.AtorJogador;
import netgames.AtorNetgames;

public class Controlador {
	
	protected boolean conectado = false;
	protected boolean partidaAndamento = false;
        private AtorJogador atorJogador;
        private Tabuleiro tabuleiro;
        private AtorNetgames netgames;

              

	public Controlador() {
		// TODO Auto-generated constructor stub
            atorJogador = new AtorJogador(this);
                netgames = new AtorNetgames( this);             
                tabuleiro = new Tabuleiro();
	}

	public void definirConectado(boolean valor) {
		conectado = valor;
	}
	
	public boolean estaConectado() {
		return conectado;
	}
	
	public void definirPartidaAndamento(boolean valor) {
		partidaAndamento = valor;
	}
	
	public boolean informarPartidaAndamento() {
		return partidaAndamento;
	}
	
	public boolean permitidoConectar() {
		return !conectado;
		// defina a lgica do seu jogo
	}
	
	public boolean permitidoDesconectar() {
		return conectado;
		// defina a lgica do seu jogo
	}

	public boolean permitidoIniciarPartida() {
		return !partidaAndamento;
		// defina a lgica do seu jogo
	}
        
 /*       public void definirConectado(boolean valor) {
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
        */
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
        
        public String iniciarPartida(){
            return netgames.iniciarPartida();
        }
        
        public void iniciarNovaPartida(int ordem, String[] nomeJogadores) {
            if (ordem == 1) {
                this.tabuleiro = new Tabuleiro();
                this.tabuleiro.setBaralho(new Baralho());
                this.tabuleiro.setJogadorLocal(new Jogador());
                tabuleiro.getJogadorLocal().setNome(nomeJogadores[0]);
                this.tabuleiro.setJogadorRemoto(new Jogador());
                this.tabuleiro.getJogadorRemoto().setNome(nomeJogadores[1]);       
                this.tabuleiro.setPartidaEmAndamento(true);
                Lance lance = new Lance();
                this.iniciarRodada(6);
                lance.setInicioPartida(true);
                lance.setMao(this.tabuleiro.getJogadorRemoto().getCartas());
                lance.setInicioRodada(true);
                atorJogador.setPosicao(ordem);                
                tabuleiro.getJogadorLocal().setTurno(true);
                this.tabuleiro.getJogadorRemoto().setTurno(false);            
                lance.setTabuleiro(tabuleiro);
                netgames.enviaJogada(tabuleiro);
                atorJogador.atualizarInterface(lance.getTabuleiro());
                           
            } else {
                atorJogador.setPosicao(ordem);
                
                
            }
    }
        

        public void iniciarRodada(int rodada){
            this.tabuleiro.getBaralho().embaralha();
            this.tabuleiro.getJogadorLocal().inverterTurno();
            this.tabuleiro.getJogadorLocal().setCartas(this.tabuleiro.getBaralho().getMao(rodada));
            this.tabuleiro.getJogadorRemoto().setCartas(this.tabuleiro.getBaralho().getMao(rodada));
            
            
        }
        
        public void selecionarCarta(String carta){
            Lance lance = new Lance();{
            lance.setTabuleiro(tabuleiro);
            lance.setCartaEscolhida(true);
            netgames.enviaJogada(tabuleiro);
        }
        }
        
        public void  atualizarEstado(Lance lance){
            
        }
        public void esvaziar(){
           // this.baralho = null;
            //this.jogadorLocal = null;
//            this.jogadorRemoto = null;

        }
        
        public String conectar(String servidor, String nome){
            return netgames.conectar(servidor, nome);
        }
        
        public String desconectar(){
            return netgames.desconectar();
        }
  


}
