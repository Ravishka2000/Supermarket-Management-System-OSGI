package billingservice_publisher;

public interface BillingService {
	public void addPrice(String name, int quantity);
	public void removePrice(String name, int quantity);
	public double getTotal();
	public double clacDiscount(int percentage);
	public void getTotalBill(double discount);
	public void printBill();
}
