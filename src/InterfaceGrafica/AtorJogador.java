package InterfaceGrafica;



import DominioDoProblema.Controlador;
import Entidades.Lance;
import Entidades.Tabuleiro;
import br.ufsc.inf.leobr.cliente.Jogada;
import netgames.AtorNetgames;

public class AtorJogador {

    /**
     *
     */
    private Controlador controladorTabuleiro;
    private JPanelTabuleiro interfaceTabuleiro;
    private boolean conectado;
    int posicao;


    public AtorJogador(Controlador controladorTabuleiro) {
		
                this.controladorTabuleiro = controladorTabuleiro;
                this.interfaceTabuleiro = new JPanelTabuleiro(this);
                this.interfaceTabuleiro.setAtor(this);
	}
    public String solictarEnderecoServidor() {
        return this.interfaceTabuleiro.solictarEnderecoServidor();
    }

    public String solicitarNomeJogador() {
        return this.interfaceTabuleiro.solicitarNomeJogador();
    }

    public Controlador getControladorTabuleiro() {
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

    public void setControladorTabuleiro(Controlador controladorTabuleiro) {
        this.controladorTabuleiro = controladorTabuleiro;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    public void selecionarCarta(String carta){
        controladorTabuleiro.selecionarCarta(carta);
    }

    public JPanelTabuleiro getInterfaceTabuleiro() {
        return interfaceTabuleiro;
    }

    public void setInterfaceTabuleiro(JPanelTabuleiro interfaceTabuleiro) {
        this.interfaceTabuleiro = interfaceTabuleiro;
    }

        
        public void iniciarNovaPartida(int posicao, String[] nomeJogadores) {
                controladorTabuleiro.iniciarNovaPartida(posicao, nomeJogadores);
    }
        
        public String conectar(String servidor, String nome){
            return controladorTabuleiro.conectar(servidor, nome);
        }
        
        public String desconectar(){
            return controladorTabuleiro.desconectar();
        }
        
        public String iniciarPartida(){
            return controladorTabuleiro.iniciarPartida();
        }

}
