package GaleriOtomasyon;

import java.util.Scanner;

public class Main {
    static DenemeAracVeri calis = new DenemeAracVeri();
    public static void main(String[] args) {
        System.out.println("Toyota Galeriye Hosgeldiniz");
        galeriMenu();
    }
    public static void galeriMenu() {

        System.out.println("\t\t======== MENU ======= \n\t\t1==>Arac Listesi\n\t\t2==>Satin Alma\n\t\t3==>Cikis");
        Scanner scan = new Scanner(System.in);
        int tercih = scan.nextInt();

        switch (tercih){
            case 1:
                calis.aracListesi();
                galeriMenu();
            break;
            case 2:
              Islemler islemler = new Islemler();
              Islemler.odeme();
                galeriMenu();
                break;
            case 3:
                System.out.println("yine bekleriz...");
               System.exit(0);
                break;
            default :{
                System.out.println("Hatali Giris Yaptiniz");
                galeriMenu();
            }
        }



    }
}
