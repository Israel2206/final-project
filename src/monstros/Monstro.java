package monstros;

import jogador.Jogador;

import java.util.Random;

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
    protected int nivel;

    private Random random = new Random();

    public Monstro(String nome, int nivel) {
        this.nome = nome;
        this.nivel = nivel;
        this.tipo = "comum";
        this.dano = 10;
        this.vida = 30;
        this.fullVida = 30;
        this.ataqueBase = "Investida Rápida";
        this.multiplicadorBase = 1.0;
        this.ataqueEspecial = "Golpe Feroz";
        this.multiplicadorEspecial = 1.2;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
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


    public void aplicarDano(Monstro alvo, int dano){
        int novaVida = alvo.getVida() - dano;

        if (novaVida < 0) {
            novaVida = 0;
        }

        alvo.setVida(novaVida);
    }

    public void mostrarVida(Monstro monstroUm, Monstro monstroDois) {
        System.out.println("\nVida do "+monstroUm.getNome()+": " + monstroUm.getVida());
        System.out.println("Vida do "+monstroDois.getNome()+": " + monstroDois.getVida());
    }

    public boolean acertarAtaque(int chance){
        return random.nextInt(100) < chance;
    }

    public void usarAtaqueBasico(Monstro monstroUm, Monstro monstroDois, int chance){
        System.out.println("\nO "+monstroUm.getNome()+" usou "+monstroUm.getAtaqueBase()+"!");

        if (!acertarAtaque(chance)){
            System.out.println("Mas o ataque errou!");
        } else {
            double multiplicador = receberDano(monstroDois);
            int dano = (int) (monstroUm.getDano() * multiplicador);
            aplicarDano(monstroDois, dano);
            System.out.println("Ataque acertou! Dano causado: " + dano);
        }

        monstroUm.mostrarVida(monstroUm,monstroDois);
    }

    public void usarAtaqueEspecial(Monstro monstroUm, Monstro monstroDois, int chance){
        System.out.println("\nO "+monstroUm.getNome()+" usou "+monstroUm.getAtaqueEspecial()+"!");

        if (!acertarAtaque(chance)){
            System.out.println("Mas o ataque errou!");
        } else {
            double multiplicador = receberDano(monstroDois);
            int dano = (int) (monstroUm.getDano() * multiplicador);
            aplicarDano(monstroDois, dano);
            System.out.println("Ataque acertou! Dano causado: " + dano);
        }
    }

    public void mostrarStatus(Jogador jogador, Monstro monstro){
        System.out.println("=== Status ===");
        System.out.println("Jogador: "+jogador.getNome()+"\n");
        System.out.println("Monstro: "+monstro.nome);
        System.out.println("HP: "+monstro.getVida());
        System.out.println("Dano: "+monstro.getDano());
    }

    //Pega o aplicador de dano, podendo dar vantagem ou desvantagem
    public double receberDano(Monstro inimigo) {
        return 1.0;
    }

    public double receberDanoEspecial(Jogador jogador, Monstro monstro){
        return 1.15;
    }

    //nome auto explicativo!!!!
    public void atualizarStatus(int nivel){
        double porcentagem = nivel*0.1; // nivel = 1 vira 0.1

        int vida = (int) (getFullVida() * (1 + porcentagem));
        setFullVida(vida);

        int dano = (int) (getDano() * (1 + porcentagem));
        setDano(dano);
    }
}
