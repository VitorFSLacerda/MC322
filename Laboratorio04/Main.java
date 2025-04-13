import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        String directoryPath = "c:\\Users\\Pichau\\Desktop\\GithubMC322\\laboratorio-3-VitorFSLacerda";

        String jogadoresFilePath = Paths.get(directoryPath, "jogadores.xml").toString();
        String monstrosFilePath = Paths.get(directoryPath, "monstros.xml").toString();
        String itensFilePath = Paths.get(directoryPath, "itens.xml").toString();

        Jogo jogo = new Jogo();

        LerJogadores lerJogadores = new LerJogadores();
        lerJogadores.lerArquivo(jogo, jogadoresFilePath);

        LerMonstros lerMonstros = new LerMonstros();
        lerMonstros.lerArquivo(jogo, monstrosFilePath);

        LerTesouros lerTesouros = new LerTesouros();
        lerTesouros.lerArquivo(jogo, itensFilePath);

        jogo.iniciarJogo();
    }
}
