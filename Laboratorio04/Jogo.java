import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Jogo {

    private Masmorra masmorra;
    private List<Jogador> jogadores;
    private Scanner scanner;

    public Jogo() {
        this.jogadores = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.masmorra = new Masmorra(new BauDeTesouros(30));
    }
    
    public void iniciarJogo() {

        distribuirItensIniciais();

        while (true) {
            exibirMenuJogadores();
            int escolhaJogador = scanner.nextInt();

            if (escolhaJogador == 0) {
                System.out.println("Saindo do jogo...");
                break;
            }

            if (escolhaJogador < 1 || escolhaJogador > jogadores.size()) {
                System.out.println("Jogador inválido. Tente novamente.");
                
            } else{
                Jogador jogadorSelecionado = jogadores.get(escolhaJogador - 1);
                exibirMenuJogador(jogadorSelecionado);

                int escolha = scanner.nextInt();
                processarEscolha(jogadorSelecionado, escolha);

                if (escolha == 0) {
                    break;
                }
            }
        }
        scanner.close();
    }

    private void distribuirItensIniciais() {
        BauDeTesouros bauDeTesouros = masmorra.getTesouros();
        List<Item> itensDisponiveis = bauDeTesouros.getItens();
    
        Random random = new Random();
    
        for (Jogador jogador : jogadores) {
            List<Item> itensRecebidos = new ArrayList<>();
    
            for (int i = 0; i < 5; i++) {

                int indexItem = random.nextInt(itensDisponiveis.size());
                Item itemSelecionado = itensDisponiveis.get(indexItem);
    
                jogador.getInventario().adicionarItem(itemSelecionado);
                itensRecebidos.add(itemSelecionado);
    
                itensDisponiveis.remove(indexItem);
            }
    
            System.out.println("Itens recebidos por " + jogador.getNome() + ":");
            for (Item item : itensRecebidos) {
                System.out.println("- " + item.getName());
            }
            System.out.println();
        }
        bauDeTesouros.setItens(itensDisponiveis);
    }
    
    private void exibirMenuJogadores() {
        System.out.println("Escolha um jogador para interagir:");
        System.out.println("0 - Sair do jogo");
        for (int i = 0; i < jogadores.size(); i++) {
            System.out.println((i + 1) + " - " + jogadores.get(i).getNome());
        }
    }

    private void exibirMenuJogador(Jogador jogador) {
        System.out.println("Jogador: " + jogador.getNome());
        System.out.println("O que você deseja fazer?");
        System.out.println(
            "1 - Listar itens do inventário\n" +
            "2 - Equipar itens do inventário\n" +
            "3 - Vender itens do inventário\n" +
            "4 - Ver informações do jogador\n" +
            "5 - Passar para abrir a porta\n\n" +
            "0 - Voltar para escolher outro jogador"
        );
    }
   
    private void processarEscolha(Jogador jogador, int escolha) {

        if (escolha == 1) {
            listarItensInventario(jogador);
        } else if (escolha == 2) {
            equiparItens(jogador);
        } else if (escolha == 3) {
            venderItens(jogador);
        } else if (escolha == 4) {
            exibirInformacoesJogador(jogador);
        } else if (escolha == 5) {
            abrirPorta(jogador);
        } else {
            System.out.println("Escolha inválida. Tente novamente.");
        }
    }
    
    private void listarItensInventario(Jogador jogador) {
        System.out.println("Listando itens do inventário de " + jogador.getNome());
        jogador.getInventario().listarItens();
        aguardarConfirmacao();
    }

    private void exibirInformacoesJogador(Jogador jogador) {
        System.out.println(jogador);
        aguardarConfirmacao();
    }

    private void abrirPorta(Jogador jogador) {
        Random random = new Random();
        int decisao = random.nextInt(2);

        if (decisao == 1) {
            masmorra.abrirPortaItem(jogador);
        } else {
            masmorra.abrirPortaMonstro(jogador);
        }
        aguardarConfirmacao();
    }

    private void equiparItens(Jogador jogador) {
        if (jogador == null) {
            System.out.println("Jogador inválido. Não é possível equipar itens.");
            return;
        }
    
        System.out.println("Digite o nome do item que deseja equipar:");

        Scanner scanner = new Scanner(System.in);

        String nomeItem = scanner.nextLine();

    
        if (jogador.getInventario().getItens().isEmpty()) {
            System.out.println("O inventário está vazio. Não é possível equipar itens.");
            aguardarConfirmacao();
            return;
        }
    
        System.out.println("Onde deseja equipar o item?");
        System.out.println(
            "1 - Cabeça\n" +
            "2 - Corpo\n" +
            "3 - Mão Direita\n" +
            "4 - Mão Esquerda\n" +
            "5 - Pé"
        );
        
        int escolha = scanner.nextInt();

        if (escolha == 1) {
                        
            Item itemAequipar = jogador.getInventario().acessarItem(nomeItem);
            jogador.setItemCabeca(itemAequipar);
            jogador.getInventario().removerItem(nomeItem);

        } else if (escolha == 2) {

            Item itemAequipar = jogador.getInventario().acessarItem(nomeItem);
            jogador.setItemCorpo(itemAequipar);
            jogador.getInventario().removerItem(nomeItem);

        } else if (escolha == 3) {

            Item itemAequipar = jogador.getInventario().acessarItem(nomeItem);
            jogador.setItemMaoDireita(itemAequipar);
            jogador.getInventario().removerItem(nomeItem);

        } else if (escolha == 4) {

            Item itemAequipar = jogador.getInventario().acessarItem(nomeItem);
            jogador.setItemMaoEsquerda(itemAequipar);
            jogador.getInventario().removerItem(nomeItem);

        } else if (escolha == 5) {
            Item itemAequipar = jogador.getInventario().acessarItem(nomeItem);
            jogador.setItemPe(itemAequipar);
            jogador.getInventario().removerItem(nomeItem);
        }
        else {
            System.out.println("O inventário está vazio. Não é possível realizar esta ação.");
        }
        aguardarConfirmacao();
    }

    private void venderItens(Jogador jogador) {

        System.out.println("Vendendo itens do inventário de " + jogador.getNome());

        if(!jogador.getInventario().getItens().isEmpty()){
            jogador.venderItens(jogador.getInventario().getItens());
        }else {
            System.out.println("O inventário está vazio. Não é possível realizar esta ação.");
        }
        aguardarConfirmacao();
    }

    private void aguardarConfirmacao() {
        System.out.println("Digite 0 para voltar ou qualquer outro número para continuar:");
        int escolha = scanner.nextInt();
        if (escolha != 0) {
            System.out.println("Opção inválida. Voltando ao menu.");
        }
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }
    
    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public void setMonstros(List<Monstro> monstros) {
        masmorra.setMonstros(monstros);
    }


    public void adicionarTesouros(List<Item> itens, BauDeTesouros tesouros) {

        for (int i = 0; i < itens.size(); i++) {
            tesouros.adicionarItem(itens.get(i));
        }
        masmorra.setTesouros(tesouros);

    }
}
