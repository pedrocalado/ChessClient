
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceServidor extends Remote {
    Jogador obtemJogador(String nome) throws RemoteException;
    void login(Jogador jogador) throws RemoteException;
    void logout(Jogador jogador) throws RemoteException;
    void mensagem(String mensagem, String nomeJogador) throws RemoteException;
}
