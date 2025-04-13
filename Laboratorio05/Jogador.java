import java.util.List;
import java.util.Scanner;
import java.util.LinkedList;

/**
    Classe que representa um jogador em um jogo.
*/
public class Jogador {
    
    private String nome;
    private int nivel;
    private Raca raca;
    private Classe classe;
    private Inventario inventario;
    private Item itemMaoDireita;
    private Item itemMaoEsquerda;
    private Item itemPe;
    private Item itemCabeca;
    private Item itemCorpo;

    /**
        Construtor da classe Jogador.
    */
    public Jogador (String nome, int nivel, Raca raca, Classe classe, Inventario inventario,
                    Item itemMaoDireita, Item itemMaoEsquerda, Item itemPe, Item itemCabeca, Item itemCorpo){
        this.nome = nome;
        this.nivel = nivel;
        this.raca = raca;
        this.classe = classe;
        this.inventario = inventario;
        this.itemMaoDireita = itemMaoDireita;
        this.itemMaoEsquerda = itemMaoEsquerda;
        this.itemPe = itemPe;
        this.itemCabeca = itemCabeca;
        this.itemCorpo = itemCorpo;
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
    public void setNome(String novoNome){
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
        Retorna o item na mão direita.
    */
    public Item getItemMaoDireita(){
        return itemMaoDireita;
    }

    /**
        Define o item na mão direita.
    */
    public void setItemMaoDireita(Item novoItemMaoDireita) {
        
        if (verificaItemGrande()) {
            System.out.println("Você já está equipado com um item grande na mão direita.");
            return;
        }
        if (!verificaClasse(novoItemMaoDireita)) {
            System.out.println("Sua classe não suporta este item.");
            return;
        }
        if (this.itemMaoDireita != null) {
            this.inventario.adicionarItem(this.itemMaoDireita);
        }
        this.itemMaoDireita = novoItemMaoDireita;
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
    public void setItemMaoEsquerda(Item novoItemMaoEsquerda){
        if (verificaItemGrande()) {
            System.out.println("Você já está equipado com um item grande na mão esquerda.");
            return;
        }
        if (!verificaClasse(novoItemMaoEsquerda)) {
            System.out.println("Sua classe não suporta este item.");
            return;
        }
        if (this.itemMaoEsquerda != null) {
            this.inventario.adicionarItem(this.itemMaoEsquerda);
        }
        this.itemMaoEsquerda = novoItemMaoEsquerda;
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
    public void setItemPe(Item novoItemPe){
        if (verificaItemGrande()) {
            System.out.println("Você já está equipado com um item grande nos pés.");
            return;
        }
        if (!verificaClasse(novoItemPe)) {
            System.out.println("Sua classe não suporta este item.");
            return;
        }
        if (this.itemPe != null) {
            this.inventario.adicionarItem(this.itemPe);
        }
        this.itemPe = novoItemPe;
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
    public void setItemCabeca(Item novoItemCabeca){
        if (verificaItemGrande()) {
            System.out.println("Você já está equipado com um item grande na cabeça.");
            return;
        }
        if (!verificaClasse(novoItemCabeca)) {
            System.out.println("Sua classe não suporta este item.");
            return;
        }
        if (this.itemCabeca != null) {
            this.inventario.adicionarItem(this.itemCabeca);
        }
        this.itemCabeca = novoItemCabeca;
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
    public void setItemCorpo(Item novoItemCorpo){
        if (verificaItemGrande()) {
            System.out.println("Você já está equipado com um item grande no corpo.");
            return;
        }
        if (!verificaClasse(novoItemCorpo)) {
            System.out.println("Sua classe não suporta este item.");
            return;
        }
        if (this.itemCorpo != null) {
            this.inventario.adicionarItem(this.itemCorpo);
        }
        this.itemCorpo = novoItemCorpo;
    }

    /**
        Representação textual da classe Jogador.
    */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Poder Total: " + poderJogador() + "\n");
        sb.append("Nível: " + nivel + "\n");
        sb.append("Item na cabeça: " + (itemCabeca != null ? itemCabeca : "Nenhum") + "\n");
        sb.append("Item no corpo: " + (itemCorpo != null ? itemCorpo : "Nenhum") + "\n");
        sb.append("Item na mão direita: " + (itemMaoDireita != null ? itemMaoDireita : "Nenhum") + "\n");
        sb.append("Item na mão esquerda: " + (itemMaoEsquerda != null ? itemMaoEsquerda : "Nenhum") + "\n");
        sb.append("Item nos pés: " + (itemPe != null ? itemPe : "Nenhum") + "\n");
        return sb.toString();
    }

    /**
        Calcula o poder total do jogador.
    */
    public int poderJogador(){
        return nivel + inventario.getItens().size();
    }
    
    public String venderItens(List<Item> itensParaVender){
        int acumulado = 0;
        boolean vendeu = false;
        List<Item> itensRemover = new LinkedList<Item>();
    
        for (Item item : itensParaVender) {
            acumulado += item.getValor();
            if (acumulado >= 1000){
                itensRemover.add(item);
                vendeu = true;
                acumulado = 0;
                setNivel(getNivel() + 1);
            }
        }
        for (Item item : itensRemover) {
            inventario.removerItem(item.getName());
        }
    
        return vendeu?"Itens vendidos com sucesso!":"Itens não vendidos!";
    }

    public boolean verificaItemGrande(){

        if(getItemCabeca() != null && getItemCabeca().getItemGrande()){
            return true;

        } else if(getItemCorpo() != null && getItemCorpo().getItemGrande()){
            return true;

        } else if(getItemMaoDireita() != null && getItemMaoDireita().getItemGrande()){
            return true;

        } else if(getItemMaoEsquerda() != null && getItemMaoEsquerda().getItemGrande()){
            return true;

        } else if(getItemPe() != null && getItemPe().getItemGrande()){
            return true;

        }
        return false;
    }

    public boolean verificaClasse(Item item) {
        List<Classe> classesCompativeisItem = item.getClassesCompativeis();
        return classesCompativeisItem.contains(getClasse());
    }   

    public String equiparItens(String nomeItem) {
    
        Scanner scanner = new Scanner(System.in);
    
        int escolha = scanner.nextInt();
    
        if (escolha == 1) {
            Item itemAequipar = getInventario().acessarItem(nomeItem);
            setItemCabeca(itemAequipar);
            getInventario().removerItem(nomeItem);
        } else if (escolha == 2) {
            Item itemAequipar = getInventario().acessarItem(nomeItem);
            setItemCorpo(itemAequipar);
            getInventario().removerItem(nomeItem);
        } else if (escolha == 3) {
            Item itemAequipar = getInventario().acessarItem(nomeItem);
            setItemMaoDireita(itemAequipar);
            getInventario().removerItem(nomeItem);
        } else if (escolha == 4) {
            Item itemAequipar = getInventario().acessarItem(nomeItem);
            setItemMaoEsquerda(itemAequipar);
            getInventario().removerItem(nomeItem);
        } else if (escolha == 5) {
            Item itemAequipar = getInventario().acessarItem(nomeItem);
            setItemPe(itemAequipar);
            getInventario().removerItem(nomeItem);
        } else {
            return "Opção inválida.";
        }
        return "Tudo certo!";
    }
    
}
