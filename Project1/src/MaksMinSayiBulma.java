import java.util.Scanner;

public class MaksMinSayiBulma {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Kaç tane sayı gireceksiniz: ");
        int n = scanner.nextInt();


        int enBuyuk = Integer.MIN_VALUE;
        int enKucuk = Integer.MAX_VALUE;


        for (int i = 1; i <= n; i++) {
            System.out.print(i + ". Sayıyı giriniz: ");
            int sayi = scanner.nextInt();


            if (sayi > enBuyuk) {
                enBuyuk = sayi;
            }

            if (sayi < enKucuk) {
                enKucuk = sayi;
            }
        }


        System.out.println("En büyük sayı: " + enBuyuk);
        System.out.println("En küçük sayı: " + enKucuk);


        scanner.close();
    }
}
