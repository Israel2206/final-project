package monstros;

public class MonstroDeTerra  extends Monstro {

    public MonstroDeTerra(String nome, int nivel) {
        super(nome, nivel);
        this.tipo = "terra";
        this.vida = this.fullVida;
        this.ataqueBase = "Fio-Terra";
        this.multiplicadorBase = 1.0;
        this.ataqueEspecial = "Pedra que esmagou obito";
        this.multiplicadorEspecial = 1.30;
        this.ataqueDesbloqueado = "Terra Batida Premium";
        this.multiplicadorDesbloqueado = 1.40;
    }

    @Override
    public double receberDano(Monstro inimigo) {
        if (inimigo instanceof MonstroDeAgua){
            return 1.15;
        } else if (inimigo instanceof MonstroDeAr){
            return 0.9;
        }
        return multiplicadorBase; //Este daqui é o else, pode-se dizer
    }

    @Override
    public double receberDanoEspecial(Monstro inimigo) {
        if (inimigo instanceof MonstroDeAgua){
            return 1.4;
        } else if (inimigo instanceof MonstroDeAr){
            return 1.1;
        }
        return multiplicadorEspecial;
    }

    @Override
    public double receberDanoDesbloqueado(Monstro inimigo) {
        if (inimigo instanceof MonstroDeAgua){
            return 1.25;
        } else if (inimigo instanceof MonstroDeAr){
            return 1.05;
        }
        return multiplicadorDesbloqueado;
    }
}
