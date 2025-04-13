package Laboratorio01;

public class Monstro {
    
    private String nome;
    private int poder;
    private int quantidadeDeTesouros;
    private int niveisPerdidos;

    public Monstro (String nome, int poder, int quantidadeDeTesouros, int niveisPerdidos) {
        
        this.nome = nome;
        this.poder = poder;
        this.quantidadeDeTesouros = quantidadeDeTesouros;
        this.niveisPerdidos = niveisPerdidos;        
    }

    public String getNome(){
        return nome;
    }

    public int getPoder(){
        return poder;
    }

    public int getQuantidadeDeTesouros(){
        return quantidadeDeTesouros;
    }

    public int getNiveisPerdidos(){
        return niveisPerdidos;
    }

    public void setName(String novoNome){

        this.nome = novoNome;
    }

    public void setPoder(int novoPoder){

        this.poder = novoPoder;
    }

    public void setQuantidadeDeTesouros(int novaQuantidadeDeTesouros){

        this.quantidadeDeTesouros = novaQuantidadeDeTesouros;
    }

    public void setNiveisPerdidos(int novoNivelPerdido){

        this.niveisPerdidos = novoNivelPerdido;
    }

    public String toString(){

        return nome+"\n"+poder+"\n"+quantidadeDeTesouros+"\n"+niveisPerdidos+"\n";
    }
}
