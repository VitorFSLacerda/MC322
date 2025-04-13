import java.util.Scanner;

public class JogadorView {

    private Scanner scanner;

    public JogadorView() {
        scanner = new Scanner(System.in);
    }

    public void aguardarConfirmacao() {
        System.out.println("Digite 0 para voltar ou qualquer outro número para continuar:");
        int escolha = scanner.nextInt();
        if (escolha != 0) {
            System.out.println("Opção inválida. Voltando ao menu.");
        }
    }
    
    public void exibeMensagem(String str) {
        System.out.println(str);
    }

    public void exibeListaDeItensInventario(Jogador jogador) {
        jogador.getInventario().listarItens();
    }

    public void exibirInformacoesJogador(Jogador jogador) {
        System.out.println(jogador.toString());
    }
}
