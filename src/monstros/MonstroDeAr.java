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

    @Override
    public double receberDano(Monstro inimigo) {
        if (inimigo instanceof MonstroDeTerra){
            return 1.15;
        } else if (inimigo instanceof MonstroDeFogo){
            return 0.9;
        }
        return multiplicadorBase; //Este daqui é o else, pode-se dizer
    }
}
