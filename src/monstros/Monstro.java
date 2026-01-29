package monstros;

public class Monstro {
    public String nome;
    public String tipo;
    public int dano;
    public int vida;

    public Monstro(String nome) {
        this.nome = nome;
        this.tipo = "comum";
        this.dano = 10;
        this.vida = 30;
    }

}
