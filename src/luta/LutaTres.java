package luta;

import jogador.Jogador;
import monstros.Monstro;
import monstros.MonstroDeAgua;
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
    private int chance;

    // Monstro de água fixo
    public LutaTres(Jogador jogador) {
        this.jogador = jogador;
        this.monstroJogador = jogador.getMonstro();

        this.monstroInimigo = new MonstroDeAgua("Aquaron", 4);
        this.jogadorInimigo = new Jogador("Marin", monstroInimigo);
    }

    public void iniciarLutaTres() {
        paineis.painelLutaTres();

        paineis.painelStatusBatalha(jogador, monstroInimigo, jogadorInimigo);

        System.out.println("\n======================");
        System.out.println("   Batalha Iniciada!");
        System.out.println("======================\n");

        do {
            chance = random.nextInt(100)+1;
            turnoDoJogador();

            if (monstroInimigo.getVida() <= 0) {
                paineis.pausa(600);
                System.out.println("\nVocê venceu a batalha!");
                paineis.pausa(900);

                System.out.println("Você recebeu +1 poção de HP!");
                paineis.pausa(700);
                jogador.setPocaoHp(jogador.getPocaoHp() + 2);

                System.out.println("A Vida do seu " + monstroJogador.getNome() + " está cheia novamente!");
                monstroJogador.setNivel(monstroJogador.getNivel()+1);
                monstroJogador.atualizarStatus(monstroJogador.getNivel());
                monstroJogador.setVida(monstroJogador.getFullVida());
                paineis.pausa(1000);

                //restaurando os especiais
                monstroJogador.setLimiteDeAtaqueEspecial(monstroJogador.getATAQUE_ESPECIAL());
                paineis.mostrarAtualizacao(monstroJogador);
                vitoria = true;
                break;
            }
            chance = random.nextInt(100)+1;
            turnoInimigo();

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

                if (escolha >= 1 && escolha <= 2) {
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

        if (random.nextInt(100) < 70) {
            monstroInimigo.usarAtaqueBasico(monstroInimigo, monstroJogador, chance);
        } else {
            monstroInimigo.usarAtaqueEspecial(monstroInimigo, monstroJogador, chance);
            monstroInimigo.setLimiteDeAtaqueEspecial(monstroInimigo.getATAQUE_DESBLOQUEADO());
        }
    }
}
