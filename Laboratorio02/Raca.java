/**
    Classe que representa a raça do personagem em um jogo.
*/
public class Raca {

    private String descricao;
    private String nomeDaRaca;
    private int minimoPrafugir;

    /**
        Construtor da classe Raca.
    */
    public Raca(String descricao, String nomeDaRaca, int minimoPrafugir){
        this.descricao = descricao;
        this.nomeDaRaca = nomeDaRaca;
        this.minimoPrafugir = minimoPrafugir;
    }
    
    /**
        Retorna a descrição da raça.
    */
    public String getDescricao(){
        return descricao;
    }

    /**
        Define a descrição da raça.
    */
    public void setDescricao(String novaDescricao){
        this.descricao = novaDescricao;
    }
    
    /**
        Retorna o nome da raça.
    */
    public String getNomeDaRaca(){
        return nomeDaRaca;
    }

    /**
        Define o nome da raça.
    */
    public void setNomeDaRaca(String novoNomeDaRaca){
        this.nomeDaRaca = novoNomeDaRaca;
    }

    /**
        Retorna o valor mínimo para fugir.
    */
    public int getMinimoPrafugir(){
        return minimoPrafugir;
    }

    /**
        Define o valor mínimo para fugir.
    */
    public void setMinimoPrafugir(int novoMinimoPrafugir){
        this.minimoPrafugir = novoMinimoPrafugir;
    }

    /**
        Representação textual da classe Raça.
    */
    public String toString(){
        return descricao + "\n" + nomeDaRaca + "\n" + minimoPrafugir + "\n";
    }
}