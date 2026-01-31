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

}
