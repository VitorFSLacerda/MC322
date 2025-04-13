package Laboratorio01;

public class Jogador {
    
    private String nome;
    private int nivel;
    private String raca;
    private String classe;
    private String itemCabeca;
    private String itemCorpo;
    private String itemMaoDireita;
    private String itemMaoEsquerda;
    private String itemPe;

    public Jogador (String nome, int nivel, String raca, String classe,
                    String itemCabeca, String itemCorpo, String itemMaoDireita,
                    String itemMaoEsquerda, String itemPe) {
        
        this.nome = nome;
        this.nivel = nivel;
        this.raca = raca;
        this.classe = classe;
        this.itemCabeca = itemCabeca;
        this.itemCorpo = itemCorpo;
        this.itemMaoDireita = itemMaoDireita;
        this.itemMaoEsquerda = itemMaoEsquerda;
        this.itemPe = itemPe;
    }

    public String getNome(){
        return nome;
    }

    public int getNivel(){
        return nivel;
    }

    public String getRaca(){
        return raca;
    }

    public String getClasse(){
        return classe;
    }

    public String getItemCabeca(){
        return itemCabeca;
    }

    public String getItemCorpo(){
        return itemCorpo;
    }

    public String getItemMaoDireita(){
        return itemMaoDireita;
    }

    public String getItemMaoEsquerda(){
        return itemMaoEsquerda;
    }

    public String getItemPe(){
        return itemPe;
    }

    public void setName(String novoNome){

        this.nome = novoNome;
    }

    public void setNivel(int novoNivel){

        this.nivel = novoNivel;
    }
    
    public void setRaca(String novaRaca){

        this.raca = novaRaca;
    }

    public void setClasse(String novaClasse){

        this.classe = novaClasse;
    }

    public void setItemCabeca(String novoItemCabeca){

        this.itemCabeca = novoItemCabeca;
    }

    public void setItemCorpo(String novoItemCorpo){

        this.itemCorpo = novoItemCorpo;
    }

    public void setItemMaoDireita(String novoItemMaoDireita){

        this.itemMaoDireita = novoItemMaoDireita;
    }

    public void setItemMaoEsquerda(String novoItemMaoEsquerda){

        this.itemMaoEsquerda = novoItemMaoEsquerda;
    }

    public void setItemPe(String novoItemPe){

        this.itemPe = novoItemPe;
    }

    public String toString(){

        return nome+"\n"+nivel+"\n"+raca+"\n"+classe+"\n"+itemCabeca+"\n"+itemCorpo+"\n"+
                itemMaoDireita+"\n"+itemMaoEsquerda+"\n"+itemPe+"\n";
    }

    public boolean possuiMaoVazia(){

        if(itemMaoDireita.length() != 0 && itemMaoEsquerda.length() != 0 ){
            return false; // Mãos sendo usadas

        }
        else if(itemMaoDireita.length() == 0){
            return true; //Mão direita livre

        }else{
            return true; // Mão esquerda livre

        }
    }

}