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
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

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
                    System.out.print("Dê um apelido para ele(a):");
                    String apelido = sc.nextLine();

                    monstroEscolhido = new MonstroDeAgua(apelido);

                    jogador = new Jogador(nome, monstroEscolhido);
                    painel.menuPainel(jogador, monstroEscolhido);
                    break;
                } else if (opcao == 2){
                    System.out.println("Você adquiriu um Monstro do tipo de Fogo!");
                    System.out.print("Dê um apelido para ele(a):");
                    String apelido = sc.nextLine();

                    monstroEscolhido = new MonstroDeFogo(apelido);

                    jogador = new Jogador(nome, monstroEscolhido);
                    painel.menuPainel(jogador, monstroEscolhido);
                    break;
                } else if (opcao == 3){
                    System.out.println("Você adquiriu um Monstro do tipo de Terra!");
                    System.out.print("Dê um apelido para ele(a):");
                    String apelido = sc.nextLine();

                    monstroEscolhido = new MonstroDeTerra(apelido);

                    jogador = new Jogador(nome, monstroEscolhido);
                    painel.menuPainel(jogador, monstroEscolhido);
                    break;
                }else if (opcao == 4){
                    System.out.println("Você adquiriu um Monstro do tipo de Ar!");
                    System.out.print("Dê um apelido para ele(a):");
                    String apelido = sc.nextLine();

                    monstroEscolhido = new MonstroDeAr(apelido);

                    jogador = new Jogador(nome, monstroEscolhido);
                    painel.menuPainel(jogador, monstroEscolhido);
                    break;
                }else if (opcao == 5) {
                    int numero = random.nextInt(5)+1; //ele gera de 1 a 5
                    if (numero == 1) {
                        System.out.println("Você adquiriu um Monstro do tipo d'água!");
                        System.out.print("Dê um apelido para ele(a):");
                        String apelido = sc.nextLine();

                        monstroEscolhido= new MonstroDeAgua(apelido);

                        jogador = new Jogador(nome, monstroEscolhido);
                        painel.menuPainel(jogador, monstroEscolhido);
                        break;
                    }else if (numero == 2){
                        System.out.println("Você adquiriu um Monstro do tipo de Fogo!");
                        System.out.print("Dê um apelido para ele(a):");
                        String apelido = sc.nextLine();

                        monstroEscolhido = new MonstroDeFogo(apelido);

                        jogador = new Jogador(nome, monstroEscolhido);
                        painel.menuPainel(jogador, monstroEscolhido);
                        break;
                    }else if (numero == 3){
                        System.out.println("Você adquiriu um Monstro do tipo de Terra!");
                        System.out.print("Dê um apelido para ele(a):");
                        String apelido = sc.nextLine();

                        monstroEscolhido = new MonstroDeTerra(apelido);

                        jogador = new Jogador(nome, monstroEscolhido);
                        painel.menuPainel(jogador, monstroEscolhido);
                        break;
                    } else if (numero == 4) {
                        System.out.println("Você adquiriu um Monstro do tipo de Ar!");
                        System.out.print("Dê um apelido para ele(a):");
                        String apelido = sc.nextLine();

                        monstroEscolhido = new MonstroDeAr(apelido);

                        jogador = new Jogador(nome, monstroEscolhido);
                        painel.menuPainel(jogador, monstroEscolhido);
                        break;
                    } else {
                        System.out.println("Parabéns você adquiriu um monstro raro! O poderoso Rola-Bosta!");

                        monstroEscolhido = new RolaBosta("Rola Bosta");

                        jogador = new Jogador(nome, monstroEscolhido);
                        painel.menuPainel(jogador, monstroEscolhido);
                        break;
                    }
                } else {
                    System.out.println("Digite Apenas números de 1 a 5!");
                }
            } catch (InputMismatchException e) {
                sc.nextLine(); // Pegar o espaço invisivel
                System.out.println("Erro! Apenas números são aceitos!");
            }

        }while (true);

        painel.painelDoTutorial();
        int opcaoTutorial = sc.nextInt();
        sc.nextLine(); // pegar espaço vazio
        System.out.println("======================================");


    }
}