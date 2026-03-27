import java.util.Random;
import java.util.Scanner;

public class XO_Game {
    static char[][] tabla;
    static int dim;
    static Random rand = new Random();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println();
        System.out.println("   X-O   ");
        System.out.print("Enter table dimension: ");
        dim = in.nextInt();

        tabla = new char[dim][dim];
        initTabla();

        boolean jocTerminat = false;
        char jucatorCurent = 'X';
        int mutari = 0;

        while (!jocTerminat && (mutari < (dim * dim))) {
            boolean plasat = false;

            while (!plasat) {
                int linie = rand.nextInt(dim);
                int coloana = rand.nextInt(dim);

                if (tabla[linie][coloana] == '*') {
                    tabla[linie][coloana] = jucatorCurent;
                    plasat = true;
                    mutari++;
                    System.out.println("--");
                    afisTabla();
                }
            }

            if (verCastig(jucatorCurent)) {
                System.out.println();
                System.out.println("Game Over! Winner: " + jucatorCurent);
                System.out.println("------");
                jocTerminat = true;
            }

            if (jucatorCurent == 'X') {
                jucatorCurent = '0';
            }
            else {
                jucatorCurent = 'X';
            }
        }

        if (!jocTerminat) {
            System.out.println();
            System.out.println("Game Over! Tie");
            System.out.println("------");
        }
    }

    public static void initTabla() {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                tabla[i][j] = '*';
            }
        }
    }

    public static void afisTabla() {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.print(tabla[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean verCastig(char jucator) {
        for (int i = 0; i < dim; i++) {
            boolean linieCastig = true;
            for (int j = 0; j < dim; j++) {
                if (tabla[i][j] != jucator) {
                    linieCastig = false;
                    break;
                }
            }
            if (linieCastig) {
                return true;
            }
        }

        for (int j = 0; j < dim; j++) {
            boolean coloanaCastig = true;
            for (int i = 0; i < dim; i++) {
                if (tabla[i][j] != jucator) {
                    coloanaCastig = false;
                    break;
                }
            }
            if (coloanaCastig) {
                return true;
            }
        }

        boolean diag1 = true;
        for (int i = 0; i < dim; i++) {
            if (tabla[i][i] != jucator) {
                diag1 = false;
                break;
            }
        }
        if (diag1) {
            return true;
        }

        boolean diag2 = true;
        for (int i = 0; i < dim; i++) {
            if (tabla[i][dim - i - 1] != jucator) {
                diag2 = false;
                break;
            }
        }
        return diag2;
    }
}
