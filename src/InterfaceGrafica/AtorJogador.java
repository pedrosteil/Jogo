package InterfaceGrafica;



import DominioDoProblema.ElementoDominioProblema;
import netgames.AtorNetgames;

public class AtorJogador {
	
	protected AtorNetgames ngServer;

    /**
     *
     */
    private Tabuleiro interfaceTabuleiro;
    private ControladorTabuleiro controladorTabuleiro;

    public AtorJogador(ControladorTabuleiro controladorTabuleiro) {
		this.ngServer = new AtorNetgames();
		this.interfaceTabuleiro = new Tabuleiro();
                this.controladorTabuleiro = controladorTabuleiro;
	}
    public String solictarEnderecoServidor() {
        return this.interfaceTabuleiro.solictarEnderecoServidor();
    }

    public String solicitarNomeJogador() {
        return this.interfaceTabuleiro.solicitarNomeJogador();
    }

    public String conectar(String string, String string2) {
		String mensagem = "Condicao para conexao nao atendida (defina qual)";
		boolean permitido = controladorTabuleiro.permitidoConectar();
		if (permitido) {
			mensagem = ngServer.conectar(string, string2);
			if (mensagem.equals("Sucesso: conectado a Netgames Server")) {
				controladorTabuleiro.definirConectado(true);
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
		boolean permitido = controladorTabuleiro.permitidoIniciarPartida();
		if (permitido) {
			mensagem = ngServer.iniciarPartida();
		}
		return mensagem;
	}

}
