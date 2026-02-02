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
    private int chance = 75;

    public LutaQuatro(Jogador jogador) {
        this.jogador = jogador;
        this.monstroJogador = jogador.getMonstro();

        int sorteio = random.nextInt(4) + 1;

        if (sorteio == 1) {
            monstroInimigo = new MonstroDeFogo("Blazer", 6);
            jogadorInimigo = new Jogador("Ignis", monstroInimigo);
        } else if (sorteio == 2) {
            monstroInimigo = new MonstroDeAgua("Hydron", 6);
            jogadorInimigo = new Jogador("Aqua", monstroInimigo);
        } else if (sorteio == 3) {
            monstroInimigo = new MonstroDeTerra("Terrak", 6);
            jogadorInimigo = new Jogador("Gron", monstroInimigo);
        } else {
            monstroInimigo = new MonstroDeAr("Zeph", 6);
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
            paineis.pausa(400);
            turnoDoJogador();
            paineis.pausa(500);

            if (monstroInimigo.getVida() <= 0) {
                paineis.pausa(600);
                System.out.println("\nVocê venceu a batalha!");
                paineis.pausa(900);

                System.out.println("Você recebeu +1 poção de HP!");
                paineis.pausa(700);
                jogador.setPocaoHp(jogador.getPocaoHp() + 1);

                System.out.println("A Vida do seu " + monstroJogador.getNome() + " está cheia novamente!");
                monstroJogador.setNivel(monstroJogador.getNivel()+1);
                monstroJogador.atualizarStatus(monstroJogador.getNivel());
                monstroJogador.setVida(monstroJogador.getFullVida());
                paineis.pausa(1000);
                paineis.mostrarAtualizacao(monstroJogador);
                vitoria = true;
                break;
            }

            paineis.pausa(400);
            turnoInimigo();
            paineis.pausa(500);

            if (monstroJogador.getVida() <= 0) {
                paineis.pausa(700);
                System.out.println("\nSeu monstro foi derrotado...");
                paineis.pausa(1000);

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
