import java.util.ArrayList;
import java.util.List;

/**
    Classe que representa uma classe de personagem em um jogo.
*/
public class Classe {
    
    private String descricao;
    private Item itemMaoDireita;
    private Item itemMaoEsquerda;
    private Item itemPe;

    /**
        Construtor da classe Classe.
    */
    public Classe (String descricao, Item itemMaoDireita, Item itemMaoEsquerda, Item itemPe){
        
        this.descricao = descricao;
        this.itemMaoDireita = itemMaoDireita;
        this.itemMaoEsquerda = itemMaoEsquerda;
        this.itemPe = itemPe;
    }


    protected boolean verificaItemGrande() {
        return (getItemMaoDireita() != null && getItemMaoDireita().getItemGrande()) ||
               (getItemMaoEsquerda() != null && getItemMaoEsquerda().getItemGrande()) ||
               (getItemPe() != null && getItemPe().getItemGrande());
    }


    protected boolean verificaClasseCompativel(Item item, Jogador jogador){

        Classe classeJogador = jogador.getClasse();

        for(Classe classe : item.getClassesCompativeis()){
            if(classe.equals(classeJogador)){
                return true;
            }
        }
        return false;
    }

    /**
        Retorna a descrição da classe.
    */
    public String getDescricao(){
        return descricao;
    }

    /**
        Define a descrição da classe.
    */
    public void setDescricao(String novaDescricao){
        this.descricao = novaDescricao;
    }

    /**
        Retorna o item na mão direita.
    */
    public Item getItemMaoDireita(){
        return itemMaoDireita;
    }

    /**
        Define o item na mão direita.
    */
    public void setItemMaoDireita(Item novoItemMaoDireita, Jogador jogador){
        
        if(novoItemMaoDireita.getItemGrande() && verificaItemGrande()){
            System.out.println("Não é possivel equipar.");

        } else if(verificaClasseCompativel(novoItemMaoDireita, jogador)){
            this.itemMaoDireita = novoItemMaoDireita;
        } else{
            System.out.println("Não é possivel equipar.");
        }
    }

    /**
        Retorna o item na mão esquerda.
    */
    public Item getItemMaoEsquerda(){
        return itemMaoEsquerda;
    }

    /**
        Define o item na mão esquerda.
    */
    public void setItemMaoEsquerda(Item novoItemMaoEsquerda, Jogador jogador){

        if(novoItemMaoEsquerda.getItemGrande() && verificaItemGrande()){
            System.out.println("Não é possivel equipar.");

        } else if(verificaClasseCompativel(novoItemMaoEsquerda, jogador)){
            this.itemMaoEsquerda = novoItemMaoEsquerda;
        } else{
            System.out.println("Não é possivel equipar.");
        }
    }

    /**
        Retorna o item do pé.
    */
    public Item getItemPe(){
        return itemPe;
    }

    /**
        Define o item do pé.
    */
    public void setItemPe(Item novoItemPe, Jogador jogador){

        if(novoItemPe.getItemGrande() && verificaItemGrande()){
            System.out.println("Não é possivel equipar.");

        } else if(verificaClasseCompativel(novoItemPe, jogador)){
            this.itemPe = novoItemPe;
        } else{
            System.out.println("Não é possivel equipar.");
        }
    }

    /**
        Representação textual da classe.
    */
    public String toString(){
        return descricao+"\n"+itemMaoDireita+"\n"+itemMaoEsquerda+"\n"+itemPe+"\n";
    }

    /**
        Verifica se a classe possui ambas as mãos vazias.
    */
    public boolean possuiMaoVazia() {
        return (itemMaoDireita == null && itemMaoEsquerda == null);
    }
}