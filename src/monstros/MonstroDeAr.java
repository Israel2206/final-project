package monstros;

public class MonstroDeAr extends Monstro{

    public MonstroDeAr(String nome) {
        super(nome);
        this.tipo = "ar";
        this.dano = 13;
        this.vida = 35;
        this.fullVida = 35;
        this.ataqueBase = "Ventania Braba";
        this.multiplicadorBase = 1.0;
        this.ataqueEspecial = "Furacão Catrina";
        this.multiplicadorEspecial = 1.25;
    }
}
