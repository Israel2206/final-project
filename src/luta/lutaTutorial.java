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
    public boolean vitoria;

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
                monstroJogador.setVida(monstroInimigo.getFullVida());
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
                paineis.pausa(400);
                System.out.println("----------------------------");
                System.out.println("Sua vez!");
                paineis.pausa(300);

                System.out.println("[ 1 ] Investida Rápida");
                paineis.pausa(200);
                System.out.println("[ 2 ] Golpe Feroz");
                paineis.pausa(200);
                System.out.println("[ 3 ] Usar Poção de HP (" + jogador.getPocaoHp() + ")");
                paineis.pausa(200);
                System.out.println("[ 4 ] Fugir");
                paineis.pausa(300);

                System.out.print("Escolha uma ação: ");

                escolha = sc.nextInt();
                sc.nextLine(); // limpa buffer

                // esse if só funciona aqui!!!!!
                if (escolha == 3){
                    paineis.pausa(400);
                    usarPocao(jogador, monstroJogador);
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
            case 1 -> ataqueBasico("Investida Rápida", 1.0);
            case 2 -> ataqueBasico("Golpe Feroz", 1.2);
            case 4 -> fugir();
        }
    }

    private void turnoInimigo() {
        paineis.pausa(600);
        System.out.println("\nO " + monstroInimigo.getNome() + " ataca!");
        paineis.pausa(700);

        if (random.nextInt(100) < 75) {
            int dano = monstroInimigo.getDano();
            aplicarDano(monstroJogador, dano);
            paineis.pausa(400);
            System.out.println("Ele acertou e causou " + dano + " de dano!");
        } else {
            paineis.pausa(400);
            System.out.println("O ataque do inimigo errou!");
        }

        paineis.pausa(600);
        mostrarVida();
    }

    // ================= AÇÕES =================

    private void ataqueBasico(String nomeAtaque, double multiplicador) {
        System.out.println("\n" + monstroJogador.getNome() + " usou " + nomeAtaque + "!");

        if (random.nextInt(100) < 75) {
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


    public void usarPocao(Jogador jogador, Monstro monstro){
        if (jogador.getPocaoHp() < 1){
            System.out.println("Poções Indisponiveis!");
        } else {
            if (monstroJogador.getVida() >= monstroJogador.getFullVida()){ //não ultrapassar a vida
                monstroJogador.setVida(monstroJogador.getFullVida());
                System.out.println("Impossível utilizar poção! HP do monstro cheio");
            }

            else if (monstroJogador.getVida() >= monstroJogador.getFullVida()-15){ //ele cura +15, mas n ultrapassa
                int cura = monstroJogador.getFullVida() - monstroJogador.getVida(); //pega o valor exato da cura pra n ultrapassar!
                jogador.setPocaoHp(jogador.getPocaoHp()-1);
                monstroJogador.setVida(monstroJogador.getVida()+cura);
                System.out.println("Poção usada com sucesso!\n+"+cura+" de Cura!");
            }

            else {
                monstroJogador.setVida(monstroJogador.getVida()+15);
                System.out.println("Poção usada com sucesso!\n+15 de Cura!");
                jogador.setPocaoHp(jogador.getPocaoHp()-1);
            }
        }
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
