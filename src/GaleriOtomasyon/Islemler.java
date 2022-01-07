package GaleriOtomasyon;


import java.util.*;

public class Islemler {

static DenemeAracVeri arac = new DenemeAracVeri();
 public static void odeme() {
 System.out.println("Galerideki Mevcut Araclarimiz");
 arac.aracListesi();
  Scanner scan = new Scanner(System.in);

  int secim;

  System.out.println("Galerideki Mevcut Araclarimiz");
  System.out.println("Secmek istediginiz Arac Noyu Giriniz");
  secim = scan.nextInt();
  while (!arac.aracMap.containsKey(secim)) {
   secim = scan.nextInt();
   System.out.println("agam sectigin arac bizde yok 10-13 arasi gir");
  }
  System.out.println("sectigin arac : " + arac.araclar(secim));
  Integer borc = Integer.valueOf(arac.araclar(secim).get("Fiyat"));
  System.out.println("odemeniz gereken tutar: "+ arac.araclar(secim).get("Fiyat")+"\n"+
          "lutfen odeyeceginiz tutari giriniz:");

int odenen;
  do {odenen=scan.nextInt();
   borc-=odenen;
   if(borc>0){
    System.out.println("agam yeterli degil eksik kalan : "+ borc);
   }else if(borc<0){
    System.out.println("para ustunuz:" + -1*borc +" tl");
   break;
   }else{break;
   }
  } while (true);

  System.out.println("odemeniz alindi :)");
 }
}
 /* do{
   System.out.println("Secmek istediginiz Arac Noyu(10,11,12,13,14) Giriniz");
   secim = scan.nextInt();
  System.out.println("agam sectigin arac bizde yok 10-13 arasi gir");
  }while (!arac.aracMap.containsKey(secim));


        System.out.println("sectigin arac : " + arac.araclar(secim));
   */
  /*
   System.out.println("Galerideki Mevcut Araclarimiz");
  arac.aracListesi();
  Scanner scan = new Scanner(System.in);
  do {
   System.out.println("Secmek istediginiz Arac Noyu Giriniz");
   secim = scan.nextInt();
   arac.araclar(secim);

  } while (secim!=10&&secim!=11&&secim!=12&&secim!=13&&secim!=14);
   */