package luta;

import jogador.Jogador;
import monstros.Monstro;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class lutaTutorial {

    private Jogador jogador;
    private Monstro monstroJogador;
    private Monstro monstroInimigo;

    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();

    public lutaTutorial(Jogador jogador) {
        this.jogador = jogador;
        this.monstroJogador = jogador.getMonstro();

        // Monstro inimigo do tutorial (simples e fixo)
        this.monstroInimigo = new Monstro("Slime Selvagem");
        this.monstroInimigo.setVida(25);
        this.monstroInimigo.setDano(8);
    }

    public void iniciar() {
        System.out.println("\nUMA BATALHA COMEÇOU!");
        System.out.println(monstroInimigo.getNome() + " apareceu!");
        System.out.println();

        while (monstroJogador.getVida() > 0 && monstroInimigo.getVida() > 0) {

            turnoJogador();

            if (monstroInimigo.getVida() <= 0) {
                System.out.println("\nVocê venceu a batalha!");
                break;
            }

            turnoInimigo();

            if (monstroJogador.getVida() <= 0) {
                System.out.println("\nSeu monstro foi derrotado...");
                break;
            }
        }
    }

    // ================= TURNOS =================

    private void turnoJogador() {
        int escolha = -1;

        while (true) {
            try {
                System.out.println("\n----------------------------");
                System.out.println("Sua vez!");
                System.out.println("[ 1 ] Investida Rápida");
                System.out.println("[ 2 ] Golpe Feroz");
                System.out.println("[ 3 ] Fugir");
                System.out.print("Escolha uma ação: ");

                escolha = sc.nextInt();
                sc.nextLine(); // limpa buffer

                if (escolha >= 1 && escolha <= 3) {
                    break;
                } else {
                    System.out.println("Opção inválida! Digite apenas 1, 2 ou 3.");
                }

            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Entrada inválida! Digite apenas números.");
            }
        }

        switch (escolha) {
            case 1 -> ataqueBasico("Investida Rápida", 1.0);
            case 2 -> ataqueBasico("Golpe Feroz", 1.4);
            case 3 -> fugir();
        }
    }

    private void turnoInimigo() {
        System.out.println("\nO " + monstroInimigo.getNome() + " ataca!");

        if (random.nextInt(100) < 75) {
            int dano = monstroInimigo.getDano();
            aplicarDano(monstroJogador, dano);
            System.out.println("Ele acertou e causou " + dano + " de dano!");
        } else {
            System.out.println("O ataque do inimigo errou!");
        }

        mostrarVida();
    }

    // ================= AÇÕES =================

    private void ataqueBasico(String nomeAtaque, double multiplicador) {
        System.out.println("\n" + monstroJogador.getNome() + " usou " + nomeAtaque + "!");

        if (random.nextInt(100) < 70) {
            int dano = (int) (monstroJogador.getDano() * multiplicador);
            aplicarDano(monstroInimigo, dano);
            System.out.println("Ataque acertou! Dano causado: " + dano);
        } else {
            System.out.println("Mas o ataque errou!");
        }

        mostrarVida();
    }

    private void fugir() {
        System.out.println("Você tentou fugir... mas o destino não permite.");
    }

    // ================= CONTROLE DE VIDA =================

    private void aplicarDano(Monstro alvo, int dano) {
        int novaVida = alvo.getVida() - dano;

        if (novaVida < 0) {
            novaVida = 0;
        }

        alvo.setVida(novaVida);
    }

    private void mostrarVida() {
        System.out.println("\nVida do seu monstro: " + monstroJogador.getVida());
        System.out.println("Vida do inimigo: " + monstroInimigo.getVida());
    }
}
