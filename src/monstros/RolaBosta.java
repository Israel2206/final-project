package monstros;

public class RolaBosta extends Monstro {

    public RolaBosta(String nome, int nivel) {
        super(nome, nivel);
        this.tipo = "Bosta";
        this.fullVida += 10;
        this.vida = this.fullVida;
        this.ataqueBase = "Rolada de Bosta";
        this.multiplicadorBase = 1.0;
        this.ataqueEspecial = "Diarreia";
        this.multiplicadorEspecial = 1.4;
        this.ataqueDesbloqueado = "Rolada Suprema Mas Nem Tanto";
        this.multiplicadorDesbloqueado = 1.15;
    }

    @Override
    public double receberDanoEspecial(Monstro inimigo) {
        return multiplicadorEspecial;
    }

    @Override
    public double receberDanoDesbloqueado(Monstro inimigo) {
        return multiplicadorDesbloqueado;
    }
}