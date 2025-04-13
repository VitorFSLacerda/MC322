import java.util.Scanner;

public class MasmorraView {
    private Scanner scanner;

    public MasmorraView() {
        scanner = new Scanner(System.in);
    }

    public void exibeMensagem(String str){
        System.out.println(str);
    }

    public void mensagemPortaItem(Masmorra masmorra) {
        exibeMensagem("Que sorte! Você pode escolher um entre dois itens!\n");
        exibeMensagem("Itens disponíveis:");
        masmorra.getTesouros().listarItens();
        System.out.println("\nDigite o nome do item que deseja.\n");
    }

    public void aguardarConfirmacao() {
        System.out.println("Digite 0 para voltar ou qualquer outro número para continuar:");
        int escolha = scanner.nextInt();
        if (escolha != 0) {
            System.out.println("Opção inválida. Voltando ao menu.");
        }
    }
}

