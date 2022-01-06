package P01MarketProjesi;

import java.util.*;

public class marketrunner {
   static Scanner scan=new Scanner(System.in);
    static String devam="";

    static int toplamFiyat=0;

    static List<String> urunler = new ArrayList<>(Arrays.asList("Domates", "Patates", "Biber",
            "Sogan", "Havuç", "Elma", "Muz", "Çilek", "Kavun", "Üzüm", "Limon"));
    static List<Double> fiyatlar = new ArrayList<>(Arrays.asList(2.10, 3.20, 1.50, 2.30,
            3.10, 1.20, 1.90, 6.10, 4.30, 2.70, 0.50));
    static Map<Integer,String> sepetUrunlerin = new HashMap<>();
    static int odendi=0;
    public static void main(String[] args) {
        System.out.println("***HOSGELDINIZ***");
    do{    System.out.println("urun listesi asagidaki gibidir");
        for (int i=0;i<urunler.size();i++) {
            System.out.println(i+"\t"+urunler.get(i));
        }
        System.out.print(" lutfen almak istediginiz urun numarasini giriniz:");

        int urunNo=scan.nextInt();

        System.out.print(urunler.get(urunNo)+" sepete kac kilo eklensin?");
        int kilo=scan.nextInt();
        sepetUrunlerin.put(kilo,urunler.get(urunNo));
        toplamFiyat+=kilo*fiyatlar.get(urunNo);
        System.out.print("urun eklendi. devam etmek icin \"E\", kasaya gecmek icin \"H\" yaziniz");
        devam=scan.next();

    }while(devam.equalsIgnoreCase("E"));
        System.out.print("Merhaba, sepetinizdekiler: \n ");
        for (int e:sepetUrunlerin.keySet()) {
            System.out.print(e+" kilo "+sepetUrunlerin.get(e)+"\n");
        }
        System.out.println("odenecek tutar : " + toplamFiyat + " tl \n odeme yapacaginiz tutari giriniz:");
        odendi = scan.nextInt();
        toplamFiyat-=odendi;

    while(toplamFiyat>0) {

        System.out.print("ODEME ALINDI \t eksik kalan tutar: "+toplamFiyat+
                "\n yeniden odeme yapilacak tutari giriniz:");
        odendi = scan.nextInt();
        toplamFiyat-=odendi;
    }
    if(toplamFiyat<0){
        System.out.println("Odeme tamamlandi :) para ustunuz : "+ (-toplamFiyat));
    }
    }

    public static class Main {

        public static void main(String[] args) {
        // write your code here
        }
    }
}
