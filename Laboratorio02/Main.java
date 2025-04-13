import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args){


        Raca racaJogador = new Raca("Os humanos são uma raça versátil, inteligente e adaptável, conhecida por sua influência e habilidades sociais.", "Humano", 5);
        

        Mago mago = new Mago("Mestre das artes arcanas, manipulador de energia mística e lançador de feitiços poderosos", null,null, null,null);
        

        Inventario inventarioJogador = new Inventario(5);
        

        Jogador gamer = new Jogador("Vitor", 20, racaJogador, mago, inventarioJogador);


        Item canivete = new Item("Zé pequeno", 20, 10, "fogo", true);
        

        List<Classe> classesCompativeis = new ArrayList<>(5);
        classesCompativeis.add(mago);
        canivete.setClassesCompativeis(classesCompativeis);


        List<Item> lstTesouros = new ArrayList<>();
        lstTesouros.add(canivete);


        Monstro chuck = new Monstro("Chuck", 50);


        Item faca = new Item("barriguda", 20, 10, "gelo", false);
        Item canhao = new Item("canhao", 45, 36, "explosiva", true);
        Item sniper = new Item("sniper", 50, 39, "venenosa", true);
        faca.setClassesCompativeis(classesCompativeis);
        canhao.setClassesCompativeis(classesCompativeis);
        sniper.setClassesCompativeis(classesCompativeis);
        

        gamer.getInventario().adicionarItem(faca,gamer);


        Inventario inventarioDoJogador = gamer.getInventario();
        System.out.println("Inventário do jogador:");
        for (Item item : inventarioDoJogador.getInventario()){
            System.out.println(item);
        }

        gamer.getInventario().removerItem("barriguda");


        inventarioDoJogador = gamer.getInventario();
        System.out.println("Inventário do jogador:");
        for (Item item : inventarioDoJogador.getInventario()){
            System.out.println(item);
        }

        gamer.getInventario().adicionarItem(canhao,gamer);
        gamer.getInventario().adicionarItem(sniper,gamer);

        gamer.getClasse().setItemMaoDireita(sniper, gamer);


        inventarioDoJogador = gamer.getInventario();
        System.out.println("Items equipados1:");
        System.out.println(gamer.getClasse().getItemMaoDireita());
        System.out.println(gamer.getClasse().getItemMaoEsquerda());
        System.out.println(gamer.getClasse().getItemPe());

        gamer.getClasse().setItemMaoEsquerda(canhao, gamer);

        inventarioDoJogador = gamer.getInventario();
        System.out.println("Items equipados2:");
        System.out.println(gamer.getClasse().getItemMaoDireita());
        System.out.println(gamer.getClasse().getItemMaoEsquerda());
        System.out.println(gamer.getClasse().getItemPe());


        System.out.println("O Seu poder é: "+gamer.poderJogador());     
    }
}
