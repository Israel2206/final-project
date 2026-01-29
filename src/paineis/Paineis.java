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
            System.out.println("Monstro : " + m.nome + " (" + m.tipo.toUpperCase() + ")");
            System.out.println("Vida    : " + (int)m.vida);
            System.out.println();
            System.out.println("Poções HP : " + jogador.getPocaoHp());
            System.out.println("Imunidade : " + jogador.getPocaoIm());
            System.out.println("==============================");
        }
    }



