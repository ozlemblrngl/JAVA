import java.util.Scanner;

public class KdvHesaplama {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Lütfen para değerini giriniz: ");
        double paraDegeri = scanner.nextDouble();

        double kdvOrani = (paraDegeri <= 1000) ? 0.20 : 0.08;


        double kdvliFiyat = paraDegeri * (1 + kdvOrani);
        double kdvTutari = paraDegeri * kdvOrani;

        System.out.println("KDV'siz Fiyat: " + paraDegeri);
        System.out.println("KDV'li Fiyat: " + kdvliFiyat);
        System.out.println("KDV Tutarı: " + kdvTutari);

        scanner.close();
    }
}