import java.util.Random;

public class MasmorraController {

    private Masmorra masmorra;
    private MasmorraView masmorraView;

    public MasmorraController(Masmorra masmo){
        this.masmorra = masmo;
        this.masmorraView = new MasmorraView();
    }

    public void abrirPorta(Jogador jogador) {
        Random random = new Random();
        int decisao = random.nextInt(2);

        if (decisao == 1) {
            masmorraView.exibeMensagem(masmorra.abrirPortaItem(jogador));
        } else {
            masmorraView.exibeMensagem(masmorra.abrirPortaMonstro(jogador));
        }
        masmorraView.aguardarConfirmacao();
    }
}
