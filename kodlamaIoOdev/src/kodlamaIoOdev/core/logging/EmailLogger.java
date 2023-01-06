package kodlamaIoOdev.core.logging;

public class EmailLogger implements BaseLogger {

	@Override
	public void log(String data) {
		System.out.println("Email ile loglandı: " + data);
		
	}
	
}
