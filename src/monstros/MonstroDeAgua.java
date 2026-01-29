package monstros;

public class MonstroDeAgua extends Monstro{

    public MonstroDeAgua(String nome) {
        super(nome);
        this.tipo = "agua";
        this.dano = 13;
        this.vida = 35;
    }
}
