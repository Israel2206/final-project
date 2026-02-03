package luta;

import jogador.Jogador;
import monstros.Monstro;
import monstros.MonstroDeTerra;
import monstros.RolaBosta;
import paineis.Paineis;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class LutaRolaBosta {

    private Jogador jogador;
    private Monstro monstroJogador;
    private Jogador jogadorInimigo;
    private Monstro monstroInimigo;
    private Paineis paineis = new Paineis();

    public boolean vitoria;

    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();


    private int chanceJogador = 60;
    private int chanceInimigo = 95;

    public LutaRolaBosta(Jogador jogador) {
        this.jogador = jogador;
        this.monstroJogador = jogador.getMonstro();

        // Boss secreto absurdo
        this.monstroInimigo = new RolaBosta("Rola-Bosta Ancestral", 18);
        this.jogadorInimigo = new Jogador("???", monstroInimigo);
    }

    public void iniciarLutaRolaBosta() {
        paineis.painelLutaRolaBosta();

        paineis.painelStatusBatalha(jogador, monstroInimigo, jogadorInimigo);

        System.out.println("\n======================");
        System.out.println("  DESAFIO SECRETO!");
        System.out.println("======================\n");

        do {
            turnoDoJogador();

            if (monstroInimigo.getVida() <= 0) {
                paineis.pausa(800);
                System.out.println("\nO impossível aconteceu.");
                paineis.pausa(900);
                System.out.println("O Rola-Bosta foi derrotado.");
                paineis.pausa(900);
                System.out.println("Ninguém vai acreditar em você.");
                paineis.pausa(1200);

                vitoria = true;
                break;
            }

            turnoInimigo();

            if (monstroJogador.getVida() <= 0) {
                paineis.pausa(700);
                System.out.println("\nVocê foi humilhado.");
                paineis.pausa(900);
                System.out.println("Derrotado por um Rola-Bosta.");
                paineis.pausa(900);
                System.out.println("O público nunca vai esquecer disso.");
                paineis.pausa(1200);

                vitoria = false;
                break;
            }

        } while (monstroJogador.getVida() > 0 && monstroInimigo.getVida() > 0);
    }

    private void turnoDoJogador() {
        int escolha;

        while (true) {
            try {
                paineis.painelPosLutaQuatro(jogador, monstroJogador);
                System.out.print("Escolha uma ação: ");

                escolha = sc.nextInt();
                sc.nextLine();

                if (escolha == 4) {
                    paineis.pausa(400);
                    jogador.usarPocao(jogador, monstroJogador);
                    paineis.pausa(600);
                    continue;
                } else if (escolha == 5) {
                    paineis.pausa(500);
                    monstroJogador.mostrarStatus(jogador, monstroJogador);
                    continue;
                }

                if (escolha >= 1 && escolha <= 5) {
                    break;
                } else {
                    paineis.pausa(300);
                    System.out.println("Opção inválida!");
                }

            } catch (InputMismatchException e) {
                sc.nextLine();
                paineis.pausa(300);
                System.out.println("Digite apenas números!");
            }
        }

        paineis.pausa(500);
        switch (escolha) {
            case 1 -> monstroJogador.usarAtaqueBasico(monstroJogador, monstroInimigo, chanceJogador);
            case 2 -> monstroJogador.usarAtaqueEspecial(monstroJogador, monstroInimigo, chanceJogador);
            case 3 -> monstroJogador.usarAtaqueConquistado(monstroJogador, monstroInimigo, chanceJogador);
        }
    }

    private void turnoInimigo() {
        paineis.pausa(600);
        System.out.println("\nO Rola-Bosta avança lentamente...");
        paineis.pausa(700);

        int sorte = random.nextInt(4) + 1;

        if (sorte <= 2) {
            monstroInimigo.usarAtaqueBasico(monstroInimigo, monstroJogador, chanceInimigo);
        } else {
            monstroInimigo.usarAtaqueEspecial(monstroInimigo, monstroJogador, chanceInimigo);
            monstroInimigo.setLimiteDeAtaqueEspecial(monstroInimigo.getATAQUE_DESBLOQUEADO());
        }
    }
}
