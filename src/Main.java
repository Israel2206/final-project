import monstros.MonstroDeAgua;
import monstros.MonstroDeFogo;
import jogador.Jogador;
import java.util.Random;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("      🏆 TORNEIO DE CAMPEÕES 🏆");
        System.out.println("========================================");
        System.out.println("Um mundo dominado por monstros...");
        System.out.println("Apenas os mais fortes chegam ao final.");
        System.out.println();
        System.out.println("Prepare-se para enfrentar 10 chefes");
        System.out.println("E provar que você é o verdadeiro campeão.");
        System.out.println();
        System.out.println(">>> Aperte ENTER para começar <<<");
        sc.nextLine();
        System.out.println();

        System.out.println("Agora iremos criar seu personagem");
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.println("========================================");
        System.out.println("     ESCOLHA O SEU TIPO DE MONSTRO");
        System.out.println("========================================\n");

        System.out.println("        [ 1 ] Água        [ 2 ] Fogo\n");
        System.out.println("        [ 3 ] Terra       [ 4 ] Ar\n");
        System.out.println("             [ 5 ] Aleatório\n");

        System.out.println("========================================");
        System.out.print("Digite o número do monstro que guiara o seu destino: ");
        int opcao = sc.nextInt();

        if (opcao == 1){
            System.out.println("Você adquiriu um Monstro do tipo d'água!");
            System.out.print("Dê um apelido para ele(a):");
            String apelido = sc.nextLine();

            MonstroDeAgua monstroDeAgua = new MonstroDeAgua(apelido);

            Jogador jogador = new Jogador(nome, monstroDeAgua);
        }

        /**
         * ==============================
         *        PAINEL DE BATALHA
         * ==============================
         * Jogador: Igor
         * Monstro: Dragor (Fogo)
         * Vida: 85
         *
         * Inimigo: AquaLord
         * Vida: 60
         * ==============================
         * 1 - Atacar
         * 2 - Usar Poção
         * 3 - Fugir
         */
    }
}
