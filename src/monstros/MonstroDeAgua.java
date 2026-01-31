package monstros;

public class MonstroDeAgua extends Monstro{

    public MonstroDeAgua(String nome) {
        super(nome);
        this.tipo = "agua";
        this.dano = 13;
        this.vida = 35;
        this.fullVida = 35;
        this.ataqueBase = "chuva d'água";
        this.multiplicadorBase = 1.0;
        this.ataqueEspecial = "Tsunami";
        this.multiplicadorEspecial = 1.25;
    }
}
