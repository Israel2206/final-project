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
    private int chance = 60;

    public LutaQuatro(Jogador jogador) {
        this.jogador = jogador;
        this.monstroJogador = jogador.getMonstro();

        int sorteio = random.nextInt(4) + 1;

        if (sorteio == 1) {
            monstroInimigo = new MonstroDeFogo("Blazer", 5);
            jogadorInimigo = new Jogador("Ignis", monstroInimigo);
        } else if (sorteio == 2) {
            monstroInimigo = new MonstroDeAgua("Hydron", 4);
            jogadorInimigo = new Jogador("Aqua", monstroInimigo);
        } else if (sorteio == 3) {
            monstroInimigo = new MonstroDeTerra("Terrak", 5);
            jogadorInimigo = new Jogador("Gron", monstroInimigo);
        } else {
            monstroInimigo = new MonstroDeAr("Zeph", 4);
            jogadorInimigo = new Jogador("Aeris", monstroInimigo);
        }
    }

    public void iniciarLutaQuatro() {
        paineis.painelLutaQuatro();

        paineis.painelStatusBatalha(jogador, monstroInimigo, jogadorInimigo);

        System.out.println("\n======================");
        System.out.println("   Batalha Iniciada!");
        System.out.println("======================\n");

        do {
            turnoDoJogador();

            if (monstroInimigo.getVida() <= 0) {
                System.out.println("\nVocê venceu a batalha!");
                jogador.setPocaoHp(jogador.getPocaoHp() + 1);
                monstroJogador.setVida(monstroJogador.getFullVida());
                vitoria = true;
                break;
            }

            turnoInimigo();

            if (monstroJogador.getVida() <= 0) {
                System.out.println("\nSeu monstro foi derrotado...");
                vitoria = false;
                break;
            }

        } while (monstroJogador.getVida() > 0 && monstroInimigo.getVida() > 0);
    }

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
                    continue;
                } else if (escolha == 4) {
                    monstroJogador.mostrarStatus(jogador, monstroJogador);
                    continue;
                }

                if (escolha == 1 || escolha == 2) {
                    break;
                } else {
                    System.out.println("Opção inválida!");
                }

            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Entrada inválida!");
            }
        }

        switch (escolha) {
            case 1 -> monstroJogador.usarAtaqueBasico(monstroJogador, monstroInimigo, chance);
            case 2 -> monstroJogador.usarAtaqueEspecial(monstroJogador, monstroInimigo, chance);
        }
    }

    private void turnoInimigo() {
        System.out.println("\nO " + monstroInimigo.getNome() + " ataca!");

        if (random.nextBoolean()) {
            monstroInimigo.usarAtaqueBasico(monstroInimigo, monstroJogador, chance);
        } else {
            monstroInimigo.usarAtaqueEspecial(monstroInimigo, monstroJogador, chance);
        }
    }
}
