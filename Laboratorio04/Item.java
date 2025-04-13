import java.util.LinkedList;
import java.util.List;

/**
    Classe que representa um item em um jogo.
*/
public class Item {
    
    private String nome;
    private int bonusPoder;
    private int valor;
    private TipoItem tipo;
    private boolean itemGrande;
    private List<Classe> classesCompativeis;
    private List<Raca> racasCompativeis;

    /**
        Construtor da classe Item.
    */
    public Item (String nome, int bonusPoder, int valor, TipoItem tipo, boolean itemGrande) {
        
        this.nome = nome;
        this.bonusPoder = bonusPoder;
        this.valor = valor;
        this.tipo = tipo;      
        this.classesCompativeis = new LinkedList<>();
        this.racasCompativeis = new LinkedList<>();
        this.itemGrande = itemGrande;
    }

    /**
        Retorna o nome do item.
    */
    public String getName(){
        return nome;
    }

    /**
        Define o nome do item.
    */
    public void setName(String novoNome){
        this.nome = novoNome;
    }

    /**
        Retorna o bônus de poder concedido pelo item.
    */
    public int getBonusPoder(){
        return bonusPoder;
    }

    /**
        Define o bônus de poder concedido pelo item.
    */
    public void setBonusPoder(int novoBonusPoder){
        this.bonusPoder = novoBonusPoder;
    }

    /**
        Retorna o valor do item.
    */
    public int getValor(){
        return valor;
    }

    /**
        Define o valor do item.
    */
    public void setValor(int novoValor){
        this.valor = novoValor;
    }

    /**
        Retorna o tipo do item.
    */
    public TipoItem getTipo(){
        return tipo;
    }

    /**
        Define o tipo do item.
    */
    public void setTipo(TipoItem novoTipo){
        this.tipo = novoTipo;
    }

    /**
        Retorna se o item é grande.
    */
    public boolean getItemGrande(){
        return itemGrande;
    }

    /**
        Define se o item é grande.
    */
    public void setItemGrande(boolean novoItemGrande){
        this.itemGrande = novoItemGrande;
    }

    /**
        Retorna a lista de classes compatíveis com o item.
    */
    public List<Classe> getClassesCompativeis(){
        return classesCompativeis;
    }

    /**
        Define a lista de classes compatíveis com o item.
    */
    public void setClassesCompativeis(List<Classe> NovaClassesCompativeis){
        this.classesCompativeis = NovaClassesCompativeis;
    }

    public List<Raca> getRacasCompativeis(){
        return racasCompativeis;
    }


    public void setRacasCompativeis(List<Raca> NovasRacasCompativeis){
        this.racasCompativeis = NovasRacasCompativeis;
    }

    /**
        Representação textual da classe Item.
    */
    public String toString() {

        return "- "+nome+" - nível: "+bonusPoder+"\n";
    }
}