package ogrPractice.ajanda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Etkinlik {

	String etkinlikAdi;
	String etkinlikTarihi;
	double etkinlikSaati;
	String etkinlikKimIle;
	String etkinlikNotu;

	static List<Etkinlik> etkinlikListesi = new ArrayList<>();

	public Etkinlik() {

	}

	public Etkinlik(String etkAdi, String etkTarihi, double etkSaati, String etkKimIle, String etkNotu) {
		super();
		this.etkinlikAdi = etkAdi;
		this.etkinlikTarihi = etkTarihi;
		this.etkinlikSaati = etkSaati;
		this.etkinlikKimIle = etkKimIle;
		this.etkinlikNotu = etkNotu;
	}

	public void etkinlikMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println(
				  "╔════════════════════════════╗\r\n"
			    + "║  ETKİNLİK(RANDEVU) MENUSU  ║\r\n"
				+ "╠════════════════════════════╣\r\n"
			    + "║ 1- Etkinlik Ekle           ║\r\n"
				+ "║ 2- Etkinlik Sil            ║\r\n"
			    + "║ 3- Etkinlik Düzenle        ║\r\n"
				+ "║ 4- Etkinlik Durumu         ║\r\n"
			    + "║ 5- Çıkış (Ana Menüye Dön)  ║\r\n"
				+ "╚════════════════════════════╝\r\n"
			    + "Lütfen yapmak istenilen işlem numarasını giriniz");

		int secim = scan.nextInt();

		switch (secim) {
		case 1:
			etkinlikEkle();
			break;

		case 2:
			etkinlikSil();
			break;

		case 3:

			etkinlikDuzenlemeMenu();

			break;

		case 4:
			
			for (int i = 0; i < etkinlikListesi.size(); i++) {

				System.out.println((i + 1) + ". " + etkinlikListesi.get(i).toString());
			}
			etkinlikMenu();

			break;

		case 5:
			Ajanda.ajandaMenu();
			break;

		default:
			break;
		}

		scan.close();
	}

	private void etkinlikEkle() {

		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < Data.etkinlikler.size(); i++) {
			System.out.println((i + 1) + "- " + Data.etkinlikler.get(i));
		}
		System.out.println("Lütfen bir etkinlik seçiniz");
		int secim = scan.nextInt();
		
		if (secim==7) {
			System.out.println("yeni etkinlik Adı giriniz");
			Data.etkinlikler.set(secim-1, scan.nextLine());
			Data.etkinlikler.set(secim-1, scan.nextLine());
		}
		
		etkinlikAdi = Data.etkinlikler.get(secim - 1);
		
		System.out.println("Lütfen etkinlik tarihini giriniz [gg/aa/yyyy]");
		etkinlikTarihi = scan.next();

		System.out.println("Lütfen etkinlik saatini giriniz [ss.dd]");
		etkinlikSaati = scan.nextDouble();

		System.out.println("Lütfen etkinlik Kim ile olduğunu giriniz");
		etkinlikKimIle = scan.nextLine();
		etkinlikKimIle = scan.nextLine();

		System.out.println("Lütfen varsa etkinlik notunu giriniz.");
		etkinlikNotu = scan.nextLine();

		Etkinlik etkinlikobj = new Etkinlik(etkinlikAdi, etkinlikTarihi, etkinlikSaati, etkinlikKimIle, etkinlikNotu);
		
		etkinlikListesi.add(etkinlikobj);
		
		System.out.println(new String(new char[70]).replace("\0", "\r\n"));
		
		System.out.println("************** ETKINLIKLERE BASARI ILE EKLENMISTIR **************");
	
		for (int i = 0; i < etkinlikListesi.size(); i++) {

			System.out.println((i + 1) + ". " + etkinlikListesi.get(i).toString());
		}
		
		etkinlikMenu();

		scan.close();
	}

	private void etkinlikSil() {
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < etkinlikListesi.size(); i++) {

			System.out.println((i + 1) + ". " + etkinlikListesi.get(i).toString());
		}

		System.out.println("Silmek istediğiniz etkinligin nosunu giriniz ");
		int secim = scan.nextInt();

		if (secim > etkinlikListesi.size() || secim <= 0) {
			System.out.println("Lütfen Listeden birini seçin");
			etkinlikSil();
		} else {
			System.out.println(etkinlikListesi.remove(secim - 1).toString() + "\n" + "Basari ile silinmistir.");
			System.out.println(new String(new char[70]).replace("\0", "\r\n"));	//Ekranı temizleme
			etkinlikMenu();
		}

	}

	public void etkinlikDuzenlemeMenu() {

		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < etkinlikListesi.size(); i++) {

			System.out.println((i + 1) + ". " + etkinlikListesi.get(i).toString());
		}

		System.out.println("Lutfen duzenlemek istediginiz etkinligin nosunu giriniz \nÇıkış için Sıfır (0) basınız");

		int secim1 = scan.nextInt();

		if (secim1 == 0) {
			etkinlikMenu();
		}

		if (secim1 > etkinlikListesi.size() || secim1 < 0) {
			System.out.println("Lütfen Listeden birini seçin");
			etkinlikDuzenlemeMenu();
		}

		System.out.println(""
				+ "╔════════════════════════════╗\r\n" 
				+ "║ ETKINLIK DUZENLEME MENUSU  ║\r\n"
				+ "╠════════════════════════════╣\r\n" 
				+ "║ 1- Etkinlik Adi            ║\r\n"
				+ "║ 2- Etkinlik Tarihi         ║\r\n" 
				+ "║ 3- Etkinlik Saati          ║\r\n"
				+ "║ 4- Etkinligin Kim ile      ║\r\n" 
				+ "║ 5- Aciklama Notu           ║\r\n"
				+ "║ 6- Etkinlik Menusune Git   ║\r\n" 
				+ "╚════════════════════════════╝\r\n"
				+ "Lutfen yapmak istenilen islem numarasini giriniz");

		int secim = scan.nextInt();

		switch (secim) {
		case 1:
			System.out.println("Yeni etkinliğin adını girin");
			etkinlikListesi.get(secim1 - 1).etkinlikAdi = scan.nextLine();
			etkinlikListesi.get(secim1 - 1).etkinlikAdi = scan.nextLine();
			etkinlikDuzenlemeMenu();
			break;

		case 2:
			System.out.println("Yeni etkinliğin tarihini girin");
			etkinlikListesi.get(secim1 - 1).etkinlikTarihi = scan.next();
			etkinlikDuzenlemeMenu();

			break;

		case 3:
			System.out.println("Yeni etkinliğin saatini girin");
			etkinlikListesi.get(secim1 - 1).etkinlikSaati = scan.nextDouble();

			etkinlikDuzenlemeMenu();

			break;

		case 4:
			System.out.println("Yeni etkinliğin Kim ile olduğunu girin");
			etkinlikListesi.get(secim1 - 1).etkinlikKimIle = scan.nextLine();
			etkinlikListesi.get(secim1 - 1).etkinlikKimIle = scan.nextLine();
			etkinlikDuzenlemeMenu();

			break;

		case 5:
			System.out.println("Yeni etkinliğin Açıklama notunu girin");
			etkinlikListesi.get(secim1 - 1).etkinlikNotu = scan.nextLine();
			etkinlikListesi.get(secim1 - 1).etkinlikNotu = scan.nextLine();
			etkinlikDuzenlemeMenu();

			break;

		case 6:
			etkinlikMenu();
			break;

		default:
			break;
		}

		scan.close();
	}

	@Override
	public String toString() {
		return 	"Etkinlik [etkinlikAdi=" + etkinlikAdi + ", etkinlikTarihi=" + etkinlikTarihi + ", etkinlikSaati="
				+ etkinlikSaati + ", etkinlikKimIle=" + etkinlikKimIle + ", etkinlikNotu=" + etkinlikNotu + "]";
	}

	public String toString1() {
		return 	" " + etkinlikTarihi + " " + etkinlikSaati + " " + etkinlikAdi + " etkiliğini yapılacaktır.";
	}
	
}
