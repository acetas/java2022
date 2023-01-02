package methods;

public class Main {

	public static void main(String[] args) {

		sayiBulmaca();
		
	}
	
	public static void sayiBulmaca() {
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
			mesajVer("Sayı bulundu: " + aranacak);
		} else {
			mesajVer("Sayı bulunamadı");
		}
	}
	
	public static void mesajVer(String mesaj) {
		System.out.println(mesaj);
	}

}
