
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JTextArea;

public class ClienteRemote extends UnicastRemoteObject implements InterfaceJogador {
    private GUI cliente;
    private JTextArea txtArea;
    
    ClienteRemote(GUI cliente, JTextArea txtArea) throws RemoteException {
        super();
        this.cliente = cliente;
        this.txtArea = txtArea;
    }
    
    @Override
    public void mensagem(String mensagem) throws RemoteException {
        txtArea.append(mensagem);
    }
}
