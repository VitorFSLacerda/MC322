import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Masmorra {
    private List<Monstro> monstros;
    private BauDeTesouros tesouros;

    public Masmorra(BauDeTesouros tesouros){
        this.tesouros = tesouros;
        this.monstros = new LinkedList<>();
    }
    
    public List<Monstro> getMonstros() {
        return monstros;
    }

    public void setMonstros(List<Monstro> monstros) {
        this.monstros = monstros;
    }

    public BauDeTesouros getTesouros() {
        return tesouros;
    }

    public void setTesouros(BauDeTesouros tesouros) {
        this.tesouros = tesouros;
    }

    public void abrirPortaMonstro(Jogador jogador) {
        Random dado = new Random();
        int indiceMonstro = dado.nextInt(monstros.size());
        Monstro monstroSelecionado = monstros.get(indiceMonstro);
        Resultado resultadoBatalha = CampoDeBatalha.batalharContraMonstro(monstroSelecionado, jogador);
        
        if (resultadoBatalha == Resultado.VITORIA) {

            int quantidadeTesouros = monstroSelecionado.getTesouros();
            List<Item> itensAleatorios = tesouros.pegarItensAleatorios(quantidadeTesouros);

            System.out.println("Itens aleatórios obtidos do tesouro:");
            for (Item item : itensAleatorios) {
                jogador.getInventario().adicionarItem(item);
                System.out.println("- " + item.getName() + " - nível " + item.getBonusPoder());
            }

        } else if (resultadoBatalha == Resultado.FUGA) {

            System.out.println("Você conseguiu fugir do monstro!");

        } else if (resultadoBatalha == Resultado.DERROTA) {

            System.out.println("Você foi derrotado pelo monstro...\n"+
                                "Com isso, você perdeu níveis!\n");
        }
    }

    public void abrirPortaItem(Jogador jogador) {

        System.out.println("Que sorte! Você pode escolher um entre dois itens!\n");
        tesouros.listarItens();

        System.out.println("\nDigite o nome do item que deseja.\n");
        Scanner scanner = new Scanner(System.in);

        String nomeItemEscolhido = scanner.nextLine();
    
        List<Item> itensDisponiveis = tesouros.getItens();
        boolean itemEncontrado = false;
        for (Item item : itensDisponiveis) {
            if (item.getName().equals(nomeItemEscolhido)) {
                // Adicionar o item escolhido ao inventário do jogador
                jogador.getInventario().adicionarItem(item);
                System.out.println("Você escolheu o item: " + item.getName());
                itemEncontrado = true;
                break;
            }
        }
    
        if (!itemEncontrado) {
            System.out.println("Item não encontrado.");
        }
    }
}
