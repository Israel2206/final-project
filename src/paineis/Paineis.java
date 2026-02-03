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
        System.out.println("Prepare-se para enfrentar os melhores!");
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
        //millis = 0; //isso é caso formos testar o código
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            /** Isso daqui serve para caso o código quebre,
             * ele restaura o estado de interrupção da thread.*/
        }
    }
    public void painelHistoriaInicial() {
        pausa(1000);
        System.out.println("======================================");
        System.out.println("             MEMÓRIAS");
        System.out.println("======================================");
        System.out.println();
        pausa(1200);

        System.out.println("Ao entrar na arena você relembra do porque está aqui");
        System.out.println("Você era pequeno quando entrou naquela arena.");
        pausa(1000);
        System.out.println("Não como lutador.");
        pausa(700);
        System.out.println("Mas como espectador da luta final.");
        System.out.println();
        pausa(1200);

        System.out.println("As arquibancadas estavam cheias.");
        pausa(900);
        System.out.println("O público gritava.");
        pausa(700);
        System.out.println("Bandeiras tremulavam.");
        System.out.println();
        pausa(1200);

        System.out.println("Era a luta pelo título.");
        pausa(900);
        System.out.println("Seu pai contra o próprio irmão.");
        System.out.println();
        pausa(1200);

        System.out.println("No começo, tudo parecia justo.");
        pausa(900);
        System.out.println("Golpes limpos.");
        pausa(700);
        System.out.println("Regras sendo seguidas.");
        System.out.println();
        pausa(1200);

        System.out.println("Até que você percebeu.");
        pausa(900);
        System.out.println("Movimentos estranhos.");
        pausa(700);
        System.out.println("Golpes que não deveriam ser possíveis.");
        System.out.println();
        pausa(1300);

        System.out.println("Seu pai caiu uma vez.");
        pausa(900);
        System.out.println("Levantou.");
        pausa(700);
        System.out.println("Caiu de novo.");
        System.out.println();
        pausa(1200);

        System.out.println("O público aplaudia o espetáculo.");
        pausa(900);
        System.out.println("Mas você via o que ninguém queria ver.");
        System.out.println();
        pausa(1200);

        System.out.println("Quando a luta terminou, seu tio foi declarado vencedor.");
        pausa(1100);
        System.out.println("O título foi erguido.");
        pausa(700);
        System.out.println("A arena explodiu em aplausos.");
        System.out.println();
        pausa(1400);

        System.out.println("Seu pai permaneceu no chão.");
        pausa(900);
        System.out.println("Derrotado.");
        pausa(700);
        System.out.println("Humilhado.");
        System.out.println();
        pausa(1300);

        System.out.println("Seu tio se aproximou.");
        pausa(900);
        System.out.println("Não para ajudar.");
        pausa(700);
        System.out.println("Mas para falar.");
        System.out.println();
        pausa(1200);

        System.out.println("\"Esse é o nível que você alcançou.\"");
        pausa(900);
        System.out.println("\"E esse é o limite do seu sangue.\"");
        System.out.println();
        pausa(1400);

        System.out.println("Ele olhou para você.");
        pausa(900);
        System.out.println("Ainda criança.");
        pausa(700);
        System.out.println("Assistindo tudo da primeira fileira.");
        System.out.println();
        pausa(1300);

        System.out.println("Seu pai nunca voltou a lutar depois daquela noite.");
        pausa(1000);
        System.out.println("E nunca voltou a ser o mesmo.");
        System.out.println();
        pausa(1200);

        System.out.println("Anos se passaram.");
        pausa(900);
        System.out.println("Seu pai morreu.");
        pausa(900);
        System.out.println("E o nome do seu tio virou lenda. O dono do torneio desde então");
        System.out.println();
        System.out.println("E o do seu pai foi esquecido.");
        pausa(1400);

        System.out.println("Agora você está aqui.");
        pausa(900);
        System.out.println("Na mesma arena.");
        pausa(800);
        System.out.println("Diante do mesmo torneio.");
        System.out.println();
        pausa(1200);

        System.out.println("Não para provar algo.");
        pausa(800);
        System.out.println("Mas para encerrar o que começou naquela noite.");
        System.out.println();
        pausa(1400);

        System.out.println("======================================");
        pausa(1000);
        System.out.println(">>> Aperte ENTER para seguir seu caminho <<<");
    }

    public void painelLutaUm() {
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

        System.out.println("Você se sente mais preparado do que nunca.");
        System.out.println("Que comece o seu primeiro desafio!\n");
        pausa(1000);
        System.out.println("======================================");
    }

    public void painelStatusBatalha(Jogador jogador, Monstro monstroInimigo, Jogador nomeInimigo) {
        pausa(500);
        System.out.println("\n======================================");
        System.out.println("          STATUS DA BATALHA");
        System.out.println("======================================");
        System.out.println();
        pausa(600);

        System.out.println(">>> JOGADOR");
        pausa(300);
        System.out.println("Nome    : " + jogador.getNome());
        pausa(200);
        System.out.println("Monstro : " + jogador.getMonstro().getNome()
                + " (" + jogador.getMonstro().getTipo().toUpperCase() + ")");
        pausa(200);
        System.out.println("Vida    : " + jogador.getMonstro().getVida());
        System.out.println("Nível   : "+jogador.getMonstro().getNivel());
        pausa(200);
        System.out.println();
        pausa(500);

        System.out.println("--------------------------------------");
        System.out.println();
        pausa(500);

        System.out.println(">>> INIMIGO");
        pausa(300);
        System.out.println("Nome    : " + nomeInimigo.getNome());
        pausa(200);
        System.out.println("Monstro : " + monstroInimigo.getNome()
                + " (" + monstroInimigo.getTipo().toUpperCase() + ")");
        pausa(200);
        System.out.println("Vida    : " + (int) monstroInimigo.getVida());
        System.out.println("Nível   : "+monstroInimigo.getNivel());
        System.out.println();
        pausa(600);

        System.out.println("======================================");
    }


    public void painelDaLuta(Jogador jogador, Monstro monstroJogador) {
        pausa(400);
        System.out.println("----------------------------");
        System.out.println("Sua vez!");
        pausa(300);

        System.out.println("[ 1 ] "+monstroJogador.getAtaqueBase());
        pausa(200);
        System.out.println("[ 2 ] "+monstroJogador.getAtaqueEspecial()+" "+monstroJogador.getLimiteDeAtaqueEspecial()+"/5");
        pausa(200);
        System.out.println("[ 3 ] Usar Poção de HP (" + jogador.getPocaoHp() + ")");
        pausa(200);
        System.out.println("[ 4 ] Mostrar Status");
        pausa(300);
    }

    public void painelPosLutaQuatro(Jogador jogador, Monstro monstroJogador){
        pausa(400);
        System.out.println("----------------------------");
        System.out.println("Sua vez!");
        pausa(300);

        System.out.println("[ 1 ] "+monstroJogador.getAtaqueBase());
        pausa(200);
        System.out.println("[ 2 ] "+monstroJogador.getAtaqueEspecial()+" "+monstroJogador.getLimiteDeAtaqueEspecial()+"/"+monstroJogador.getATAQUE_ESPECIAL());
        pausa(200);
        System.out.println("[ 3 ] "+monstroJogador.getAtaqueDesbloqueado()+" "+monstroJogador.getLimiteDeAtaqueDesbloqueado()+"/"+monstroJogador.getATAQUE_DESBLOQUEADO());
        pausa(200);
        System.out.println("[ 4 ] Usar Poção de HP (" + jogador.getPocaoHp() + ")");
        pausa(200);
        System.out.println("[ 5 ] Mostrar Status");
        pausa(300);
    }

    public void painelDerrota(Monstro monstro) {
        pausa(900);
        System.out.println("\n======================================");
        System.out.println("              DERROTA");
        System.out.println("======================================\n");
        pausa(1000);

        System.out.println(monstro.getNome() + " caiu em batalha.");
        pausa(700);
        System.out.println("Ele tentou resistir até o fim.");
        System.out.println();
        pausa(1200);

        System.out.println("Você foi derrotado.");
        pausa(900);
        System.out.println("A arena permanece em silêncio.");
        System.out.println();
        pausa(1300);
        System.out.println("======================================");
    }



    public void painelLutaDois() {
        pausa(800);
        System.out.println("\n======================================");
        System.out.println("        MENSAGEM DA ARENA");
        System.out.println("======================================");
        System.out.println();
        pausa(900);

        System.out.println("Parabéns por sua primeira vitória!");
        System.out.println("Você avança para a próxima área da arena.");
        pausa(700);
        System.out.println("O chão começa a esquentar sob seus pés.");
        System.out.println();
        pausa(1000);

        System.out.println("Chamas surgem ao redor do campo de batalha.");
        pausa(700);
        System.out.println("O ar fica pesado e difícil de respirar.");
        System.out.println();
        pausa(1000);

        System.out.println("Do meio do fogo, um novo oponente aparece.");
        pausa(700);
        System.out.println("Um monstro envolto em chamas encara você sem medo.");
        System.out.println();
        pausa(1000);

        System.out.println("======================================");
    }
    public void painelLutaTres() {
        pausa(800);
        System.out.println("\n======================================");
        System.out.println("        MENSAGEM DA ARENA");
        System.out.println("======================================");
        System.out.println();
        pausa(900);

        System.out.println("Parabéns por sua por sua segunda Vitoria!");
        System.out.println("Você avança para a próxima área da arena.");
        pausa(700);
        System.out.println("O chão começa a tremer");
        System.out.println();
        pausa(1000);

        System.out.println("O publico começa a clamar por seu adversário.");
        pausa(700);
        System.out.println("Você começa a sentir o clima mudar na arena");
        System.out.println();
        pausa(1000);

        System.out.println("Um novo oponente aparece!");
        pausa(700);
        System.out.println("Se prepare para a proxima luta!");
        System.out.println();
        pausa(1000);

        System.out.println("======================================");
    }
    public void painelLutaQuatro() {
        pausa(800);
        System.out.println("\n======================================");
        System.out.println("        MENSAGEM DA ARENA");
        System.out.println("======================================");
        System.out.println();
        pausa(900);

        System.out.println("Três vitórias seguidas.");
        pausa(700);
        System.out.println("A arena começa a reconhecer seu nome.");
        System.out.println();
        pausa(1000);

        System.out.println("Você avança para uma nova área.");
        pausa(700);
        System.out.println("Não há placas, nem avisos.");
        System.out.println();
        pausa(900);

        System.out.println("O público murmura, confuso.");
        pausa(700);
        System.out.println("Ninguém sabe quem será o próximo adversário.");
        System.out.println();
        pausa(1000);

        System.out.println("As luzes da arena piscam.");
        pausa(700);
        System.out.println("O portão se abre lentamente.");
        System.out.println();
        pausa(1000);

        System.out.println("Um oponente surge.");
        pausa(700);
        System.out.println("Você percebe que desta vez não houve escolha.");
        System.out.println();
        pausa(900);

        System.out.println("A luta começa agora.");
        System.out.println();
        pausa(1000);

        System.out.println("======================================");
    }
    public void painelLutaCinco() {
        pausa(800);
        System.out.println("\n======================================");
        System.out.println("        MENSAGEM DA ARENA");
        System.out.println("======================================");
        System.out.println();
        pausa(900);

        System.out.println("O público se levanta após sua vitória.");
        pausa(700);
        System.out.println("Seu nome começa a ecoar pela arena.");
        pausa(900);
        System.out.println();

        System.out.println("De repente, o vento muda.");
        pausa(800);
        System.out.println("Rajadas fortes atravessam a arena, levantando poeira e bandeiras.");
        pausa(1000);
        System.out.println();

        System.out.println("O chão permanece firme...");
        pausa(700);
        System.out.println("Mas o ar ao redor parece instável.");
        pausa(900);
        System.out.println();

        System.out.println("O público silencia por alguns segundos.");
        pausa(800);
        System.out.println("Então, gritos começam a surgir de todos os lados.");
        pausa(900);
        System.out.println();

        System.out.println("Uma figura desce lentamente do alto da arena.");
        pausa(800);
        System.out.println("O vento gira ao seu redor como se obedecesse suas ordens.");
        pausa(1000);
        System.out.println();

        System.out.println("Um Monstro do tipo AR entra em campo.");
        pausa(700);
        System.out.println("Rápido. Imprevisível. Letal.");
        pausa(900);
        System.out.println();

        System.out.println("Prepare-se.");
        System.out.println("A quinta luta está prestes a começar.");
        pausa(1200);
    }
    public void painelLutaSeis() {
        pausa(800);
        System.out.println("\n======================================");
        System.out.println("        MENSAGEM DA ARENA");
        System.out.println("======================================");
        System.out.println();
        pausa(900);

        System.out.println("A arena já não vibra como antes.");
        pausa(800);
        System.out.println("Agora… ela observa.");
        pausa(900);
        System.out.println();

        System.out.println("Você sente o peso de cada luta em seu corpo.");
        pausa(800);
        System.out.println("Cada vitória cobrou um preço.");
        pausa(900);
        System.out.println();

        System.out.println("O público entende.");
        pausa(700);
        System.out.println("A partir daqui, só monstros de verdade permanecem.");
        pausa(1000);
        System.out.println();

        System.out.println("Os portões da arena se abrem lentamente.");
        pausa(800);
        System.out.println("Não há anúncio.");
        pausa(700);
        System.out.println("Não há aviso.");
        pausa(900);
        System.out.println();

        System.out.println("Apenas um inimigo surge.");
        pausa(800);
        System.out.println("E ele não veio testar você.");
        pausa(900);
        System.out.println();

        System.out.println("Ele veio te impedir de chegar ao final.");
        pausa(1200);
        System.out.println();

        System.out.println("Prepare-se.");
        System.out.println("A sexta luta começa agora.");
        pausa(1200);
    }
    public void painelLutaSete() {
        pausa(800);
        System.out.println("\n======================================");
        System.out.println("        MENSAGEM DA ARENA");
        System.out.println("======================================");
        System.out.println();
        pausa(900);

        System.out.println("A arena está cheia.");
        pausa(800);
        System.out.println("Mas ninguém comemora.");
        pausa(900);
        System.out.println();

        System.out.println("Você sente os olhares sobre você.");
        pausa(800);
        System.out.println("Alguns torcem.");
        pausa(600);
        System.out.println("Outros esperam sua queda.");
        pausa(900);
        System.out.println();

        System.out.println("Todos sabem.");
        pausa(800);
        System.out.println("Depois dessa luta… não haverá retorno.");
        pausa(1000);
        System.out.println();

        System.out.println("O portão se abre.");
        pausa(800);
        System.out.println("Seu próximo adversário já venceu muitos aqui.");
        pausa(900);
        System.out.println();

        System.out.println("Ele para diante de você.");
        pausa(800);
        System.out.println("E não diz uma palavra.");
        pausa(900);
        System.out.println();

        System.out.println("A luta que decide quem merece enfrentar o campeão começa agora.");
        pausa(1200);
    }
    public void painelLutaFinalAntes() {
        pausa(1000);
        System.out.println("\n======================================");
        System.out.println("        A GRANDE FINAL");
        System.out.println("======================================");
        System.out.println();
        pausa(1200);

        System.out.println("A arena está completamente lotada.");
        pausa(900);
        System.out.println("O público grita o nome do campeão.");
        pausa(900);
        System.out.println("O mesmo homem que você viu destruir seu pai.");
        System.out.println();
        pausa(1400);

        System.out.println("As lembranças voltam com força.");
        pausa(800);
        System.out.println("Você era apenas uma criança.");
        pausa(700);
        System.out.println("Viu seu pai cair, humilhado, diante de todos.");
        System.out.println();
        pausa(1500);

        System.out.println("O campeão ergue os braços.");
        pausa(700);
        System.out.println("O mesmo sorriso frio.");
        pausa(700);
        System.out.println("A mesma trapaça que ninguém teve coragem de denunciar.");
        System.out.println();
        pausa(1500);

        System.out.println("Ele olha para você.");
        pausa(800);
        System.out.println("Reconhece seu rosto.");
        pausa(800);
        System.out.println("E pela primeira vez, perde o sorriso.");
        System.out.println();
        pausa(1500);

        System.out.println("Não há como fugir.");
        pausa(700);
        System.out.println("Não há mais caminho de volta.");
        pausa(700);
        System.out.println("Essa luta decide tudo.");
        System.out.println();
        pausa(1200);

        System.out.println("======================================");
    }
    public void painelLutaFinalDepois() {
        pausa(1200);
        System.out.println("\n======================================");
        System.out.println("        O FIM DO TORNEIO");
        System.out.println("======================================");
        System.out.println();
        pausa(1400);

        System.out.println("O silêncio toma conta da arena.");
        pausa(900);
        System.out.println("O campeão está no chão.");
        pausa(900);
        System.out.println("Derrotado diante de todos.");
        System.out.println();
        pausa(1500);

        System.out.println("O público demora a reagir.");
        pausa(800);
        System.out.println("Até que alguém começa a aplaudir.");
        pausa(800);
        System.out.println("E então todos acompanham.");
        System.out.println();
        pausa(1500);

        System.out.println("Você não sente alegria.");
        pausa(700);
        System.out.println("Nem ódio.");
        pausa(700);
        System.out.println("Apenas alívio.");
        System.out.println();
        pausa(1400);

        System.out.println("Você colocou um ponto final na jornada maligna do seu tio.");
        pausa(800);
        System.out.println("Seu pai não está ali para ver.");
        pausa(800);
        System.out.println("Mas pela primeira vez, seu nome é limpo.");
        System.out.println();
        pausa(1400);

        System.out.println("O torneio chega ao fim.");
        pausa(700);
        System.out.println("E sua jornada também.");
        System.out.println();
        pausa(1200);
        System.out.println("Parabéns!! Você é o novo campeão do grande torneio!!");
        System.out.println();
        pausa(1200);

        System.out.println("======================================");
        System.out.println("               CRÉDITOS");
        System.out.println("======================================\n");
        System.out.println("Design de níveis: Breno Israel e Igor Franco");
        System.out.println("Métodos Específicos: Breno Israel");
        System.out.println("Roteiro: Igor Franco");
        System.out.println("Programação: Breno Israel e Igor Franco");
        System.out.println("Projeto final desenvolvido para o curso de JAVA");
        System.out.println("Docente Responsável: Neidson Sampaio");
        System.out.println("Apoio: Kid Bengala, João do pão, BBB26, PT");
    }

    public void mostrarAtualizacao(Monstro monstro){
        System.out.println("HP atualizado: "+monstro.getFullVida());
        System.out.println("Dano Atualizado: "+monstro.getDano());
        System.out.println("Nível: "+monstro.getNivel());
    }

    public void painelNovoAtaque(Monstro monstro) {
        pausa(800);
        System.out.println("\n======================================");
        System.out.println();
        pausa(700);

        System.out.println("Algo diferente acontece...");
        pausa(900);
        System.out.println("Uma energia estranha começa a surgir.");
        System.out.println();
        pausa(1100);

        System.out.println("Seu monstro reage.");
        pausa(700);
        System.out.println("Ele fecha os olhos por um instante.");
        System.out.println();
        pausa(1000);

        System.out.println("Uma nova força desperta!");
        System.out.println();
        pausa(1200);

        System.out.println(">>> " + monstro.getNome().toUpperCase() + " APRENDEU UM NOVO ATAQUE! <<<");
        System.out.println();
        pausa(1300);

        System.out.println("Novo ataque desbloqueado:");
        pausa(600);
        System.out.println("» " + monstro.getAtaqueDesbloqueado());
        System.out.println();
        pausa(1000);

        System.out.println("O poder do seu monstro aumentou.");
        System.out.println();
        pausa(900);
        System.out.println("======================================");
    }

    public void painelLutaRolaBosta() {
        pausa(700);
        System.out.println("\n======================================");
        System.out.println("      DESAFIO COMPLETAMENTE DESNECESSÁRIO");
        System.out.println("======================================");
        System.out.println();
        pausa(900);

        System.out.println("A arena fica em silêncio...");
        pausa(700);
        System.out.println("O público não entende o que está acontecendo.");
        pausa(700);
        System.out.println();

        System.out.println("Um juiz se aproxima e cochicha:");
        pausa(900);
        System.out.println("\"Isso não faz parte do torneio.\"");
        pausa(900);
        System.out.println("\"Você pode ir embora agora.\"");
        pausa(1000);
        System.out.println();

        System.out.println("Mas você decidiu continuar.");
        pausa(700);
        System.out.println("Provavelmente por orgulho.");
        pausa(700);
        System.out.println("Ou falta do que fazer.");
        pausa(900);
        System.out.println();

        System.out.println("O chão começa a feder.");
        pausa(700);
        System.out.println("Algo pesado rola lentamente pela arena...");
        pausa(900);
        System.out.println();

        System.out.println("O público começa a rir.");
        pausa(700);
        System.out.println("Depois para.");
        pausa(700);
        System.out.println();

        System.out.println("Surge o inimigo mais humilhante já visto:");
        pausa(900);
        System.out.println(">>> ROLA-BOSTA ANCESTRAL <<<");
        pausa(900);
        System.out.println();

        System.out.println("Ele não parece rápido.");
        pausa(600);
        System.out.println("Não parece inteligente.");
        pausa(600);
        System.out.println("Mas definitivamente parece perigoso.");
        pausa(900);
        System.out.println();

        System.out.println("Boa sorte.");
        pausa(700);
        System.out.println("Você vai precisar.");
        pausa(1000);
    }

}