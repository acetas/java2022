package polymorphismDemo;

public class DatabaseLogger implements BaseLogger {

	@Override
	public void log(String message) {
		System.out.println("Veritabanına loglandı: " + message);
		
	}

}
