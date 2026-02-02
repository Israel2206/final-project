package luta;

import jogador.Jogador;
import monstros.*;
import paineis.Paineis;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class LutaQuatro {

    private Jogador jogador;
    private Monstro monstroJogador;
    private Jogador jogadorInimigo;
    private Monstro monstroInimigo;
    private Paineis paineis = new Paineis();
    public boolean vitoria;

    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();
    private int chance = 55;

    // Construtor
    public LutaQuatro(Jogador jogador) {
        this.jogador = jogador;
        this.monstroJogador = jogador.getMonstro();

        int sorteio = random.nextInt(4) + 1;

        switch (sorteio) {
            case 1 -> {
                monstroInimigo = new MonstroDeAgua("Hydron", 7);
                jogadorInimigo = new Jogador("Aqua", monstroInimigo);
            }
            case 2 -> {
                monstroInimigo = new MonstroDeFogo("Pyrox", 7);
                jogadorInimigo = new Jogador("Ignis", monstroInimigo);
            }
            case 3 -> {
                monstroInimigo = new MonstroDeTerra("Coloss", 7);
                jogadorInimigo = new Jogador("Gael", monstroInimigo);
            }
            default -> {
                monstroInimigo = new MonstroDeAr("Zephy", 7);
                jogadorInimigo = new Jogador("Aeris", monstroInimigo);
            }
        }
    }

    public void iniciarLutaQuatro() {

        paineis.pausa(800);
        System.out.println("\n======================================");
        System.out.println("\nA arena reage à presença do próximo lutador.");
        paineis.pausa(700);
        System.out.println("O ambiente muda diante dos seus olhos.");
        paineis.pausa(700);
        System.out.println("Você não sabe o que vem pela frente.\n");
        System.out.println("======================================\n");
        paineis.pausa(900);

        paineis.painelStatusBatalha(jogador, monstroInimigo, jogadorInimigo);

        System.out.println("\n======================");
        System.out.println("   Batalha Iniciada!");
        System.out.println("======================\n");

        do {
            turnoDoJogador();

            if (monstroInimigo.getVida() <= 0) {
                paineis.pausa(600);
                System.out.println("\nVitória!");
                paineis.pausa(700);

                System.out.println("A plateia começa a reconhecer seu nome.");
                paineis.pausa(700);

                System.out.println("Você recebeu +1 poção de HP!");
                jogador.setPocaoHp(jogador.getPocaoHp() + 1);
                paineis.pausa(700);

                monstroJogador.setVida(monstroJogador.getFullVida());
                System.out.println("Seu monstro recuperou toda a vida!");
                paineis.pausa(1000);

                vitoria = true;
                break;
            }

            turnoInimigo();

            if (monstroJogador.getVida() <= 0) {
                paineis.pausa(700);
                System.out.println("\nDerrota...");
                paineis.pausa(900);

                System.out.println("No torneio, imprevisibilidade é tudo.");
                paineis.pausa(900);
                System.out.println("Nem sempre a força vence.");
                paineis.pausa(1200);

                vitoria = false;
                break;
            }

        } while (monstroJogador.getVida() > 0 && monstroInimigo.getVida() > 0);
    }

    // ================= TURNOS =================

    private void turnoDoJogador() {
        int escolha;

        while (true) {
            try {
                paineis.painelDaLuta(jogador, monstroJogador);
                System.out.print("Escolha uma ação: ");

                escolha = sc.nextInt();
                sc.nextLine();

                if (escolha == 3) {
                    jogador.usarPocao(jogador, monstroJogador);
                    paineis.pausa(600);
                    continue;
                }

                if (escolha >= 1 && escolha <= 4) {
                    break;
                } else {
                    System.out.println("Opção inválida!");
                }

            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Digite apenas números.");
            }
        }

        paineis.pausa(400);
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

        int sorte = random.nextInt(4) + 1;
        if (sorte <= 2) {
            monstroInimigo.usarAtaqueEspecial(monstroInimigo, monstroJogador);
        } else {
            monstroInimigo.usarAtaqueBasico(monstroInimigo, monstroJogador, chance);
        }
    }
}
