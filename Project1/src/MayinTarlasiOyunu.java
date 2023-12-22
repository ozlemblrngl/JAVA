import java.util.Random;
import java.util.Scanner;

public class MayinTarlasiOyunu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Mayın Tarlası Oyuna Hoşgeldiniz!");

        System.out.print("Satır sayısını giriniz: ");
        int satir = scanner.nextInt();

        System.out.print("Sütun sayısını giriniz: ");
        int sutun = scanner.nextInt();

        char[][] mayinTarlasi = new char[satir][sutun];
        boolean[][] mayinKonumlari = new boolean[satir][sutun];

        mayinlariYerlestir(mayinKonumlari);
        oyunuBaslat(mayinTarlasi);

        oyunuDegerlendir(scanner, mayinTarlasi, mayinKonumlari);

        scanner.close();
    }

    static void mayinlariYerlestir(boolean[][] mayinKonumlari) {
        Random random = new Random();

        int mayinSayisi = mayinKonumlari.length * mayinKonumlari[0].length / 4;

        for (int i = 0; i < mayinSayisi; i++) {
            int randomSatir = random.nextInt(mayinKonumlari.length);
            int randomSutun = random.nextInt(mayinKonumlari[0].length);


            while (mayinKonumlari[randomSatir][randomSutun]) {
                randomSatir = random.nextInt(mayinKonumlari.length);
                randomSutun = random.nextInt(mayinKonumlari[0].length);
            }

            mayinKonumlari[randomSatir][randomSutun] = true;
        }
    }

    static void oyunuBaslat(char[][] mayinTarlasi) {
        for (int i = 0; i < mayinTarlasi.length; i++) {
            for (int j = 0; j < mayinTarlasi[0].length; j++) {
                mayinTarlasi[i][j] = '-';
            }
        }
        oyunTahtasiniGoster(mayinTarlasi);
    }

    static void oyunTahtasiniGoster(char[][] mayinTarlasi) {
        for (int i = 0; i < mayinTarlasi.length; i++) {
            for (int j = 0; j < mayinTarlasi[0].length; j++) {
                System.out.print(mayinTarlasi[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void oyunuDegerlendir(Scanner scanner, char[][] mayinTarlasi, boolean[][] mayinKonumlari) {
        while (true) {
            System.out.print("Satır Giriniz: ");
            int satir = scanner.nextInt();

            System.out.print("Sütun Giriniz: ");
            int sutun = scanner.nextInt();

            if (satir < 0 || satir >= mayinTarlasi.length || sutun < 0 || sutun >= mayinTarlasi[0].length) {
                System.out.println("Geçersiz koordinat! Tekrar deneyin.");
                continue;
            }

            if (mayinKonumlari[satir][sutun]) {
                oyunuKaybet(mayinKonumlari);
                break;
            } else {
                int mayinSayisi = komsuDakiMayinSayisi(mayinKonumlari, satir, sutun);
                mayinTarlasi[satir][sutun] = (char) (mayinSayisi + '0');
                oyunTahtasiniGoster(mayinTarlasi);

                if (oyunuKazandiMi(mayinTarlasi, mayinKonumlari)) {
                    oyunuKazan();
                    break;
                }
            }
        }
    }

    static int komsuDakiMayinSayisi(boolean[][] mayinKonumlari, int satir, int sutun) {
        int mayinSayisi = 0;

        for (int i = satir - 1; i <= satir + 1; i++) {
            for (int j = sutun - 1; j <= sutun + 1; j++) {
                if (i >= 0 && i < mayinKonumlari.length && j >= 0 && j < mayinKonumlari[0].length && mayinKonumlari[i][j]) {
                    mayinSayisi++;
                }
            }
        }

        return mayinSayisi;
    }

    static boolean oyunuKazandiMi(char[][] mayinTarlasi, boolean[][] mayinKonumlari) {
        for (int i = 0; i < mayinTarlasi.length; i++) {
            for (int j = 0; j < mayinTarlasi[0].length; j++) {
                if (mayinTarlasi[i][j] == '-' && !mayinKonumlari[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void oyunuKazan() {
        System.out.println("Oyunu Kazandınız!");
    }

    static void oyunuKaybet(boolean[][] mayinKonumlari) {
        System.out.println("Game Over!!");

        for (int i = 0; i < mayinKonumlari.length; i++) {
            for (int j = 0; j < mayinKonumlari[0].length; j++) {
                if (mayinKonumlari[i][j]) {
                    System.out.print("* ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}
