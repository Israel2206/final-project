package monstros;

import jogador.Jogador;

public class MonstroDeAgua extends Monstro{

    public MonstroDeAgua(String nome, int nivel) {
        super(nome, nivel);
        this.tipo = "agua";
        this.vida = this.fullVida;
        this.ataqueBase = "chuva d'água";
        this.multiplicadorBase = 1.0;
        this.ataqueEspecial = "Tsunami";
        this.multiplicadorEspecial = 1.25;
        this.ataqueDesbloqueado = "Hidratação Forcada";
        this.multiplicadorDesbloqueado = 1.15;
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

    @Override
    public double receberDanoEspecial(Monstro inimigo) {
        if (inimigo instanceof MonstroDeFogo){
            return 1.4;
        } else if (inimigo instanceof MonstroDeTerra){
            return 1.1;
        }
        return multiplicadorEspecial;
    }

    @Override
    public double receberDanoDesbloqueado(Monstro inimigo) {
        if (inimigo instanceof MonstroDeFogo){
            return 1.25;
        } else if (inimigo instanceof MonstroDeTerra){
            return 1.05;
        }
        return multiplicadorDesbloqueado;
    }
}
