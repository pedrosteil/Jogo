package netgames;





import InterfaceGrafica.AtorJogador;
import javax.swing.JOptionPane;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;

public class AtorNetgames implements OuvidorProxy {
	
	private static final long serialVersionUID = 1L;
	protected Proxy proxy;
        private AtorJogador atorJogador;


	
	public AtorNetgames(AtorJogador ator) {
		super();
                this.atorJogador = ator;
		this.proxy = Proxy.getInstance();
		proxy.addOuvinte(this);	
	}
	
    public AtorJogador getAtorJogador() {
        return atorJogador;
    }

    public void setAtorJogador(AtorJogador atorJogador) {
        this.atorJogador = atorJogador;
    }
    
	public String conectar(String servidor, String nome) {
			try {
				proxy.conectar(servidor, nome);
			} catch (JahConectadoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Voce ja esta conectado";
			} catch (NaoPossivelConectarException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Nao foi possivel conectar";
			} catch (ArquivoMultiplayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Voce esqueceu o arquivo de propriedades";
			}
			return "Sucesso: conectado a Netgames Server";
		
	}

	public String desconectar() {
			try {
				proxy.desconectar();
			} catch (NaoConectadoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Voce nao esta conectado";
			}
			return "Sucesso: desconectado de Netgames Server";
	}

	public String iniciarPartida() {
		try {
			proxy.iniciarPartida(new Integer(2)); // supondo 2 jogadores, o que pode ser alterado
		} catch (NaoConectadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Falha ao tentar enviar solicitacao de inicio enviada a Netgames Server";
		}
                this.iniciarNovaPartida(1);
		return "Sucesso: solicitacao de inicio enviada a Netgames Server";
	}

	@Override
        public void iniciarNovaPartida(Integer posicao) {
            String[] nomeJogadores = new String[2];
            nomeJogadores[0] = proxy.getNomeJogador();
           // nomeJogadores[1] = proxy.obterNomeAdversarios().get(0);
            this.atorJogador.iniciarNovaPartida(posicao, nomeJogadores);
        }

	@Override
	public void finalizarPartidaComErro(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receberMensagem(String msg) {
		// TODO Auto-generated method stub
	}

	@Override
	public void receberJogada(Jogada jogada) {
            
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tratarConexaoPerdida() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tratarPartidaNaoIniciada(String message) {
		// TODO Auto-generated method stub
		
	}
	

}
