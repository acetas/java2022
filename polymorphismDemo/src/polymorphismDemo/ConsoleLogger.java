package polymorphismDemo;

public class ConsoleLogger implements BaseLogger {
	
	@Override
	public void log(String message) {
		System.out.println("Console'a loglandı: " + message);
		
	}
	
}
