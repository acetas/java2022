package kodlamaIoOdev.core.logging;

public class DatabaseLogger implements BaseLogger {

	@Override
	public void log(String data) {
		System.out.println("Database üzerine loglandı: " + data);
		
	}
	
}
