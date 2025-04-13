/**
    Classe que representa um Mago, uma subclasse de Classe.
*/
public class Mago extends Classe {

    private Item itemCabeca;

    /**
        Construtor da classe Mago.
    */
    public Mago(String descricao, Item itemMaoDireita, Item itemMaoEsquerda, Item itemPe, Item itemCabeca) {
        super(descricao, itemMaoDireita, itemMaoEsquerda, itemPe);
        this.itemCabeca = itemCabeca;
    }

    protected boolean verificaItemGrande() {
        return (getItemMaoDireita() != null && getItemMaoDireita().getItemGrande()) ||
               (getItemMaoEsquerda() != null && getItemMaoEsquerda().getItemGrande()) ||
               (getItemPe() != null && getItemPe().getItemGrande()) ||
               (getItemCabeca() != null && getItemCabeca().getItemGrande());
    }

    /**
        Retorna o item na cabeça.
    */
    public Item getItemCabeca(){
        return itemCabeca;
    }

    /**
        Define o item na cabeça.
    */
    public void setItemCabeca(Item novoItemCabeca, Jogador jogador){

        if(novoItemCabeca.getItemGrande() && verificaItemGrande()){
            System.out.println("Não é possivel equipar.");

        } else if(verificaClasseCompativel(novoItemCabeca, jogador)){
            this.itemCabeca = novoItemCabeca;
        } else{
            System.out.println("Não é possivel equipar.");
        }
    }

    /**
        Representação textual da classe Mago.
    */
    public String toString(){
        return itemCabeca + "\n";
    }
}
