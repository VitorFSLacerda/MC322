package Laboratorio01;

public class Main {
    
    public static void main(String[] args){

        Jogador gamer = new Jogador("Vitor", 20, "mago", "conjurador",
                        "Chapéu de Mago", "Túnica de Mago", "Varinha das Varinhas",
                                    "cálice", "Ténis nike shox" );

        Item canivete = new Item("Zé pequeno", 20, 10, "fogo");

        Monstro chuck = new Monstro("Chuck", 50, 3, 0);
        
        System.out.println(gamer);
        System.out.println(canivete);
        System.out.println(chuck);

    }
}