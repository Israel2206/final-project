package monstros;

public class MonstroDeFogo  extends Monstro{

    public MonstroDeFogo(String nome) {
        super(nome);
        this.tipo = "fogo";
        this.dano = 13;
        this.vida = 35;
        this.fullVida = 35;
        this.ataqueBase = "Rabada de Fogo";
        this.multiplicadorBase = 1.0;
        this.ataqueEspecial = "Fosforo com rexona";
        this.multiplicadorEspecial = 1.25;
    }
}
