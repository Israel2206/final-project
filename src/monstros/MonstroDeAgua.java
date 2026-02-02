package monstros;

public class MonstroDeAgua extends Monstro{

    public MonstroDeAgua(String nome, int nivel) {
        super(nome, nivel);
        this.tipo = "agua";
        this.dano = 13;
        this.vida = 35;
        this.fullVida = 35;
        this.ataqueBase = "chuva d'água";
        this.multiplicadorBase = 1.0;
        this.ataqueEspecial = "Tsunami";
        this.multiplicadorEspecial = 1.25;
    }

    @Override
    public double receberDano(Monstro inimigo){
        if (inimigo instanceof MonstroDeFogo){
            return 1.15;
        } else if (inimigo instanceof MonstroDeTerra){
            return 0.9;
        }
        return multiplicadorBase; //Este daqui é o else, pode-se dizer
    }


}
