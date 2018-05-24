
import java.io.Serializable;

public class Jogador implements Serializable {

    private String nome;
    private InterfaceJogador refJogador;

    public Jogador(String nome, InterfaceJogador refJogador) {
        this.nome = nome;
        this.refJogador = refJogador;
    }

    public String getNome() {
        return this.nome;
    }

    public InterfaceJogador getRefJogador() {
        return this.refJogador;
    }
}
