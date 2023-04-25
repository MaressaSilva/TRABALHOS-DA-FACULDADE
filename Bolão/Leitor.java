package Bolão;
import java.util.Scanner;

public class Leitor {
    private static Scanner scanner;
    public static String lerLinha(){
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static String lerPalavra(){
        scanner = new Scanner(System.in);
        return scanner.next();
    }
    public static Integer lerInteiro(){
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static Double lerDouble(){
        scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
    public static void fecharScanner(){
        scanner.close();
    }
}
