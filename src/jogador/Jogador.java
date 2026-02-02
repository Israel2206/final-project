package jogador;

import monstros.Monstro;

public class Jogador {
    private String nome;
    private int pocaoHp;
    private Monstro monstro;

    public Jogador(String nome, Monstro monstro) {
        this.nome = nome;
        this.monstro = monstro;
        this.pocaoHp = 1;
    }


    public Monstro getMonstro() {
        return monstro;
    }

    public void setMonstro(Monstro monstro) {
        this.monstro = monstro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPocaoHp() {
        return pocaoHp;
    }

    public void setPocaoHp(int pocaoHp) {
        this.pocaoHp = pocaoHp;
    }


    public void usarPocao(Jogador jogador, Monstro monstroJogador){
        if (jogador.getPocaoHp() < 1){
            System.out.println("Poções Indisponiveis!");
        } else {
            if (monstroJogador.getVida() >= monstroJogador.getFullVida()){ //não ultrapassar a vida
                monstroJogador.setVida(monstroJogador.getFullVida());
                System.out.println("Impossível utilizar poção! HP do monstro cheio");
            }

            else if (monstroJogador.getVida() >= monstroJogador.getFullVida()-15){ //ele cura +15, mas n ultrapassa
                int cura = monstroJogador.getFullVida() - monstroJogador.getVida(); //pega o valor exato da cura pra n ultrapassar!
                jogador.setPocaoHp(jogador.getPocaoHp()-1);
                monstroJogador.setVida(monstroJogador.getVida()+cura);
                System.out.println("Poção usada com sucesso!\n+"+cura+" de Cura!");
                System.out.println("Vida: "+monstroJogador.getVida());
            }

            else {
                monstroJogador.setVida(monstroJogador.getVida()+15);
                System.out.println("Poção usada com sucesso!\n+15 de Cura!");
                jogador.setPocaoHp(jogador.getPocaoHp()-1);
                System.out.println("Vida: "+monstroJogador.getVida());
            }
        }
    }
}
