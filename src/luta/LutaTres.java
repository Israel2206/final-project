package luta;

import jogador.Jogador;
import monstros.Monstro;
import monstros.MonstroDeTerra;
import paineis.Paineis;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class LutaTres {

    private Jogador jogador;
    private Monstro monstroJogador;
    private Jogador jogadorInimigo;
    private Monstro monstroInimigo;
    private Paineis paineis = new Paineis();
    public boolean vitoria;

    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();
    private int chance = 60; // mais difícil que a luta dois

    // Construtor
    public LutaTres(Jogador jogador) {
        this.jogador = jogador;
        this.monstroJogador = jogador.getMonstro();

        this.monstroInimigo = new MonstroDeTerra("Terran", 6);
        this.jogadorInimigo = new Jogador("Gambit", monstroInimigo);
    }

    public void iniciarLutaTres() {

        paineis.pausa(800);
        System.out.println("\n======================================");
        System.out.println("Você conquista a sua segunda vitoria e segue em seu objetivo!");
        System.out.println("\nA arena muda.");
        paineis.pausa(700);
        System.out.println("O chão é pesado.\n");
        paineis.pausa(700);
        System.out.println("Cada passo exige esforço.");
        System.out.println("Um novo oponente aparece.\n");
        System.out.println("A multidão clama por seu adversário");
        System.out.println("Se prepare para a proxima luta!\n");
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
                System.out.println("\nVocê venceu a batalha!");
                paineis.pausa(800);

                System.out.println("Seu esforço começa a valer a pena.");
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
                System.out.println("\nSeu monstro foi derrotado...");
                paineis.pausa(900);

                System.out.println("Aqui, força bruta faz diferença.");
                paineis.pausa(900);
                System.out.println("Você ainda precisa evoluir.");
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
        System.out.println("\nO " + monstroInimigo.getNome() + " avança!");
        paineis.pausa(700);

        int sorte = random.nextInt(4) + 1;
        if (sorte <= 2) {
            monstroInimigo.usarAtaqueEspecial(monstroInimigo, monstroJogador);
        } else {
            monstroInimigo.usarAtaqueBasico(monstroInimigo, monstroJogador, chance);
        }
    }
}
