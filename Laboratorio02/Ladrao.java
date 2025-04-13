/**
    Classe que representa um Ladrão, uma subclasse de Classe.
*/
public class Ladrao extends Classe {

    private Item itemCorpo;

    /**
        Construtor da classe Ladrao.
    */
    public Ladrao(String descricao, Item itemMaoDireita, Item itemMaoEsquerda, Item itemPe, Item itemCorpo) {
        super(descricao, itemMaoDireita, itemMaoEsquerda, itemPe);
        this.itemCorpo = itemCorpo;
    }

    protected boolean verificaItemGrande() {
        return (getItemMaoDireita() != null && getItemMaoDireita().getItemGrande()) ||
               (getItemMaoEsquerda() != null && getItemMaoEsquerda().getItemGrande()) ||
               (getItemPe() != null && getItemPe().getItemGrande()) ||
               (getItemCorpo() != null && getItemCorpo().getItemGrande());
    }

    /**
        Retorna o item no corpo.
    */
    public Item getItemCorpo(){
        return itemCorpo;
    }

    /**
        Define o item no corpo.
    */
    public void setItemCorpo(Item novoItemCorpo, Jogador jogador){

        if(novoItemCorpo.getItemGrande() && verificaItemGrande()){
            System.out.println("Não é possivel equipar.");

        } else if(verificaClasseCompativel(novoItemCorpo, jogador)){
            this.itemCorpo = novoItemCorpo;
        } else{
            System.out.println("Não é possivel equipar.");
        }
    }

    /**
        Representação textual da classe Ladrão.
    */
    public String toString(){
        return itemCorpo + "\n";
    }
}
