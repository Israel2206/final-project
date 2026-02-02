package monstros;

public class MonstroDeAr extends Monstro{

    public MonstroDeAr(String nome, int nivel) {
        super(nome, nivel);
        this.tipo = "ar";
        this.dano += 3;
        this.fullVida += 5;
        this.vida = this.fullVida;
        this.ataqueBase = "Ventania Braba";
        this.multiplicadorBase = 1.0;
        this.ataqueEspecial = "Furacão Catrina";
        this.multiplicadorEspecial = 1.25;
    }

    @Override
    public double receberDano(Monstro inimigo) {
        if (inimigo instanceof MonstroDeTerra){
            return 1.15;
        } else if (inimigo instanceof MonstroDeFogo){
            return 0.9;
        }
        return multiplicadorBase; //Este daqui é o else, pode-se dizer
    }

    @Override
    public double receberDanoEspecial(Monstro inimigo) {
        if (inimigo instanceof MonstroDeTerra){
            return 1.4;
        } else if (inimigo instanceof MonstroDeFogo){
            return 1.1;
        }
        return multiplicadorEspecial;
    }
}
