package luta;

import jogador.Jogador;
import monstros.Monstro;
import paineis.Paineis;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class lutaTutorial {

    private Jogador jogador;
    private Monstro monstroJogador;
    private Monstro monstroInimigo;
    private Paineis paineis = new Paineis();
    public boolean vitoria = true;

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
        paineis.pausa(700);
        System.out.println("\nUMA BATALHA COMEÇOU!");
        paineis.pausa(600);
        System.out.println(monstroInimigo.getNome() + " apareceu!");
        System.out.println();
        paineis.pausa(800);

        while (monstroJogador.getVida() > 0 && monstroInimigo.getVida() > 0) {

            turnoJogador();
            paineis.pausa(500);

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
            paineis.pausa(500);

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
        }
    }

    // ================= TURNOS =================

    private void turnoJogador() {
        int escolha = -1;

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
            case 1 -> ataqueBasico(monstroJogador.getAtaqueBase(), monstroJogador.getMultiplicadorBase());
            case 2 -> ataqueBasico(monstroJogador.getAtaqueEspecial(), monstroJogador.getMultiplicadorEspecial());
            case 4 -> fugir();
        }
    }

    private void turnoInimigo() {
        paineis.pausa(600);
        System.out.println("\nO " + monstroInimigo.getNome() + " ataca!");
        paineis.pausa(700);

        if (random.nextInt(100) < 75) {
            int dano = monstroInimigo.getDano();
            monstroInimigo.aplicarDano(monstroJogador, dano);
            paineis.pausa(400);
            System.out.println("Ele acertou e causou " + dano + " de dano!");
        } else {
            paineis.pausa(400);
            System.out.println("O ataque do inimigo errou!");
        }

        paineis.pausa(600);
        //Não importa se aqui for o monstro jogador ou o monstro inimigo, isso é apenas para mostrar a vida dos monstros
        monstroJogador.mostrarVida(monstroJogador, monstroInimigo);

    }

    // ================= AÇÕES =================

    private void ataqueBasico(String nomeAtaque, double multiplicador) {
        System.out.println("\n" + monstroJogador.getNome() + " usou " + nomeAtaque + "!");

        if (random.nextInt(100) < 75) {
            int dano = (int) (monstroJogador.getDano() * multiplicador);
            monstroJogador.aplicarDano(monstroInimigo, dano);
            System.out.println("Ataque acertou! Dano causado: " + dano);
        } else {
            System.out.println("Mas o ataque errou!");
        }

        //Não importa se aqui for o monstro jogador ou o monstro inimigo, isso é apenas para mostrar a vida dos monstros
        monstroJogador.mostrarVida(monstroJogador, monstroInimigo);
    }

    private void fugir() {
        System.out.println("Você tentou fugir... mas o destino não permite.");
    }

}
