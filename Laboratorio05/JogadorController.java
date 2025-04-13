import java.util.Scanner;

public class JogadorController {
    
    private Jogador jogador;
    private JogadorView jogadorView;
    private Scanner scanner;

    public JogadorController(Jogador jogador, JogadorView jogadorView) {
        this.jogador = jogador;
        this.jogadorView = jogadorView;
        this.scanner = new Scanner(System.in);
    }

    public void equiparItens(){

        if (jogador.getInventario().getItens().isEmpty()) {
            jogadorView.exibeMensagem("O inventário está vazio. Não é possível equipar itens.");
            return;
        }
        jogadorView.exibeMensagem("Digite o nome do item que deseja equipar:");
        String nomeItem = scanner.nextLine();
        jogadorView.exibeMensagem("Onde deseja equipar o item?");
        jogadorView.exibeMensagem(
                "1 - Cabeça\n" +
                "2 - Corpo\n" +
                "3 - Mão Direita\n" +
                "4 - Mão Esquerda\n" +
                "5 - Pé"
        );
        jogadorView.exibeMensagem(jogador.equiparItens(nomeItem));
        jogadorView.aguardarConfirmacao();
    }

    public void venderItens(){

        if (!jogador.getInventario().getItens().isEmpty()) {
            jogadorView.exibeMensagem("Vendendo itens do inventário de "+jogador.getNome());
            jogadorView.exibeMensagem(jogador.venderItens(jogador.getInventario().getItens()));
        }else{
            jogadorView.exibeMensagem("O inventário está vazio. Não é possível realizar esta ação.");
        }

        jogadorView.aguardarConfirmacao();
    }

    public void listarItensInventario() {
        jogadorView.exibeMensagem("Listando itens do inventário de "+jogador.getNome());
        jogadorView.exibeListaDeItensInventario(jogador);
        jogadorView.aguardarConfirmacao();
    }

    public void exibirInformacoesJogador() {
        jogadorView.exibirInformacoesJogador(jogador);
        jogadorView.aguardarConfirmacao();
    }
}
