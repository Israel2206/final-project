package monstros;

public class MonstroDeFogo  extends Monstro{

    public MonstroDeFogo(String nome, int nivel) {
        super(nome, nivel);
        this.tipo = "fogo";
        this.vida = this.fullVida;
        this.ataqueBase = "Rabada de Fogo";
        this.multiplicadorBase = 1.0;
        this.ataqueEspecial = "Fosforo com rexona";
        this.multiplicadorEspecial = 1.30;
        this.ataqueDesbloqueado = "Fogo Em 1080p";
        this.multiplicadorDesbloqueado = 1.40;
    }

    @Override
    public double receberDano(Monstro inimigo) {
        if (inimigo instanceof MonstroDeAr){
            return 1.15;
        } else if (inimigo instanceof MonstroDeAgua){
            return 0.9;
        }
        return multiplicadorBase; //Este daqui é o else, pode-se dizer
    }

    @Override
    public double receberDanoEspecial(Monstro inimigo) {
        if (inimigo instanceof MonstroDeAr){
            return 1.4;
        } else if (inimigo instanceof MonstroDeAgua){
            return 1.1;
        }
        return multiplicadorEspecial;
    }

    @Override
    public double receberDanoDesbloqueado(Monstro inimigo) {
        if (inimigo instanceof MonstroDeAr){
            return 1.25;
        } else if (inimigo instanceof MonstroDeAgua){
            return 1.05;
        }
        return multiplicadorDesbloqueado;
    }
}
