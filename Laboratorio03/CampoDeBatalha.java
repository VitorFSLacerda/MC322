import java.util.Random;

public class CampoDeBatalha {

    public static Resultado batalharContraMonstro(Monstro monstro, Jogador jogador){

        if(jogador.poderJogador() > monstro.getPoder()){          
            return Resultado.VITORIA;
        }else{
            Random dado = new Random();
            int decisao = dado.nextInt(7);
            if(decisao == 5 || decisao == 6){
                return Resultado.FUGA;
            }else{
                jogador.setNivel(jogador.getNivel() - monstro.getNiveisPerdidos());
                return Resultado.DERROTA;
            }
        }
    }
}
