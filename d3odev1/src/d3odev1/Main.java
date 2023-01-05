package d3odev1;

import d3odev1.business.BaseCreditManager;
import d3odev1.business.CreditManager;
import d3odev1.entities.IndividualCustomer;

public class Main {

	public static void main(String[] args) {
		
		int sayi1 = 10;
		int sayi2 = 20;
		
		sayi1 = sayi2;
		sayi2 = 100;
		
		System.out.println(sayi1);
		
		int[] sayilar1 = {1,2,3};
		int[] sayilar2 = {10,20,30};
		
		sayilar1 = sayilar2;
		sayilar2[0] = 1000;
		
		System.out.println(sayilar1[0]);
		
		BaseCreditManager creditManager = new CreditManager();
		creditManager.calculate();
		

		IndividualCustomer individualCustomer = new IndividualCustomer();
		individualCustomer.setId(1);
		individualCustomer.setFirstName("Ahmet");
		individualCustomer.setLastName("Çetintaş");
		individualCustomer.setNationalIdentity("1234567890");
		
		creditManager.save(individualCustomer);
		
		System.out.println(individualCustomer.getFirstName());
		
	}

}
