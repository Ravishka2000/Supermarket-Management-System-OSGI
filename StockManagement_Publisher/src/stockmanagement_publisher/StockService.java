package stockmanagement_publisher;

public interface StockService {
	public void addProduct(String name, int quantity, int reorderLevel, double unitPrice);
	public void dispatchProduct(String name, int quantity);
	public int getQuantity(String name);
	public boolean deleteProduct(String name);
	public void getAllData();
	public Product getProductByName(String name);
	public void reorderProducts();
	public void printInventoryToCSV();
	public void exportToCSV(String filePath);
	public void importInventoryFromCSV();
	public void importInventory(String filePath);
}
