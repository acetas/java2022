package odev1;

public class Main {

	public static void main(String[] args) {

		// 5. video "hello world"

		System.out.println("Hello Java");
		System.out.println("Hello Java 2");

		// 6. video "variables"

		// case sensitive
		// camelCasing
		// reusability

		int ogrenciSayisi = 12;
		String mesaj = "Öğrenci sayısı : ";

		System.out.println(mesaj + ogrenciSayisi);
		System.out.println(mesaj + ogrenciSayisi);
		System.out.println(mesaj + ogrenciSayisi);
		System.out.println(mesaj + ogrenciSayisi);
		System.out.println(mesaj + ogrenciSayisi);

		// 7. video "datatypes"

		double sayi = 12.5;
		sayi = 13;

		char karakter = 'A';

		boolean dogruMu = false;

		// 8. video "conditionals"

		int sayi2 = 24;

		if (sayi2 < 20) {
			System.out.println("Sayı 20'den küçüktür");
		} else if (sayi2 == 20) {
			System.out.println("Sayı 20'e eşittir");
		} else {
			System.out.println("Sayı 20'den büyüktür");
		}

		// 9. video "recapDemo1"

		int sayi3 = 266;
		int sayi4 = 25;
		int sayi5 = 26;

		int enBuyuk = sayi3;

		if (enBuyuk < sayi4) {
			enBuyuk = sayi4;
		}

		if (enBuyuk < sayi5) {
			enBuyuk = sayi5;
		}

		System.out.println("En büyük = " + enBuyuk);

		// 10. video "switchDemo"

		char grade = 'C';

		switch (grade) {
		case 'A':
			System.out.println("Mükemmel : Geçtiniz");
			break;
		case 'B':
		case 'C':
			System.out.println("İyi : Geçtiniz");
			break;
		case 'D':
			System.out.println("Fena değil : Geçtiniz");
			break;
		case 'F':
			System.out.println("Maalesef kaldınız");
			break;
		default:
			System.out.println("Geçersiz Not Girdiniz");
		}

		// 11. video "loopDemo"

		// For döngüsü
		for (int i = 2; i < 10; i += 2) {
			System.out.println(i);
		}
		System.out.println("For Döngüsü bitti");

		// 12. video "while Döngüsü"

		int i = 2;
		while (i < 10) {
			System.out.println(i);
			i += 2;
		}
		System.out.println("While Döngüsü bitti");

		// 13. video "do while Döngüsü"

		int j = 100;
		do {
			System.out.println("Loglandı");
			if (j < 10) {
				System.out.println(j);
				j += 2;
			}
		} while (j < 10);
		System.out.println("Do-While Döngüsü bitti");

		// 14. video "arraysDemo"

		String[] ogrenciler = new String[4];
		ogrenciler[0] = "Ahmet";
		ogrenciler[1] = "Engin";
		ogrenciler[2] = "Derin";
		ogrenciler[3] = "Salih";

		for (int k = 0; k < ogrenciler.length; k++) {
			System.out.println(ogrenciler[k]);
		}

		for (String ogrenci : ogrenciler) {
			System.out.println(ogrenci);
		}

		// 15. video "reCapDemo2"

		double[] myList = { 1.2, 6.3, 4.3, 5.6 };

		double total = 0;
		double max = myList[0];
		for (double number : myList) {
			if (max < number) {
				max = number;
			}
			total = total + number;
			System.out.println(number);
		}

		System.out.println("Toplam: " + total);
		System.out.println("En büyük sayı: " + max);

		// 16. video "multiDimensionalArrayDemo"

		String[][] sehirler = new String[3][3];

		sehirler[0][0] = "İstanbul";
		sehirler[0][1] = "Bursa";
		sehirler[0][2] = "Bilecik";
		sehirler[1][0] = "Ankara";
		sehirler[1][1] = "Konya";
		sehirler[1][2] = "Kayseri";
		sehirler[2][0] = "Diyarbakır";
		sehirler[2][1] = "Şanlıurfa";
		sehirler[2][2] = "Gaziantep";

		for (int m = 0; m <= 2; m++) {
			System.out.println("--------------------------------");
			for (int n = 0; n <= 2; n++) {
				System.out.println(sehirler[m][n]);
			}
		}

		// 17. video "stringsDemo"

		String mesaj2 = "Bugün hava çok güzel.";

		System.out.println(mesaj2);

		System.out.println("Eleman sayısı: " + mesaj2.length());

		System.out.println("5. eleman: " + mesaj2.charAt(4));

		System.out.println(mesaj2.concat(" Yaşasın!"));

		System.out.println(mesaj2.startsWith("b"));

		System.out.println(mesaj2.endsWith("."));

		char[] karakterler = new char[5];
		mesaj2.getChars(0, 5, karakterler, 0);
		System.out.println(karakterler);

		System.out.println(mesaj2.indexOf("av"));
		System.out.println(mesaj2.lastIndexOf("a"));

		// 18. video "replace"

		String yeniMesaj = mesaj2.replace(' ', '-');
		System.out.println(yeniMesaj);

		System.out.println(mesaj2.substring(2, 5));

		for (String kelime : mesaj2.split(" ")) {
			System.out.println(kelime);
		}

		System.out.println(mesaj2.toLowerCase());
		System.out.println(mesaj2.toUpperCase());

		String mesaj3 = "   Bugün hava çok güzel.   ";
		System.out.println(mesaj3.trim());

		// 19. video "miniProjeAsalSayı"

		int number = 2;
		int remainder = number % 2;

		System.out.println(remainder);

		boolean isPrime = true;

		if (number == 1) {
			System.out.println("Sayı asal değildir");
			return;
		}

		if (number < 1) {
			System.out.println("Geçersiz sayı");
		}

		for (int o = 2; o < number; o++) {
			if (number % o == 0) {
				isPrime = false;
			}
		}

		if (isPrime) {
			System.out.println("Sayı asaldır.");
		} else {
			System.out.println("Sayı asal değildir");
		}

		// 20. video "sesliHarfler"

		char harf = 'A';

		switch (harf) {
		case 'A':
		case 'I':
		case 'O':
		case 'U':
			System.out.println("Kalın sesli harf");
			break;
		default:
			System.out.println("İnce sesli harf");
		}

		// 21. video "mukemmelSayi"

		int number2 = 28;
		int total2 = 0;

		for (int k = 1; k < number2; k++) {
			if (number2 % k == 0) {
				total2 = total2 + k;
			}
		}

		if (total2 == number2) {
			System.out.println("Sayı mükemmel sayıdır");
		} else {
			System.out.println("Sayı mükemmel sayı değildir");
		}

		// 22. video "arkadasSayilar"

		int arkadasSayi1 = 220;
		int totalSayi1 = 0;
		int arkadasSayi2 = 284;
		int totalSayi2 = 0;

		for (int k = 1; k < arkadasSayi1; k++) {
			if (arkadasSayi1 % k == 0) {
				totalSayi1 = totalSayi1 + k;
			}
		}

		for (int k = 1; k < arkadasSayi2; k++) {
			if (arkadasSayi2 % k == 0) {
				totalSayi2 = totalSayi2 + k;
			}
		}

		if (arkadasSayi1 == totalSayi2 && arkadasSayi2 == totalSayi1) {
			System.out.println("Arkadaş sayılardır");
		} else {
			System.out.println("Arkadaş sayı değillerdir");
		}

		// 23. video "sayiBulma"

		int[] sayilar = new int[] { 1, 2, 5, 7, 9, 0 };
		int aranacak = 5;
		boolean sayiVarMi = false;

		for (int sayi7 : sayilar) {
			if (sayi7 == aranacak) {
				sayiVarMi = true;
				break;
			}
		}

		if (sayiVarMi) {
			System.out.println("Sayı bulundu: " + aranacak);
		} else {
			System.out.println("Sayı bulunamadı");
		}

	}

}
