import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LerMonstros implements I_Arquivo{
    
    @Override
    public void lerArquivo (Jogo jogo, String path ) {
        List<Monstro> monstros = new ArrayList<>();
        
        try {
            File file = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse( file );
            doc.getDocumentElement().normalize();
            
            NodeList nodeList = doc.getElementsByTagName("Monstro");

            for (int i = 0; i < nodeList.getLength(); i ++){

                Element monstroElement = (Element)nodeList.item(i);
                
                String nome = monstroElement.getElementsByTagName("nome").item(0).getTextContent();
                int poder = Integer.parseInt(monstroElement.getElementsByTagName("poder").item(0).getTextContent()); 
                int tesouros = Integer.parseInt(monstroElement.getElementsByTagName("tesouros").item(0).getTextContent());
                int niveisPerdidos = Integer.parseInt(monstroElement.getElementsByTagName("niveisPerdidos").item(0).getTextContent());
                
                Monstro monstro = new Monstro(nome, poder, tesouros, niveisPerdidos);
                
                monstros.add(monstro);
            }
        } catch(Exception e) {
            System.err.println("Erro ao ler o arquivo: "+e.getMessage());
            e.printStackTrace();

        }

        jogo.setMonstros(monstros);
    }

}
