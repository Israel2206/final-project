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
                System.out.println("[ 3 ] Usar Poção de HP (" + jogador.getPocaoHp()+")");
                System.out.println("[ 4 ] Fugir");
                System.out.print("Escolha uma ação: ");

                escolha = sc.nextInt();
                sc.nextLine(); // limpa buffer

                //esse if só funciona aqui!!!!!
                if (escolha == 3){
                    usarPocao(jogador, monstroJogador);
                    continue;
                }

                if (escolha >= 1 && escolha <= 4) {
                    break;
                } else {
                    System.out.println("Opção inválida! Digite apenas 1, 2, 3 ou 4.");
                }

            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Entrada inválida! Digite apenas números.");
            }
        }


        switch (escolha) {
            case 1 -> ataqueBasico("Investida Rápida", 1.0);
            case 2 -> ataqueBasico("Golpe Feroz", 1.2);
            case 4 -> fugir();
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
            if (monstroJogador.getVida() >= monstroJogador.getFullVida()){
                monstroJogador.setVida(monstroJogador.getFullVida());
                System.out.println("Impossível utilizar poção! HP do monstro cheio");
            }

            else if (monstroJogador.getVida() < monstroJogador.getFullVida()-15){ //ele cura +15, mas n ultrapassa
                jogador.setPocaoHp(jogador.getPocaoHp()-1);
                monstroJogador.setVida(monstroJogador.getVida()+15);
                System.out.println("Poção usada com sucesso!\n+15 de Cura!");
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
