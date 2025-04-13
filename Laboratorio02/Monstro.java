import java.util.LinkedList;
import java.util.List;

/**
    Classe que representa um monstro em um jogo.
*/
public class Monstro {
    
    private String nome;
    private int poder;
    private List<Item> tesouros;
    private int niveisPerdidos;

    /**
        Construtor da classe Monstro.
    */
    public Monstro(String nome, int poder) {
        this.nome = nome;
        this.poder = poder;
        this.tesouros = new LinkedList<>();
        this.niveisPerdidos = 0;        
    }

    /**
        Retorna o nome do monstro.
    */
    public String getNome(){
        return nome;
    }

    /**
        Define o nome do monstro.
    */
    public void setName(String novoNome){
        this.nome = novoNome;
    }

    /**
        Retorna o poder do monstro.
    */
    public int getPoder(){
        return poder;
    }

    /**
        Define o poder do monstro.
    */
    public void setPoder(int novoPoder){
        this.poder = novoPoder;
    }

    /**
        Retorna a lista de tesouros do monstro.
    */
    public List<Item> getTesouros(){
        return tesouros;
    }

    /**
        Define a lista de tesouros do monstro.
    */
    public void setTesouros(List<Item> novosTesouros){
        this.tesouros = novosTesouros;
    }

    /**
        Retorna os níveis perdidos ao ser derrotado pelo monstro.
    */
    public int getNiveisPerdidos(){
        return niveisPerdidos;
    }

    /**
        Define os níveis perdidos ao ser derrotado pelo monstro.
    */
    public void setNiveisPerdidos(int novoNivelPerdido){
        this.niveisPerdidos = novoNivelPerdido;
    }

    /**
        Representação textual da classe monstro.
    */
    public String toString(){
        return nome + "\n" + poder + "\n" + niveisPerdidos + "\n";
    }
}
