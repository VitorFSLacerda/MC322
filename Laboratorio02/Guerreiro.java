/**
    Classe que representa um Guerreiro, uma subclasse de Classe.
*/
public class Guerreiro extends Classe {

    private Item itemCabeca;
    private Item itemCorpo;

    /**
        Construtor da classe Guerreiro.
    */
    public Guerreiro(String descricao, Item itemMaoDireita, Item itemMaoEsquerda, Item itemPe, Item itemCabeca, Item itemCorpo) {
        super(descricao, itemMaoDireita, itemMaoEsquerda, itemPe);
        this.itemCabeca = itemCabeca;
        this.itemCorpo = itemCorpo;
    }

    protected boolean verificaItemGrande() {
        return (getItemMaoDireita() != null && getItemMaoDireita().getItemGrande()) ||
               (getItemMaoEsquerda() != null && getItemMaoEsquerda().getItemGrande()) ||
               (getItemPe() != null && getItemPe().getItemGrande()) ||
               (getItemCabeca() != null && getItemCabeca().getItemGrande()) ||
               (getItemCorpo() != null && getItemCorpo().getItemGrande());
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
        Retorna o item no corpo.
    */
    public Item getItemCorpo(){
        return itemCorpo;
    }

    /**
        Define o item no corpo.
    */
    public void setItemCorpo(Item novoitemCorpo, Jogador jogador){

        if(novoitemCorpo.getItemGrande() && verificaItemGrande()){
            System.out.println("Não é possivel equipar.");

        } else if(verificaClasseCompativel(novoitemCorpo, jogador)){
            this.itemCorpo = novoitemCorpo;
        } else{
            System.out.println("Não é possivel equipar.");
        }
    }

    /**
        Representação textual da classe Guerreiro.
    */
    public String toString(){
        return itemCabeca+"\n"+itemCorpo+"\n";
    }
}