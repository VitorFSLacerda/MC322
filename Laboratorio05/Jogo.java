import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Jogo {

    private Masmorra masmorra;
    private List<Jogador> jogadores;
    private Scanner scanner;
    private JogadorController jogadorController;
    private MasmorraController masmorraController;

    public Jogo() {
        this.jogadores = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.masmorra = new Masmorra(BauDeTesouros.getInstance(30));
        this.masmorraController = new MasmorraController(masmorra);
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
                this.jogadorController = new JogadorController(jogadorSelecionado, new JogadorView());////////////////////////////////////////
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
            jogadorController.listarItensInventario();
        } else if (escolha == 2) {
            jogadorController.equiparItens();
        } else if (escolha == 3) {
            jogadorController.venderItens();
        } else if (escolha == 4) {
            jogadorController.exibirInformacoesJogador();
        } else if (escolha == 5) {
            masmorraController.abrirPorta(jogador);
        } else {
            System.out.println("Escolha inválida. Tente novamente.");
        }
    }


    public List<Jogador> getJogadores() { // Dispensavel
        return jogadores;
    }
    
    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public void setMonstros(List<Monstro> monstros) {
        masmorra.setMonstros(monstros);
    }


    public void adicionarTesouros(List<Item> itens, BauDeTesouros tesouros) { //Masmorra

        for (int i = 0; i < itens.size(); i++) {
            tesouros.adicionarItem(itens.get(i));
        }
        masmorra.setTesouros(tesouros);

    }
}
