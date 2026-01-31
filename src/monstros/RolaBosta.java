package monstros;

public class RolaBosta extends Monstro {

    public RolaBosta(String nome) {
        super(nome);
        this.tipo = "Bosta";
        this.dano = 7;
        this.vida = 45;
        this.fullVida = 45;
        this.ataqueBase = "Rolada de Bosta";
        this.multiplicadorBase = 1.0;
        this.ataqueEspecial = "Diarreia";
        this.multiplicadorEspecial = 1.45;
    }
}