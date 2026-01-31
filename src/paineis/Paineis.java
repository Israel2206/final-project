package paineis;

import jogador.Jogador;
import monstros.Monstro;

public class Paineis {

    public void painelTorneio(){
        System.out.println("========================================");
        System.out.println("      🏆 TORNEIO DE CAMPEÕES 🏆");
        System.out.println("========================================");
        pausa(900);
        System.out.println("Um mundo dominado por monstros...");
        pausa(700);
        System.out.println("Apenas os mais fortes chegam ao final.");
        System.out.println();
        pausa(1200);
        System.out.println("Prepare-se para enfrentar 10 chefes");
        pausa(700);
        System.out.println("E provar que você é o verdadeiro campeão.");
        System.out.println();
        pausa(1300);
        System.out.println(">>> Aperte ENTER para começar <<<");
    }

    public void painelDeEscolherMonstro(){
        System.out.println("========================================");
        System.out.println("     ESCOLHA O SEU TIPO DE MONSTRO");
        System.out.println("========================================\n");
        pausa(800);
        System.out.println("        [ 1 ] Água        [ 2 ] Fogo\n");
        pausa(500);
        System.out.println("        [ 3 ] Terra       [ 4 ] Ar\n");
        pausa(500);
        System.out.println("             [ 5 ] Aleatório\n");
        pausa(700);
        System.out.println("========================================");
    }


    public void menuPainel(Jogador jogador, Monstro m) {
        pausa(500);
        System.out.println("==============================");
        System.out.println("        STATUS DO JOGADOR");
        System.out.println("==============================");
        pausa(700);
        System.out.println("Jogador : " + jogador.getNome());
        pausa(300);
        System.out.println("Monstro : " + m.getNome() + " (" + m.getTipo().toUpperCase() + ")");
        pausa(300);
        System.out.println("Vida    : " + m.getVida());
        System.out.println();
        pausa(300);
        System.out.println("Poções HP : " + jogador.getPocaoHp());
        System.out.println("==============================");
        pausa(600);
    }


    public void painelDoTutorial(){
        pausa(900);
        System.out.println("======================================");
        System.out.println();
        System.out.println("Você segue pelo caminho que leva ao torneio...");
        pausa(1200);
        System.out.println("O som distante da multidão vai ficando mais fraco.");
        System.out.println();
        pausa(1600);
        System.out.println("De repente, o ambiente fica silencioso.");
        pausa(1000);
        System.out.println("Um barulho ecoa no ar.");
        System.out.println();
        pausa(1700);
        System.out.println("Um monstro surge em sua frente.");
        pausa(900);
        System.out.println("Ele bloqueia o caminho e observa cada movimento seu.");
        System.out.println();
        pausa(1200);
    }

    //Adicionando os métodos de dar uma pausa aqui, pois não tem um lugar melhor
    public void pausa(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            /** Isso daqui serve para caso o código quebre,
             * ele restaura o estado de interrupção da thread.*/
        }
    }

    public void painelLutaUm(String nomeInimigo, String nomeMonstroInimigo) {
        pausa(800);
        System.out.println("\n======================================");
        System.out.println("        MENSAGEM DA ARENA");
        System.out.println("======================================");
        System.out.println();
        pausa(900);

        System.out.println("Após superar os desafios do caminho,");
        pausa(600);
        System.out.println("você finalmente chega à arena do torneio.");
        System.out.println();
        pausa(1000);

        System.out.println("O portão se fecha atrás de você.");
        pausa(600);
        System.out.println("A multidão reage com expectativa.");
        System.out.println();
        pausa(900);

        System.out.println("======================================");
    }

}