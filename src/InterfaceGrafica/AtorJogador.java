package InterfaceGrafica;



import DominioDoProblema.ElementoDominioProblema;
import Entidades.Lance;
import Entidades.Tabuleiro;
import br.ufsc.inf.leobr.cliente.Jogada;
import netgames.AtorNetgames;

public class AtorJogador {
	
	protected AtorNetgames ngServer;

    /**
     *
     */
    private ControladorTabuleiro controladorTabuleiro;
    private InterfaceTabuleiro interfaceTabuleiro;
    private boolean conectado;
    int posicao;

    public AtorNetgames getNgServer() {
        return ngServer;
    }

    public void setNgServer(AtorNetgames ngServer) {
        this.ngServer = ngServer;
    }

    public AtorJogador(ControladorTabuleiro controladorTabuleiro, InterfaceTabuleiro interfaceTabuleiro) {
		
                this.controladorTabuleiro = controladorTabuleiro;
                this.interfaceTabuleiro = interfaceTabuleiro;
	}
    public String solictarEnderecoServidor() {
        return this.interfaceTabuleiro.solictarEnderecoServidor();
    }

    public String solicitarNomeJogador() {
        return this.interfaceTabuleiro.solicitarNomeJogador();
    }

    public ControladorTabuleiro getControladorTabuleiro() {
        return controladorTabuleiro;
    }
    
    public void atualizarInterface(Tabuleiro tabuleiro){
        this.interfaceTabuleiro.atualizarInterface(tabuleiro, posicao);
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public void setControladorTabuleiro(ControladorTabuleiro controladorTabuleiro) {
        this.controladorTabuleiro = controladorTabuleiro;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    public String conectar(String servidor, String nomeJogador) {
		String mensagem = "Condicao para conexao nao atendida (defina qual)";
		boolean permitido = controladorTabuleiro.permitidoConectar();
		if (permitido) {
			mensagem = ngServer.conectar(servidor, nomeJogador);
			if (mensagem.equals("Sucesso: conectado a Netgames Server")) {
				controladorTabuleiro.definirConectado(true);
                                this.conectado = true;
			}
		}
		return mensagem;
	}
	
	public String desconectar() {
		String mensagem = "Condicao para desconexao nao atendida (defina qual)";
		boolean permitido = controladorTabuleiro.permitidoDesconectar();
		if (permitido) {
			mensagem = ngServer.desconectar();
			if (mensagem.equals("Sucesso: desconectado de Netgames Server")) {
				controladorTabuleiro.definirConectado(false);
			}
		}
		return mensagem;
	}
	
	public String iniciarPartida() {
             
		String mensagem = "Condicao para iniciar partida nao atendida (defina qual)";
		boolean permitido = controladorTabuleiro.estaConectado();
               
		if (permitido) {
			permitido = controladorTabuleiro.informarPartidaAndamento();
                        if(!permitido){
                            mensagem = ngServer.iniciarPartida();
                            return mensagem;
                        }
                        else{
                            mensagem = "Partida em andamento";
                            return mensagem;
                        }
		}
                else{
                    mensagem = "Você nao esta conectado";
                }
		return mensagem;
	}
        
        public void receberJogada(){
            ngServer.receberJogada(null);
        }
        
        
        public void iniciarNovaPartida(int posicao, String[] nomeJogadores) {
                controladorTabuleiro.iniciarNovaPartida(posicao, nomeJogadores);
    }

}
