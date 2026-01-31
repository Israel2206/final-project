package luta;

import jogador.Jogador;
import monstros.Monstro;
import monstros.MonstroDeAr;
import monstros.MonstroDeTerra;
import paineis.Paineis;

import java.util.Random;
import java.util.Scanner;

public class LutaUm {
    private Jogador jogador;
    private Monstro monstroJogador;
    private Jogador jogadorInimigo;
    private Monstro monstroInimigo;
    private Paineis paineis = new Paineis();
    public boolean vitoria;

    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();

    //Construtor
    public LutaUm(Jogador jogador) {
        //Jogador
        this.jogador = jogador;
        this.monstroJogador = jogador.getMonstro();

        //Monstros dos inimigos vão ser 3 aleatórios
        int monstroAleatorio = random.nextInt(3)+1;
        if (monstroAleatorio == 1){
            this.monstroInimigo = new MonstroDeAr("Sky");
            this.jogadorInimigo = new Jogador("Axel", monstroInimigo);
        } else if (monstroAleatorio == 2){
            this.monstroInimigo = new MonstroDeTerra("Rok");
            this.jogadorInimigo = new Jogador("Dante", monstroInimigo);
        } else {
            this.monstroInimigo = new MonstroDeTerra("Nero");
            this.jogadorInimigo = new Jogador("Kai", monstroInimigo);
        }
    }


}
