package monstros;

public class RolaBosta extends Monstro {

    public RolaBosta(String nome, int nivel) {
        super(nome, nivel);
        this.tipo = "Bosta";
        this.dano -= 2;
        this.fullVida += 15;
        this.vida = this.fullVida;
        this.ataqueBase = "Rolada de Bosta";
        this.multiplicadorBase = 1.0;
        this.ataqueEspecial = "Diarreia";
        this.multiplicadorEspecial = 1.45;
    }
}