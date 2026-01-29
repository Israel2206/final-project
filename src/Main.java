import monstros.MonstroComum;
import monstros.MonstroDeAgua;
import monstros.MonstroDeFogo;
import usuario.Jogador;

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
        System.out.printf("");




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

        System.out.println("Digite o nome do monstro: ");
        String nome = sc.nextLine();

        MonstroDeFogo m = new MonstroDeFogo(nome);

        System.out.println(m.nome);
        System.out.println(m.tipo);
        System.out.println(m.dano);

        System.out.println("========");

        Jogador j = new Jogador("Breno", m);

        System.out.println(j.getNome());
        System.out.println(m.nome);
        System.out.println(j.getPocaoHp());
        System.out.println(j.getPocaoIm());


    }
}
