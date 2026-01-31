package monstros;

public class MonstroDeTerra  extends Monstro {

    public MonstroDeTerra(String nome) {
        super(nome);
        this.tipo = "terra";
        this.dano = 13;
        this.vida = 35;
        this.fullVida = 35;
    }
}
