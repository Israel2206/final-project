package luta;

import jogador.Jogador;
import monstros.Monstro;
import monstros.MonstroDeAgua;
import monstros.MonstroDeAr;
import monstros.MonstroDeTerra;
import paineis.Paineis;

import java.util.InputMismatchException;
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
    private int chance = 70;

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
            this.monstroInimigo = new MonstroDeAgua("Nero");
            this.jogadorInimigo = new Jogador("Kai", monstroInimigo);
        }
    }

    public void iniciarLutaUm(){
        paineis.painelStatusBatalha(jogador,monstroInimigo,jogadorInimigo);

        System.out.println("\n======================");
        System.out.println("   Batalha Iniciada!");
        System.out.println("======================\n");

        do {
            turnoDoJogador();

            if (monstroInimigo.getVida() <= 0) {
                paineis.pausa(600);
                System.out.println("\nVocê venceu a batalha!");
                paineis.pausa(900);

                System.out.println("Você recebeu +1 poção de HP!");
                paineis.pausa(700);
                jogador.setPocaoHp(jogador.getPocaoHp() + 1);

                System.out.println("A Vida do seu " + monstroJogador.getNome() + " está cheia novamente!");
                monstroJogador.setVida(monstroJogador.getFullVida());
                paineis.pausa(1000);
                vitoria = true;
                break;
            }

            turnoInimigo();

            if (monstroJogador.getVida() <= 0) {
                paineis.pausa(700);
                System.out.println("\nSeu monstro foi derrotado...");
                paineis.pausa(900);

                System.out.println("O inimigo nem parecia tão forte assim.");
                paineis.pausa(800);
                System.out.println("Talvez a diferença não estivesse na batalha...");
                paineis.pausa(800);
                System.out.println("Mas em quem estava tomando as decisões.");
                paineis.pausa(1200);
                vitoria=false;
                break;
            }
        } while (monstroJogador.getVida() > 0 && monstroInimigo.getVida() > 0);
    }

    // ================= TURNOS =================

    private void turnoDoJogador(){
        int escolha;

        while (true) {
            try {
                paineis.painelDaLuta(jogador,monstroJogador);

                System.out.print("Escolha uma ação: ");

                escolha = sc.nextInt();
                sc.nextLine(); // limpa buffer

                // esse if só funciona aqui!!!!!
                if (escolha == 3){
                    paineis.pausa(400);
                    jogador.usarPocao(jogador, monstroJogador);
                    paineis.pausa(600);
                    continue;
                }

                if (escolha >= 1 && escolha <= 4) {
                    break;
                } else {
                    paineis.pausa(300);
                    System.out.println("Opção inválida! Digite apenas 1, 2, 3 ou 4.");
                }

            } catch (InputMismatchException e) {
                sc.nextLine();
                paineis.pausa(300);
                System.out.println("Entrada inválida! Digite apenas números.");
            }
        }

        paineis.pausa(500);
        switch (escolha) {
            case 1 -> monstroJogador.usarAtaqueBasico(monstroJogador, monstroInimigo, chance);
            case 2 -> monstroJogador.usarAtaqueEspecial(monstroJogador, monstroInimigo);
            case 4 -> monstroJogador.fugir();
        }
    }

    private void turnoInimigo() {
        paineis.pausa(600);
        System.out.println("\nO " + monstroInimigo.getNome() + " ataca!");
        paineis.pausa(700);

        int sorteDoMonstro = random.nextInt(5)+1;
        if (sorteDoMonstro <= 3){
            monstroInimigo.usarAtaqueBasico(monstroInimigo,monstroJogador,chance);
        } else {
            monstroInimigo.usarAtaqueEspecial(monstroInimigo,monstroJogador);
        }
    }
}
