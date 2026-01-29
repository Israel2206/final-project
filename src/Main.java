import monstros.MonstroComum;
import monstros.MonstroDeAgua;
import monstros.MonstroDeFogo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do monstro: ");
        String nome = sc.nextLine();

        MonstroDeFogo m = new MonstroDeFogo(nome);

        System.out.println(m.nome);
        System.out.println(m.tipo);
        System.out.println(m.dano);


    }
}
