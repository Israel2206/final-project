package monstros;

import jogador.Jogador;

import java.util.Random;

public class Monstro {
    //Nomes(str):
    protected String nome;
    protected String tipo;
    protected String ataqueBase;
    protected String ataqueEspecial;
    protected String ataqueDesbloqueado;

    //Multiplicadores de Dano(double)
    protected double multiplicadorBase;
    protected double multiplicadorEspecial;
    protected double multiplicadorDesbloqueado;

    //O máximo, não se pode alterar-lós, por conta do 'final'.
    protected final int ATAQUE_ESPECIAL = 5;
    protected final int ATAQUE_DESBLOQUEADO = 6;

    //limitadores
    protected int limiteDeAtaqueEspecial = 5;
    protected int limiteDeAtaqueDesbloqueado = 6;

    //Os valores ints
    protected int dano;
    protected int vida;
    protected int fullVida;
    protected int nivel;
    protected int vidaBase = 35;
    protected int danoBase = 9;

    private Random random = new Random();

    //Construtor
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

        atualizarStatus(nivel);
    }

    //Getters e Setters

    public int getATAQUE_ESPECIAL() {
        return ATAQUE_ESPECIAL;
    }

    public int getATAQUE_DESBLOQUEADO() {
        return ATAQUE_DESBLOQUEADO;
    }

    public int getLimiteDeAtaqueEspecial() {
        return limiteDeAtaqueEspecial;
    }

    public void setLimiteDeAtaqueEspecial(int limiteDeAtaqueEspecial) {
        this.limiteDeAtaqueEspecial = limiteDeAtaqueEspecial;
    }

    public int getLimiteDeAtaqueDesbloqueado() {
        return limiteDeAtaqueDesbloqueado;
    }

    public void setLimiteDeAtaqueDesbloqueado(int limiteDeAtaqueDesbloqueado) {
        this.limiteDeAtaqueDesbloqueado = limiteDeAtaqueDesbloqueado;
    }

    public double getMultiplicadorDesbloqueado() {
        return multiplicadorDesbloqueado;
    }

    public void setMultiplicadorEspecial(double multiplicadorEspecial) {
        this.multiplicadorEspecial = multiplicadorEspecial;
    }

    public String getAtaqueDesbloqueado() {
        return ataqueDesbloqueado;
    }

    public void setAtaqueEspecial(String ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
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

    //Métodos

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
            monstroUm.setLimiteDeAtaqueEspecial(monstroUm.getLimiteDeAtaqueEspecial()-1);
        } else {
            if (monstroUm.limiteDeAtaqueEspecial <= 0){
                System.out.println(monstroUm.getNome()+" tenta usar "+monstroUm.getAtaqueDesbloqueado()+" porém o limite foi atingido!");
            } else {
                double multiplicador = receberDanoEspecial(monstroDois);
                int dano = (int) (monstroUm.getDano() * multiplicador);
                aplicarDano(monstroDois, dano);
                System.out.println("Ataque acertou! Dano causado: " + dano);
                monstroUm.setLimiteDeAtaqueEspecial(monstroUm.getLimiteDeAtaqueEspecial()-1);
            }
        }

        monstroUm.mostrarVida(monstroUm,monstroDois);
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

    public double receberDanoEspecial(Monstro inimigo){
        return 1.15;
    }

    public double receberDanoDesbloqueado(Monstro inimigo){
        return 1.05;
    }

    //nome auto explicativo!!!!
    public void atualizarStatus(int nivel){
        this.fullVida = vidaBase + (int) (vidaBase * 0.1 * nivel);
        this.vida = this.fullVida;

        this.dano = danoBase + (int) (danoBase * 0.1 * nivel);
    }

    //Desbloqueia esse Ataque na luta 5
    public void usarAtaqueConquistado(Monstro monstroUm, Monstro monstroDois, int chance){
        System.out.println("\nO "+monstroUm.getNome()+" tentou usar "+monstroUm.getAtaqueDesbloqueado()+"!");

        if(!acertarAtaque(chance)){
            System.out.println("Mas o ataque errou!");
            monstroUm.setLimiteDeAtaqueDesbloqueado(monstroUm.getLimiteDeAtaqueDesbloqueado()-1);
        } else {
            if (monstroUm.limiteDeAtaqueDesbloqueado <= 0){
                System.out.println(monstroUm.getNome()+" tenta usar "+monstroUm.getAtaqueDesbloqueado()+" porém o limite foi atingido!");
            }else {
                double multiplicador = receberDanoDesbloqueado(monstroDois);
                int dano = (int) (monstroUm.getDano() * multiplicador);
                aplicarDano(monstroDois, dano);
                System.out.println("Ataque acertou! Dano causado: " + dano);
                monstroUm.setLimiteDeAtaqueDesbloqueado(monstroUm.getLimiteDeAtaqueDesbloqueado()-1);
            }
        }

        monstroUm.mostrarVida(monstroUm,monstroDois);
    }


}
