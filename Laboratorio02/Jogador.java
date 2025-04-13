/**
    Classe que representa um jogador em um jogo.
*/
public class Jogador {
    
    private String nome;
    private int nivel;
    private Raca raca;
    private Classe classe;
    private Inventario inventario;

    /**
        Construtor da classe Jogador.
    */
    public Jogador (String nome, int nivel, Raca raca, Classe classe, Inventario inventario){
        this.nome = nome;
        this.nivel = nivel;
        this.raca = raca;
        this.classe = classe;
        this.inventario = inventario;
    }

    /**
        Retorna o nome do jogador.
    */
    public String getNome(){
        return nome;
    }

    /**
        Define o nome do jogador.
    */
    public void setName(String novoNome){
        this.nome = novoNome;
    }

    /**
        Retorna o nível do jogador.
    */
    public int getNivel(){
        return nivel;
    }

    /**
        Define o nível do jogador.
    */
    public void setNivel(int novoNivel){
        this.nivel = novoNivel;
    }
    
    /**
        Retorna a raça do jogador.
    */
    public Raca getRaca(){
        return raca;
    }

    /**
        Define a raça do jogador.
    */
    public void setRaca(Raca novaRaca){
        this.raca = novaRaca;
    }

    /**
        Retorna a classe do jogador.
    */
    public Classe getClasse(){
        return classe;
    }

    /**
        Define a classe do jogador.
    */
    public void setClasse(Classe novaClasse){
        this.classe = novaClasse;
    }

    /**
        Retorna o inventário do jogador.
    */
    public Inventario getInventario(){
        return inventario;
    }

    /**
        Define o inventário do jogador.
    */
    public void setInventario(Inventario novoInventario){
        this.inventario = novoInventario;
    }

    /**
        Representação textual da classe Jogador.
    */
    public String toString(){
        return nome + "\n" + nivel + "\n" + raca + "\n" + classe + "\n";
    }

    /**
        Calcula o poder total do jogador.
    */
    public int poderJogador(){
        return nivel + inventario.getInventario().size();
    }
}
