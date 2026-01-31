package monstros;

public class MonstroDeTerra  extends Monstro {

    public MonstroDeTerra(String nome) {
        super(nome);
        this.tipo = "terra";
        this.dano = 13;
        this.vida = 35;
        this.fullVida = 35;
        this.ataqueBase = "Fio-Terra";
        this.multiplicadorBase = 1.0;
        this.ataqueEspecial = "Pedra que esmagou obito";
        this.multiplicadorEspecial = 1.25;
    }
}
