package monstros;

public class MonstroDeTerra  extends Monstro {

    public MonstroDeTerra(String nome, int nivel) {
        super(nome, nivel);
        this.tipo = "terra";
        this.dano = 13;
        this.vida = 35;
        this.fullVida = 35;
        this.ataqueBase = "Fio-Terra";
        this.multiplicadorBase = 1.0;
        this.ataqueEspecial = "Pedra que esmagou obito";
        this.multiplicadorEspecial = 1.25;
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
}
