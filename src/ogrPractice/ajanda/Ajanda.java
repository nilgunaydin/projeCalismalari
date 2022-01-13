package ogrPractice.ajanda;

import java.io.Console;
import java.util.Scanner;

public class Ajanda {

	public static void main(String[] args) {
		
		ajandaMenu();
	}

	public static void ajandaMenu() {

		if (Rehber.rehberListesi.isEmpty()) {

			for (int i = 0; i < Data.adSoyad.size(); i++) {
				Rehber rehberobjesi = new Rehber(Data.adSoyad.get(i), Data.telefon.get(i), Data.eMail.get(i),
						Data.adres.get(i));
				Rehber.rehberListesi.add(rehberobjesi);
			}
		}
		
		Etkinlik etkMenu = new Etkinlik();
		Rehber rhbMenu = new Rehber();
		
		Scanner scan = new Scanner(System.in);
		System.out.println(
				  "╔═══════════════════════╗\r\n"
				+ "║    AJANDA MENUSU      ║\r\n"
				+ "╚═══════════════════════╝\r\n"
				+ "╔═══════════════════════╗\r\n"
				+ "║ 1- Etkinlik Islemleri ║\r\n"
				+ "╠═══════════════════════╣\r\n"
				+ "║ 2- Rehber Islemleri   ║\r\n"
				+ "╠═══════════════════════╣\r\n"
				+ "║ 3- Randevu Durumu     ║\r\n"
				+ "╠═══════════════════════╣\r\n"
				+ "║ 4- Cikis              ║\r\n"
				+ "╚═══════════════════════╝\r\n"
				+ "Lütfen yapmak istenilen işlem numarasını giriniz");
		int secim = scan.nextInt();

		switch (secim) {
		case 1:
			
			etkMenu.etkinlikMenu();

			break;

		case 2:
			
			rhbMenu.rehberMenu();
			
			break;
		case 3:
			randevuDurumu();
			//System.out.println("Rendevu Durumu Aktif Değil");
			//ajandaMenu();

			break;
		case 4:
			System.out.println("CIKMAK ISTEDIGINIZE EMINS MISINIZ? [E/H] ");
			char cikis = scan.next().charAt(0);
			if (cikis == 'e' || cikis == 'E') {
				System.out.println(
						  "╔════════════════════════════════════════╗\r\n"
						+ "║   C I K I S   Y A P I L M I S T I R    ║\r\n"
						+ "╚════════════════════════════════════════╝\r\n");
			} else {

				ajandaMenu();
			}

			break;

		default:
			System.out.println("Lütfen menüden bir seçim yapınız!");
			
			ajandaMenu();
			break;
		}

		scan.close();
	}

	private static void randevuDurumu() {
		Scanner scan = new Scanner(System.in);
		
		Ayarlar.bildirimYaz("GENEL RANDEVU BILGILERI");		
		for (Etkinlik each1 : Etkinlik.etkinlikListesi) {

			for (Rehber each : Rehber.rehberListesi) {

				if (each.kisiAdSoyad.equalsIgnoreCase(each1.etkinlikKimIle)) {
					System.out.println("Randevuuz " + each1.etkinlikKimIle+" ile "+ each1.etkinlikTarihi+" tarihinde "
					+each1.etkinlikSaati+" saat diliminde "+each1.etkinlikAdi+" etkinliği bulunuyor.\n"
							+ each1.etkinlikKimIle+" ile ilgili kişisel bilgiler aşağıda bulunmaktadır");				
				
					System.out.println(each);
					
				}

			}

		}
		
		System.out.println("AJANDA MENUSUNE DONMEK ICIN 0 (çıkış) tuşuna basınız");
		
		int secim=scan.nextInt();
		
		if (secim==0) {
			ajandaMenu();
		}
		randevuDurumu();

	}
	
}