import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BauDeTesouros extends Inventario {

    private static BauDeTesouros instancia;

    private BauDeTesouros(int limiteDeItens) {
        super(limiteDeItens);
    }

    public static BauDeTesouros getInstance(int limiteDeItens) {
        if (instancia == null) {
            instancia = new BauDeTesouros(limiteDeItens);
        }
        return instancia;
    }

    public List<Item> pegarItensAleatorios(int quantidade) {
        List<Item> lstAleatoria = new LinkedList<>();
        List<Item> itens = getItens();

        if (quantidade > itens.size()) {
            throw new IllegalArgumentException("Quantidade solicitada excede o número de itens disponíveis.");
        }

        for (int i = 0; i < quantidade; i++) {
            Item itemSorteado = sortearElemento(itens);
            lstAleatoria.add(itemSorteado);
            removerItem(itemSorteado.getName());
        }
        return lstAleatoria;
    }

    public Item acessarItem(String nome) {
        List<Item> itens = getItens();
        if (itens == null) {
            return null;
        }
        for (Item item : itens) {
            if (item.getName().equals(nome)) {
                removerItem(nome);
                return item;
            }
        }
        return null;
    }

    public void listarItens() {
        List<Item> itens = getItens();
        if (itens.size() < 2) {
            System.out.println("Não há itens suficientes para listar.");
            return;
        }

        Item itemSorteado1 = sortearElemento(itens);
        Item itemSorteado2;

        do {
            itemSorteado2 = sortearElemento(itens);
        } while (itemSorteado2 == itemSorteado1);

        System.out.println("- " + itemSorteado1.getName() + " - nível " + itemSorteado1.getBonusPoder());
        System.out.println("- " + itemSorteado2.getName() + " - nível " + itemSorteado2.getBonusPoder());
    }

    public static <T> T sortearElemento(List<T> lista) {
        if (lista == null || lista.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int indiceSorteado = random.nextInt(lista.size());
        return lista.get(indiceSorteado);
    }
}