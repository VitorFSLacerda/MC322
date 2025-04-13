import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Masmorra {
    private List<Monstro> monstros;
    private BauDeTesouros tesouros;

    public Masmorra(BauDeTesouros tesouros){
        this.tesouros = tesouros;
        this.monstros = new ArrayList<>();
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

    public String abrirPortaMonstro(Jogador jogador) {
        Random dado = new Random();
        int indiceMonstro = dado.nextInt(monstros.size());
        Monstro monstroSelecionado = monstros.get(indiceMonstro);
        Resultado resultadoBatalha = CampoDeBatalha.batalharContraMonstro(monstroSelecionado, jogador);
        StringBuilder texto = new StringBuilder();
        if (resultadoBatalha == Resultado.VITORIA) {

            int quantidadeTesouros = monstroSelecionado.getTesouros();
            List<Item> itensAleatorios = tesouros.pegarItensAleatorios(quantidadeTesouros);

            texto.append("Itens aleatórios obtidos do tesouro:"+"\n");
            for (Item item : itensAleatorios) {
                jogador.getInventario().adicionarItem(item);
                texto.append("- "+item.getName()+" - nível "+item.getBonusPoder()+"\n");
            
            }
            return texto.toString();

        } else if (resultadoBatalha == Resultado.FUGA) {

            return "Você conseguiu fugir do monstro!";

        } else if (resultadoBatalha == Resultado.DERROTA) {

            return "Você foi derrotado pelo monstro...\n"+"Com isso, você perdeu níveis!\n";
        } else {
            return "Resultado inesperado da batalha!";
        }
    }

    public String abrirPortaItem(Jogador jogador) {

        Scanner scanner = new Scanner(System.in);

        String nomeItemEscolhido = scanner.nextLine();
    

        List<Item> itensDisponiveis = tesouros.getItens();
        boolean itemEncontrado = false;
        for (Item item : itensDisponiveis) {
            if (item.getName().equals(nomeItemEscolhido)) {

                jogador.getInventario().adicionarItem(item);
                itemEncontrado = true;
                tesouros.removerItem(nomeItemEscolhido);
                break;
            }
        }
    
        if (!itemEncontrado) {
            return "Item não encontrado.";
        }
        return "Tudo Certo!";
    }
}
