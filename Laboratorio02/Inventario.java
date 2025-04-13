import java.util.LinkedList;
import java.util.List;

/**
    Classe que representa um inventário de itens em um jogo.
 */
public class Inventario {
    
    private int limiteInventario;
    private List<Item> inventario;

    /**
        Construtor da classe Inventario.
    */
    public Inventario(int limiteInventario){
        this.limiteInventario = limiteInventario;
        this.inventario = new LinkedList<>();
    }

    /**
        Retorna o limite de itens do inventário.
    */
    public int getLimiteInventario(){
        return limiteInventario;
    }

    /**
        Define o limite de itens do inventário.
    */
    public void setLimiteInventario(int novoLimiteInventario){
        this.limiteInventario = novoLimiteInventario;
    }

    /**
        Retorna a lista de itens do inventário.
    */
    public List<Item> getInventario(){
        return inventario;
    }
    
    /**
        Define a lista de itens do inventário.
    */
    public void setInventario(List<Item> novoInventario){
        this.inventario = novoInventario;
    }

    /**
        Adiciona um item ao inventário.
    */
    public boolean adicionarItem(Item item, Jogador gamer){

        if(inventario.size() == limiteInventario){
            return false;
        }
        inventario.add(item);
        return true;
    }

    /**
        Acessa um item no inventário pelo nome.
    */
    public Item acessarItem(String nome){

        for(int i = 0; i < inventario.size(); i++){
            Item item = inventario.get(i);
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

        for(int i = 0; i < inventario.size(); i++){
            Item item = inventario.get(i);
            if(item.getName().equals(nome)){
                inventario.remove(i);
                break;
            }
        }
    }

    /**
        Lista todos os itens do inventário.
    */
    public void listarInventario(){

        for(int i = 0; i < inventario.size(); i++){
            System.out.println(inventario.get(i));
        }
    }
}
