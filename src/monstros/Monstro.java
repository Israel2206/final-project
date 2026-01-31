package monstros;

public class Monstro {
    protected String nome;
    protected String tipo;
    protected int dano;
    protected int vida;
    protected int fullVida;

    public Monstro(String nome) {
        this.nome = nome;
        this.tipo = "comum";
        this.dano = 10;
        this.vida = 30;
        this.fullVida = 30;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
}
