package usuario;

import monstros.Monstro;

public class Jogador {
    private String nome;
    private int pocaoHp;
    private int pocaoIm;
    private Monstro monstro;

    public Jogador(String nome, Monstro monstro) {
        this.nome = nome;
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

    public int getPocaoIm() {
        return pocaoIm;
    }

    public void setPocaoIm(int pocaoIm) {
        this.pocaoIm = pocaoIm;
    }
}
