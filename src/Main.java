import luta.LutaUm;
import luta.lutaTutorial;
import monstros.*;
import jogador.Jogador;
import paineis.Paineis;


import java.util.InputMismatchException;
import java.util.Random;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        Paineis painel = new Paineis();

        painel.painelTorneio();

        sc.nextLine();
        System.out.println();

        System.out.println("Agora iremos criar seu personagem");
        painel.pausa(1000);
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        painel.pausa(500);

        Monstro monstroEscolhido = null;
        Jogador jogador = null;



        do {
            painel.painelDeEscolherMonstro();
            try {
                System.out.print("Digite o número do monstro que guiará o seu destino: ");
                int opcao = sc.nextInt();
                sc.nextLine(); // pegar espaço invisivel

                if (opcao == 1){
                    System.out.println("Você adquiriu um Monstro do tipo d'água!");
                    painel.pausa(800);
                    System.out.print("Dê um apelido para ele(a):");
                    String apelido = sc.nextLine();

                    monstroEscolhido = new MonstroDeAgua(apelido,0);

                    jogador = new Jogador(nome, monstroEscolhido);
                    painel.menuPainel(jogador, monstroEscolhido);
                    break;
                } else if (opcao == 2){
                    System.out.println("Você adquiriu um Monstro do tipo de Fogo!");
                    painel.pausa(800);
                    System.out.print("Dê um apelido para ele(a):");
                    String apelido = sc.nextLine();

                    monstroEscolhido = new MonstroDeFogo(apelido,0);

                    jogador = new Jogador(nome, monstroEscolhido);
                    painel.menuPainel(jogador, monstroEscolhido);
                    break;
                } else if (opcao == 3){
                    System.out.println("Você adquiriu um Monstro do tipo de Terra!");
                    painel.pausa(800);
                    System.out.print("Dê um apelido para ele(a):");
                    String apelido = sc.nextLine();

                    monstroEscolhido = new MonstroDeTerra(apelido,0);

                    jogador = new Jogador(nome, monstroEscolhido);
                    painel.menuPainel(jogador, monstroEscolhido);
                    break;
                }else if (opcao == 4){
                    System.out.println("Você adquiriu um Monstro do tipo de Ar!");
                    painel.pausa(800);
                    System.out.print("Dê um apelido para ele(a):");
                    String apelido = sc.nextLine();

                    monstroEscolhido = new MonstroDeAr(apelido,0);

                    jogador = new Jogador(nome, monstroEscolhido);
                    painel.menuPainel(jogador, monstroEscolhido);
                    break;
                }else if (opcao == 5) {
                    int numero = random.nextInt(5)+1; //ele gera de 1 a 5
                    if (numero == 1) {
                        System.out.println("Você adquiriu um Monstro do tipo d'água!");
                        painel.pausa(800);
                        System.out.print("Dê um apelido para ele(a):");
                        String apelido = sc.nextLine();

                        monstroEscolhido= new MonstroDeAgua(apelido,0);

                        jogador = new Jogador(nome, monstroEscolhido);
                        painel.menuPainel(jogador, monstroEscolhido);
                        break;
                    }else if (numero == 2){
                        System.out.println("Você adquiriu um Monstro do tipo de Fogo!");
                        painel.pausa(800);
                        System.out.print("Dê um apelido para ele(a):");
                        String apelido = sc.nextLine();

                        monstroEscolhido = new MonstroDeFogo(apelido,0);

                        jogador = new Jogador(nome, monstroEscolhido);
                        painel.menuPainel(jogador, monstroEscolhido);
                        break;
                    }else if (numero == 3){
                        System.out.println("Você adquiriu um Monstro do tipo de Terra!");
                        painel.pausa(800);
                        System.out.print("Dê um apelido para ele(a):");
                        String apelido = sc.nextLine();

                        monstroEscolhido = new MonstroDeTerra(apelido,0);

                        jogador = new Jogador(nome, monstroEscolhido);
                        painel.menuPainel(jogador, monstroEscolhido);
                        break;
                    } else if (numero == 4) {
                        System.out.println("Você adquiriu um Monstro do tipo de Ar!");
                        painel.pausa(800);
                        System.out.print("Dê um apelido para ele(a):");
                        String apelido = sc.nextLine();

                        monstroEscolhido = new MonstroDeAr(apelido,0);

                        jogador = new Jogador(nome, monstroEscolhido);
                        painel.menuPainel(jogador, monstroEscolhido);
                        break;
                    } else {
                        System.out.println("Parabéns você adquiriu um monstro raro! O poderoso Rola-Bosta!");
                        painel.pausa(1200);

                        monstroEscolhido = new RolaBosta("Rola Bosta",1);

                        jogador = new Jogador(nome, monstroEscolhido);
                        painel.menuPainel(jogador, monstroEscolhido);
                        break;
                    }
                } else {
                    System.out.println("Digite Apenas números de 1 a 5!");
                    painel.pausa(800);
                }
            } catch (InputMismatchException e) {
                sc.nextLine(); // Pegar o espaço invisivel
                System.out.println("Erro! Apenas números são aceitos!");
                painel.pausa(800);
            }

        }while (true);

        int opcaoTutorial = -1;

        painel.painelDoTutorial();

        while (true) { //Antes de começar a Batalha de "tutorial"
            try {
                System.out.println("Qual será sua decisão?");
                System.out.println();
                System.out.println("[ 1 ] Atacar     [ 2 ] Fugir");
                System.out.print("Escolha uma opção: ");

                opcaoTutorial = sc.nextInt();
                sc.nextLine();

                if (opcaoTutorial == 1 || opcaoTutorial == 2) {
                    break;
                } else {
                    System.out.println("Opção inválida! Digite apenas 1 ou 2.");
                }

            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Entrada inválida! Digite apenas números.");
            }
        }

        System.out.println("======================================");

        if (opcaoTutorial == 2) {
            System.out.println("Você tentou fugir... mas o destino não permite.");
            painel.pausa(1500);
        }

        lutaTutorial lutaTutorial = new lutaTutorial(jogador);
        lutaTutorial.iniciar();

        if (!lutaTutorial.vitoria){
            System.out.println("\n=== GAME OVER ===");
        } else {
            painel.painelLutaUm();

            LutaUm lutaUm = new LutaUm(jogador);

            lutaUm.iniciarLutaUm();



        }
    }
}