package monstros;

public class MonstroDeFogo  extends Monstro{

    public MonstroDeFogo(String nome) {
        super(nome);
        this.tipo = "fogo";
        this.dano = 13;
        this.vida = 35;
        this.fullVida = 35;
    }
}
