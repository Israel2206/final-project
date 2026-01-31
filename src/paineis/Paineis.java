package paineis;

import jogador.Jogador;
import monstros.Monstro;

public class Paineis {

    public void painelTorneio(){
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
    }

    public void painelDeEscolherMonstro(){
        System.out.println("========================================");
        System.out.println("     ESCOLHA O SEU TIPO DE MONSTRO");
        System.out.println("========================================\n");

        System.out.println("        [ 1 ] Água        [ 2 ] Fogo\n");
        System.out.println("        [ 3 ] Terra       [ 4 ] Ar\n");
        System.out.println("             [ 5 ] Aleatório\n");

        System.out.println("========================================");
    }

    public void menuPainel(Jogador jogador, Monstro m) {
        System.out.println("==============================");
        System.out.println("        STATUS DO JOGADOR");
        System.out.println("==============================");
        System.out.println("Jogador : " + jogador.getNome());
        System.out.println("Monstro : " + m.getNome() + " (" + m.getTipo().toUpperCase() + ")");
        System.out.println("Vida    : " + m.getVida());
        System.out.println();
        System.out.println("Poções HP : " + jogador.getPocaoHp());
        System.out.println("==============================");
    }

    public void painelDoTutorial(){
        System.out.println("\n======================================");
        System.out.println();
        System.out.println("Você dá alguns passos à frente...");
        System.out.println("Um rosnado ecoa no silêncio.");
        System.out.println();
        System.out.println("Um monstro aparece diante de você.");
        System.out.println("Ele não parece disposto a recuar.");
        System.out.println();
        System.out.println("Seu coração acelera.");
        System.out.println();
        System.out.println("Qual será sua decisão?");
        System.out.println();
        System.out.println("[ 1 ] Atacar     [ 2 ] Fugir");
    }
}