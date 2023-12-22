import java.util.Scanner;

public class AsalSayiBulma {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Sayı Giriniz: ");
        int sayi = scanner.nextInt();


        if (isAsal(sayi)) {
            System.out.println(sayi + " sayısı ASALDIR !");
        } else {
            System.out.println(sayi + " sayısı ASAL değildir !");
        }


        scanner.close();
    }


    static boolean isAsal(int n, int i) {

        if (n <= 1) {
            return false;
        }

        if (i > Math.sqrt(n)) {
            return true;
        }

        if (n % i == 0) {
            return false;
        }

        return isAsal(n, i + 1);
    }


    static boolean isAsal(int n) {

        return isAsal(n, 2);
    }
}
