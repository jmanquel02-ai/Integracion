import java.util.*;

public class Ruleta {
    static int[] nums = new int[100];
    static int[] montos = new int[100];
    static boolean[] aciertos = new boolean[100];
    static int n = 0;
    static int[] rojos = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
    static Random r = new Random();

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        Scanner in = new Scanner(System.in);
        int op = 0;
        while (op != 3) {
            System.out.println("\n1. Jugar\n2. Estadisticas\n3. Salir");
            System.out.print("Opcion: ");
            op = in.nextInt();
            if (op == 1) jugar(in);
            else if (op == 2) estadisticas();
            else if (op == 3) System.out.println("Fin");
            else System.out.println("Opcion invalida");
        }
    }

    static void jugar(Scanner in) {
        System.out.print("Tipo (R/N/P/I): ");
        char t = in.next().toUpperCase().charAt(0);
        System.out.print("Monto: ");
        int m = in.nextInt();
        int num = r.nextInt(37);
        boolean g = num != 0 && (
                (t == 'P' && num % 2 == 0) ||
                        (t == 'I' && num % 2 != 0) ||
                        (t == 'R' && esRojo(num)) ||
                        (t == 'N' && !esRojo(num))
        );
        nums[n] = num;
        montos[n] = m;
        aciertos[n] = g;
        n++;
        System.out.println("Salio: " + num);
        System.out.println(g ? "Ganaste" : "Perdiste");
    }

    static boolean esRojo(int x) {
        for (int i : rojos) if (i == x) return true;
        return false;
    }

    static void estadisticas() {
        int total = 0, ganadas = 0, balance = 0;
        for (int i = 0; i < n; i++) {
            total += montos[i];
            if (aciertos[i]) { ganadas++; balance += montos[i]; }
            else balance -= montos[i];
        }
        System.out.println("Rondas: " + n);
        System.out.println("Total apostado: " + total);
        System.out.println("Aciertos: " + ganadas);
        System.out.println("Balance: " + balance);
    }
}
