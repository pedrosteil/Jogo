package InterfaceGrafica;



import Controladores.ControladorTabuleiro;
import DominioDoProblema.ElementoDominioProblema;
import Entidades.Lance;
import Entidades.Tabuleiro;
import br.ufsc.inf.leobr.cliente.Jogada;
import netgames.AtorNetgames;

public class AtorJogador {

    /**
     *
     */
    private ControladorTabuleiro controladorTabuleiro;
    private JPanelTabuleiro interfaceTabuleiro;
    private boolean conectado;
    private int ordem;

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

 

    public AtorJogador(ControladorTabuleiro controladorTabuleiro) {
		
                this.controladorTabuleiro = controladorTabuleiro;
                this.interfaceTabuleiro = new JPanelTabuleiro();
                this.interfaceTabuleiro.setAtor(this);
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
        this.interfaceTabuleiro.atualizarInterface(tabuleiro);
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

    public void selecionarCarta(String carta){
        controladorTabuleiro.selecionarCarta(carta);
    }

    public JPanelTabuleiro getInterfaceTabuleiro() {
        return interfaceTabuleiro;
    }

    public void setInterfaceTabuleiro(JPanelTabuleiro interfaceTabuleiro) {
        this.interfaceTabuleiro = interfaceTabuleiro;
    }

        
        public void iniciarNovaPartida(int posicao, String[] nomeJogadores, AtorNetgames netgames) {
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
        
        public void notificar(String mensagem){
            this.interfaceTabuleiro.notificar(mensagem);
        }
        
        public void moverPecaInicio(String string){
            controladorTabuleiro.moverPecaInicio( string);
        }
}
