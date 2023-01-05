package overriding;

public class Main {

	public static void main(String[] args) {
		BaseCreditManager[] creditManagers = new BaseCreditManager[] {new OgretmenCreditManager(), new TarimCreditManager(), new OgrenciCreditManager()};

		for (BaseCreditManager creditManager : creditManagers) {
			double result = creditManager.hesapla(1000);
			System.out.println(result);
		}

	}

}
