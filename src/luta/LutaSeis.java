package luta;

import jogador.Jogador;
import monstros.*;
import paineis.Paineis;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class LutaSeis {

    private Jogador jogador;
    private Monstro monstroJogador;
    private Jogador jogadorInimigo;
    private Monstro monstroInimigo;
    private Paineis paineis = new Paineis();
    public boolean vitoria;

    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();
    private int chance = 75;

    public LutaSeis(Jogador jogador) {
        this.jogador = jogador;
        this.monstroJogador = jogador.getMonstro();

        int tipo = random.nextInt(4) + 1;

        switch (tipo) {
            case 1 -> monstroInimigo = new MonstroDeFogo("Ignivar", 6);
            case 2 -> monstroInimigo = new MonstroDeAgua("Marvolth", 6);
            case 3 -> monstroInimigo = new MonstroDeTerra("Gravorn", 6);
            default -> monstroInimigo = new MonstroDeAr("Aeris", 6);
        }

        jogadorInimigo = new Jogador("Desafiante da Arena", monstroInimigo);
    }

    public void iniciarLutaSeis() {
        paineis.painelLutaSeis();
        paineis.painelStatusBatalha(jogador, monstroInimigo, jogadorInimigo);

        System.out.println("\n======================");
        System.out.println("   Batalha Iniciada!");
        System.out.println("======================\n");

        do {
            turnoJogador();

            if (monstroInimigo.getVida() <= 0) {
                paineis.pausa(800);
                System.out.println("\nVocê venceu.");
                paineis.pausa(700);
                System.out.println("Mas o silêncio da arena é pesado.");
                paineis.pausa(900);

                monstroJogador.setVida(monstroJogador.getFullVida());
                jogador.setPocaoHp(jogador.getPocaoHp() + 1);

                System.out.println("Seu monstro recupera as forças.");
                paineis.pausa(1000);

                vitoria = true;
                break;
            }

            turnoInimigo();

            if (monstroJogador.getVida() <= 0) {
                paineis.pausa(900);
                System.out.println("\nVocê caiu na reta final.");
                paineis.pausa(1200);
                vitoria = false;
                break;
            }

        } while (monstroJogador.getVida() > 0 && monstroInimigo.getVida() > 0);
    }

    private void turnoJogador() {
        int escolha;

        while (true) {
            try {
                paineis.painelDaLuta(jogador, monstroJogador);
                System.out.print("Escolha uma ação: ");

                escolha = sc.nextInt();
                sc.nextLine();

                if (escolha == 3) {
                    jogador.usarPocao(jogador, monstroJogador);
                    continue;
                } else if (escolha == 4) {
                    monstroJogador.mostrarStatus(jogador, monstroJogador);
                    continue;
                }

                if (escolha >= 1 && escolha <= 4) break;

            } catch (InputMismatchException e) {
                sc.nextLine();
            }
        }

        switch (escolha) {
            case 1 -> monstroJogador.usarAtaqueBasico(monstroJogador, monstroInimigo, chance);
            case 2 -> monstroJogador.usarAtaqueEspecial(monstroJogador, monstroInimigo, chance);
        }
    }

    private void turnoInimigo() {
        paineis.pausa(700);
        System.out.println("\nO inimigo ataca!");
        paineis.pausa(700);

        if (random.nextInt(5) <= 2) {
            monstroInimigo.usarAtaqueBasico(monstroInimigo, monstroJogador, chance);
        } else {
            monstroInimigo.usarAtaqueEspecial(monstroInimigo, monstroJogador, chance);
        }
    }
}
