import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LerTesouros implements I_Arquivo{
    
    @Override
    public void lerArquivo (Jogo jogo, String path) {
        List<Item> itens = new ArrayList<>();

        try {
            File file = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse( file );
            doc.getDocumentElement().normalize();
            
            NodeList nodeList = doc.getElementsByTagName("Item");

            for (int i = 0; i < nodeList.getLength(); i ++){
                
                Element itemElement = (Element)nodeList.item(i);
                
                String nome = itemElement.getElementsByTagName("nome").item(0).getTextContent();
                int bonusPoder = Integer.parseInt(itemElement.getElementsByTagName("bonusPoder").item(0).getTextContent()); 
                int valor = Integer.parseInt(itemElement.getElementsByTagName("valor").item(0).getTextContent());
                TipoItem tipo = TipoItem.valueOf(itemElement.getElementsByTagName("tipo").item(0).getTextContent());
                boolean itemGrande = Boolean.parseBoolean(itemElement.getElementsByTagName("itemGrande").item(0).getTextContent());
                
                Item item = new Item(nome, bonusPoder, valor, tipo, itemGrande);


                NodeList classesList = itemElement.getElementsByTagName("classe");

                for (int j = 0; j < classesList.getLength(); j++) {

                    String className = classesList.item(j).getTextContent();
                    Classe classe;
                    if(className.equalsIgnoreCase("GUERREIRO")){
                        classe = Classe.GUERREIRO;

                    }else if(className.equalsIgnoreCase("LADRAO")){
                        classe = Classe.LADRAO;

                    }else{
                        classe = Classe.MAGO;
                    }
                    item.getClassesCompativeis().add(classe);
                }

                NodeList racasList = itemElement.getElementsByTagName("raca");
                for (int k = 0; k < racasList.getLength(); k++) {
                    String racaName = racasList.item(k).getTextContent();
                    Raca raca = Raca.valueOf(racaName);
                    item.getRacasCompativeis().add(raca);
                }
                
                itens.add(item);
            }
        } catch(Exception e) {
            System.err.println("Erro ao ler o arquivo: "+e.getMessage());
            e.printStackTrace();

        }
        
        BauDeTesouros tesouros = BauDeTesouros.getInstance(itens.size());
        jogo.adicionarTesouros(itens, tesouros);
    }

}