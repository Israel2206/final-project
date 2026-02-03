package luta;

import jogador.Jogador;
import monstros.Monstro;
import monstros.MonstroDeFogo;
import paineis.Paineis;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class LutaFinal {

    private Jogador jogador;
    private Monstro monstroJogador;
    private Jogador jogadorInimigo;
    private Monstro monstroInimigo;
    private Paineis paineis = new Paineis();
    public boolean vitoria;

    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();


    private int chance = 85;


    public LutaFinal(Jogador jogador) {
        this.jogador = jogador;
        this.monstroJogador = jogador.getMonstro();

        // O TIO — CAMPEÃO
        this.monstroInimigo = new MonstroDeFogo("Seath, o Grande Dragão Descamado", 15);
        this.jogadorInimigo = new Jogador("Daemon, o Campeão", monstroInimigo);
    }


    public void iniciarLutaFinal() {

        paineis.painelLutaFinalAntes();
        paineis.painelStatusBatalha(jogador, monstroInimigo, jogadorInimigo);

        System.out.println("\n======================");
        System.out.println("      LUTA FINAL");
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
                monstroJogador.setNivel(monstroJogador.getNivel()+4);
                monstroJogador.atualizarStatus(monstroJogador.getNivel());
                monstroJogador.setVida(monstroJogador.getFullVida());
                paineis.pausa(1000);
                System.out.println("\nO campeão cai de joelhos.");
                paineis.pausa(1000);

                System.out.println("O silêncio domina a arena.");
                paineis.pausa(1000);

                System.out.println("A verdade finalmente venceu.");
                paineis.pausa(1200);

                paineis.mostrarAtualizacao(monstroJogador);
                vitoria = true;
                break;
            }
            chance = random.nextInt(100)+1;
            turnoInimigo();

            if (monstroJogador.getVida() <= 0) {
                paineis.pausa(1000);
                System.out.println("\nVocê caiu diante daquele que destruiu seu passado.");
                paineis.pausa(1200);

                System.out.println("A arena vibra, mas você não escuta mais nada.");
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
                    System.out.println("Opção inválida! Digite apenas 1, 2, 3, 4 ou 5.");
                }

            } catch (InputMismatchException e) {
                sc.nextLine();
                paineis.pausa(300);
                System.out.println("Entrada inválida! Digite apenas números.");
            }
        }

        paineis.pausa(500);
        switch (escolha) {
            case 1 -> monstroJogador.usarAtaqueBasico(monstroJogador, monstroInimigo, chance);
            case 2 -> monstroJogador.usarAtaqueEspecial(monstroJogador, monstroInimigo, chance);
            case 3 -> monstroJogador.usarAtaqueConquistado(monstroJogador, monstroInimigo, chance);
        }
    }

    private void turnoInimigo() {
        paineis.pausa(800);
        System.out.println("\nAldren sorri.");
        paineis.pausa(700);
        System.out.println("Ele ataca sem piedade.");
        paineis.pausa(800);

        int sorte = random.nextInt(4) + 1;

        // chefe apela mais
        if (sorte <= 2) {
            monstroInimigo.usarAtaqueEspecial(monstroInimigo, monstroJogador, chance);
        } else {
            monstroInimigo.usarAtaqueBasico(monstroInimigo, monstroJogador, chance);
            monstroInimigo.setLimiteDeAtaqueEspecial(monstroInimigo.getLimiteDeAtaqueEspecial()+1);
        }
    }
}
