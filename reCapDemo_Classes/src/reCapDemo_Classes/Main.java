package reCapDemo_Classes;

public class Main {

	public static void main(String[] args) {
		
		DortIslem dortIslem = new DortIslem();
		int sonuc = dortIslem.topla(3, 4, 5);
		System.out.println(sonuc);
		
		Product product = new Product();
		product.setId(1);
		product.setName("Laptop");
		product.setDesription("Asus Laptop");
		product.setPrice(5000);
		product.setStockAmount(3);
		
		ProductManager productManager = new ProductManager();
		productManager.Add(product);
		
		System.out.println(product.getName());
		
	}

}
