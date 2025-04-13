package Laboratorio01;

public class Item {
    
    private String nome;
    private int bonusPoder;
    private int valor;
    private String tipo;

    public Item (String nome, int bonusPoder, int valor, String tipo) {
        
        this.nome = nome;
        this.bonusPoder = bonusPoder;
        this.valor = valor;
        this.tipo = tipo;        
    }

    public String getName(){
        return nome;
    }

    public int getBonusPoder(){
        return bonusPoder;
    }

    public int getValor(){
        return valor;
    }

    public String getTipo(){
        return tipo;
    }

    public void setName(String novoNome){

        this.nome = novoNome;
    }

    public void setBonusPoder(int novoBonusPoder){

        this.bonusPoder = novoBonusPoder;
    }

    public void setValor(int novoValor){

        this.valor = novoValor;
    }

    public void setTipo(String novoTipo){

        this.tipo = novoTipo;
    }

    public String toString(){

        return nome+"\n"+bonusPoder+"\n"+valor+"\n"+tipo+"\n";
    }
}