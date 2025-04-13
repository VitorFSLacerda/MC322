import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;


/**
    Classe que representa um inventário de itens em um jogo.
 */
public class Inventario {
    
    private int limiteDeItens;
    private List<Item> itens;

    /**
        Construtor da classe Inventario.
    */
    public Inventario(int limiteDeItens){
        this.limiteDeItens = limiteDeItens;
        this.itens = new LinkedList<>();
    }

    /**
        Retorna o limite de itens do inventário.
    */
    public int getlimiteDeItens(){
        return limiteDeItens;
    }

    /**
        Define o limite de itens do inventário.
    */
    public void setlimiteDeItens(int novolimiteDeItens){
        this.limiteDeItens = novolimiteDeItens;
    }

    /**
        Retorna a lista de itens do inventário.
    */
    public List<Item> getItens(){
        return itens;
    }
    
    /**
        Define a lista de itens do inventário.
    */
    public void setItens(List<Item> novosItens){
        this.itens = novosItens;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Inventário:\n");
        sb.append("Limite de Itens: ").append(limiteDeItens).append("\n");
        for (Item item : itens) {
            sb.append(item.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
        Adiciona um item ao inventário.
    */
    public boolean adicionarItem(Item item){

        if(itens.size() == limiteDeItens){
            return false;
        }
        itens.add(item);
        return true;
    }

    /**
        Acessa um item no inventário pelo nome.
    */
    public Item acessarItem(String nome){

        for(int i = 0; i < itens.size(); i++){
            Item item = itens.get(i);
            if(item.getName().equals(nome)){
                return item;
            }
        }
        return null;
    }

    /**
        Remove um item do inventário.
    */
    public void removerItem(String nome){

        for(int i = 0; i < itens.size(); i++){
            Item item = itens.get(i);
            if(item.getName().equals(nome)){
                itens.remove(i);
                break;
            }
        }
    }

    public void removerItens(List<String> lstNomes) {
        Iterator<Item> iterator = itens.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (lstNomes.contains(item.getName())) {
                iterator.remove();
            }
        }
    }

    /**
        Lista todos os itens do inventário.
    */
    public void listarItens(){

        for(int i = 0; i < itens.size(); i++){
            System.out.println("- "+itens.get(i).getName()+" - nível: "+itens.get(i).getBonusPoder());
        }
    }

}
