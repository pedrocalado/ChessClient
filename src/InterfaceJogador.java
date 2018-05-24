
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceJogador extends Remote {
    void mensagem(String mensagem) throws RemoteException;
}
