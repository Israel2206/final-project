package monstros;

import jogador.Jogador;

public class Monstro {
    protected String nome;
    protected String tipo;
    protected int dano;
    protected int vida;
    protected int fullVida;
    protected String ataqueBase;
    protected double multiplicadorBase;
    protected String ataqueEspecial;
    protected double multiplicadorEspecial;

    public Monstro(String nome) {
        this.nome = nome;
        this.tipo = "comum";
        this.dano = 10;
        this.vida = 30;
        this.fullVida = 30;
        this.ataqueBase = "Investida Rápida";
        this.multiplicadorBase = 1.0;
        this.ataqueEspecial = "Golpe Feroz";
        this.multiplicadorEspecial = 1.2;
    }


    public double getMultiplicadorBase() {
        return multiplicadorBase;
    }

    public double getMultiplicadorEspecial() {
        return multiplicadorEspecial;
    }

    public String getAtaqueBase() {
        return ataqueBase;
    }

    public String getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getFullVida() {
        return fullVida;
    }

    public void setFullVida(int fullVida) {
        this.fullVida = fullVida;
    }

    public void ataqueSimples(Monstro alvo, int dano){
        int novaVida = alvo.getVida() - dano;

        if (novaVida < 0) {
            novaVida = 0;
        }

        alvo.setVida(novaVida);
    }

    public void mostrarVida(Monstro monstroJogador, Monstro monstroInimigo) {
        System.out.println("\nVida do seu monstro: " + monstroJogador.getVida());
        System.out.println("Vida do inimigo: " + monstroInimigo.getVida());
    }




}
