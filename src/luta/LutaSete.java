package luta;

import jogador.Jogador;
import monstros.Monstro;
import monstros.MonstroDeTerra;
import paineis.Paineis;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class LutaSete {

    private Jogador jogador;
    private Monstro monstroJogador;
    private Jogador jogadorInimigo;
    private Monstro monstroInimigo;
    private Paineis paineis = new Paineis();
    public boolean vitoria;

    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();
    private int chance = 75;


    public LutaSete(Jogador jogador) {
        this.jogador = jogador;
        this.monstroJogador = jogador.getMonstro();


        this.monstroInimigo = new MonstroDeTerra("Golém Colossal", 8);
        this.jogadorInimigo = new Jogador("Carrasco Gwyn", monstroInimigo);
    }


    public void iniciarLutaSete() {
        paineis.painelLutaSete();
        paineis.painelStatusBatalha(jogador, monstroInimigo, jogadorInimigo);

        System.out.println("\n======================");
        System.out.println("   BATALHA INICIADA!");
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
                monstroJogador.setNivel(monstroJogador.getNivel()+1);
                monstroJogador.atualizarStatus(monstroJogador.getNivel());
                monstroJogador.setVida(monstroJogador.getFullVida());
                paineis.pausa(1000);
                paineis.mostrarAtualizacao(monstroJogador);
                vitoria = true;
                break;
            }

            turnoInimigo();

            if (monstroJogador.getVida() <= 0) {
                paineis.pausa(800);
                System.out.println("\nVocê foi esmagado pela força da arena...");
                paineis.pausa(1000);

                System.out.println("Talvez você ainda não estivesse pronto.");
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

                if (escolha >= 1 && escolha <= 4) break;

                System.out.println("Opção inválida!");

            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Digite apenas números.");
            }
        }

        paineis.pausa(500);
        switch (escolha) {
            case 1 -> monstroJogador.usarAtaqueBasico(monstroJogador, monstroInimigo, chance);
            case 2 -> monstroJogador.usarAtaqueEspecial(monstroJogador, monstroInimigo, chance);
        }
    }

    private void turnoInimigo() {
        paineis.pausa(700);
        System.out.println("\nO " + monstroInimigo.getNome() + " golpeia o chão!");
        paineis.pausa(700);

        int sorte = random.nextInt(5) + 1;
        if (sorte <= 3) {
            monstroInimigo.usarAtaqueBasico(monstroInimigo, monstroJogador, chance);
        } else {
            monstroInimigo.usarAtaqueEspecial(monstroInimigo, monstroJogador, chance);
        }
    }
}
