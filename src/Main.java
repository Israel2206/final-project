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

                    MonstroDeAgua monstroDeAgua = new MonstroDeAgua(apelido);

                    Jogador jogador = new Jogador(nome, monstroDeAgua);
                    painel.menuPainel(jogador, monstroDeAgua);
                    break;
                } else if (opcao == 2){
                    System.out.println("Você adquiriu um Monstro do tipo de Fogo!");
                    System.out.print("Dê um apelido para ele(a):");
                    String apelido = sc.nextLine();

                    MonstroDeFogo monstroDeFogo = new MonstroDeFogo(apelido);

                    Jogador jogador = new Jogador(nome, monstroDeFogo);
                    painel.menuPainel(jogador, monstroDeFogo);
                    break;
                } else if (opcao == 3){
                    System.out.println("Você adquiriu um Monstro do tipo de Terra!");
                    System.out.print("Dê um apelido para ele(a):");
                    String apelido = sc.nextLine();

                    MonstroDeTerra monstroDeTerra = new MonstroDeTerra(apelido);

                    Jogador jogador = new Jogador(nome, monstroDeTerra);
                    painel.menuPainel(jogador, monstroDeTerra);
                    break;
                }else if (opcao == 4){
                    System.out.println("Você adquiriu um Monstro do tipo de Ar!");
                    System.out.print("Dê um apelido para ele(a):");
                    String apelido = sc.nextLine();

                    MonstroDeAr monstroDeAr = new MonstroDeAr(apelido);

                    Jogador jogador = new Jogador(nome, monstroDeAr);
                    painel.menuPainel(jogador, monstroDeAr);
                    break;
                }else if (opcao == 5) {
                    int numero = random.nextInt(5)+1; //ele gera de 1 a 5
                    if (numero == 1) {
                        System.out.println("Você adquiriu um Monstro do tipo d'água!");
                        System.out.print("Dê um apelido para ele(a):");
                        String apelido = sc.nextLine();

                        MonstroDeAgua monstroDeAgua = new MonstroDeAgua(apelido);

                        Jogador jogador = new Jogador(nome, monstroDeAgua);
                        painel.menuPainel(jogador, monstroDeAgua);
                        break;
                    }else if (numero == 2){
                        System.out.println("Você adquiriu um Monstro do tipo de Fogo!");
                        System.out.print("Dê um apelido para ele(a):");
                        String apelido = sc.nextLine();

                        MonstroDeFogo monstroDeFogo = new MonstroDeFogo(apelido);

                        Jogador jogador = new Jogador(nome, monstroDeFogo);
                        painel.menuPainel(jogador, monstroDeFogo);
                        break;
                    }else if (numero == 3){
                        System.out.println("Você adquiriu um Monstro do tipo de Terra!");
                        System.out.print("Dê um apelido para ele(a):");
                        String apelido = sc.nextLine();

                        MonstroDeTerra monstroDeTerra = new MonstroDeTerra(apelido);

                        Jogador jogador = new Jogador(nome, monstroDeTerra);
                        painel.menuPainel(jogador, monstroDeTerra);
                        break;
                    } else if (numero == 4) {
                        System.out.println("Você adquiriu um Monstro do tipo de Ar!");
                        System.out.print("Dê um apelido para ele(a):");
                        String apelido = sc.nextLine();

                        MonstroDeAr monstroDeAr = new MonstroDeAr(apelido);

                        Jogador jogador = new Jogador(nome, monstroDeAr);
                        painel.menuPainel(jogador, monstroDeAr);
                        break;
                    } else {
                        System.out.println("Parabéns você adquiriu um monstro raro! O poderoso Rola-Bosta!");

                        RolaBosta rolaBosta = new RolaBosta("Rola Bosta");

                        Jogador jogador = new Jogador(nome, rolaBosta);
                      painel.menuPainel(jogador, rolaBosta);
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


    }
}
