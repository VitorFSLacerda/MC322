import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args){
        
        // Instanciando raça e classe do jogador
        Raca humano = Raca.HUMANO;
        Classe guerreiro = Classe.GUERREIRO;
        
        // Instanciando inventário e jogador
        Inventario invJogador1 = new Inventario(10);
        Jogador jogador1 = new Jogador("Vitor", 0, humano, guerreiro, invJogador1, null, null, null, null, null);
        
        // Criando itens
        Item espada = new Item("Espada", 5, 100, TipoItem.MAO, false);
        Item escudo = new Item("Escudo", 3, 80, TipoItem.CORPO, false);
        Item elmo = new Item("Elmo", 2, 50, TipoItem.CABECA, false);
        Item pocaoCurativa = new Item("Poção", 0, 20, TipoItem.PE, false);
        Item botasVelocidade = new Item("Botas", 2, 60, TipoItem.PE, false);

        // Adicionando classes e raças compatíveis com os itens
        espada.setClassesCompativeis(Arrays.asList(Classe.GUERREIRO));
        escudo.setClassesCompativeis(Arrays.asList(Classe.GUERREIRO));
        elmo.setClassesCompativeis(Arrays.asList(Classe.GUERREIRO));
        pocaoCurativa.setRacasCompativeis(Arrays.asList(Raca.HUMANO, Raca.ELFO, Raca.ANAO));
        botasVelocidade.setRacasCompativeis(Arrays.asList(Raca.HUMANO));

        // Criando monstros
        Monstro orc = new Monstro("Orc", 1, 1);
        Monstro troll = new Monstro("Troll", 2, 2);
        Monstro esqueleto = new Monstro("Esqueleto", 4, 2);
        Monstro ogro = new Monstro("Ogro", 1, 2);
        Monstro lobo = new Monstro("Lobo", 3, 1);

        // Adicionando tesouros ao baú de tesouros
        BauDeTesouros tesouros = new BauDeTesouros(10);
        tesouros.adicionarItem(espada);
        tesouros.adicionarItem(escudo);
        tesouros.adicionarItem(elmo);
        tesouros.adicionarItem(pocaoCurativa);
        tesouros.adicionarItem(botasVelocidade);

        // Adicionando monstros à masmorra
        Masmorra masmorra = new Masmorra(tesouros);
        masmorra.getMonstros().add(orc);
        masmorra.getMonstros().add(troll);
        masmorra.getMonstros().add(esqueleto);
        masmorra.getMonstros().add(ogro);
        masmorra.getMonstros().add(lobo);
        int escolha;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Jogador 1: "+jogador1.getNome()+"\n");
            System.out.println("O que você deseja fazer?\n");
            System.out.println(
                "1 - Listar itens do inventário\n" +
                "2 - Equipar itens do inventário\n" +
                "3 - Vender itens do inventário\n" +
                "4 - Ver informações do jogador\n" +
                "5 - Passar para abrir a porta\n\n" +
                "0 - Sair do jogo"
            );
            escolha = scanner.nextInt();

            if(escolha == 0){
                break;

            }else if(escolha == 1){
                System.out.println("Listando itens do inventário\n");
                jogador1.getInventario().listarItens();

            }else if(escolha == 2){
                if(!jogador1.getInventario().getItens().isEmpty()){
                    
                    
                    System.out.println("Digite o nome do item que deseja equipar.\n");
                    String nomeItem = scanner.next();
                    System.out.println("Onde deseja equipar?\n"+
                                        "1 - Cabeça.\n"+
                                        "2 - Corpo.\n"+
                                        "3 - Mão Direita.\n"+
                                        "4 - Mão Esquerda.\n"+
                                        "5 - Pé.");
                    escolha = scanner.nextInt();   
                    
                    if (escolha == 1) {
                        
                        Item itemAequipar = jogador1.getInventario().acessarItem(nomeItem);
                        jogador1.setItemCabeca(itemAequipar);
                        jogador1.getInventario().removerItem(nomeItem);

                    } else if (escolha == 2) {

                        Item itemAequipar = jogador1.getInventario().acessarItem(nomeItem);
                        jogador1.setItemCorpo(itemAequipar);
                        jogador1.getInventario().removerItem(nomeItem);

                    } else if (escolha == 3) {

                        Item itemAequipar = jogador1.getInventario().acessarItem(nomeItem);
                        jogador1.setItemMaoDireita(itemAequipar);
                        jogador1.getInventario().removerItem(nomeItem);

                    } else if (escolha == 4) {

                        Item itemAequipar = jogador1.getInventario().acessarItem(nomeItem);
                        jogador1.setItemMaoEsquerda(itemAequipar);
                        jogador1.getInventario().removerItem(nomeItem);

                    } else if (escolha == 5) {
                        Item itemAequipar = jogador1.getInventario().acessarItem(nomeItem);
                        jogador1.setItemPe(itemAequipar);
                        jogador1.getInventario().removerItem(nomeItem);
                    }
                }else {
                    System.out.println("O inventário está vazio. Não é possível realizar esta ação.");
                }
            }else if(escolha == 3){
                if(!jogador1.getInventario().getItens().isEmpty()){
                    jogador1.venderItens(jogador1.getInventario().getItens());
                }else {
                    System.out.println("O inventário está vazio. Não é possível realizar esta ação.");
                }
            }else if(escolha == 4){

                System.out.println(jogador1);

            }else if(escolha == 5){
                Random random = new Random();
                int decisao = random.nextInt(2);

                if(decisao == 1){
                    masmorra.abrirPortaItem(jogador1);

                }else{
                    masmorra.abrirPortaMonstro(jogador1);
                }
            }
        }
        scanner.close();
    }
}
