package billingservice_publisher;

import java.util.HashMap;
import java.util.Map;


public class BillingServiceImpl implements BillingService{
	
	private final Map<String, Double> bill = new HashMap<>();
	
	private double apple = 100.00;
	private double orange = 80.00;
	private double grapes = 150.00;
	
	@Override
	public void addPrice(String name, int quantity) {
		
		if (name.equalsIgnoreCase("apple")) {
			bill.put(name, quantity * apple);
		}	
		else if(name.equalsIgnoreCase("orange")) {
			bill.put(name, quantity * orange);
		}
		else if(name.equalsIgnoreCase("grapes")) {
			bill.put(name, quantity * grapes);
		}
		else {
			System.out.println("Item not found");
		}
			
		System.out.println("\nAdded Successfully");
	}

	@Override
	public void removePrice(String name, int quantity) {
		
       double newPrice = 0, currentPrice = 0;
		
		if (name.equalsIgnoreCase("apple")) {
			newPrice = quantity * apple;
			currentPrice = bill.getOrDefault(name, 0.0);
		}	
		else if(name.equalsIgnoreCase("orange")) {
			newPrice = quantity * orange;
			currentPrice = bill.getOrDefault(name, 0.0);
		}
		else if(name.equalsIgnoreCase("grapes")) {
			newPrice = quantity * grapes;
			currentPrice = bill.getOrDefault(name, 0.0);
		}
		else {
			System.out.println("Item not found");
		}
		
		
        bill.put(name, currentPrice - newPrice);
        
        System.out.println("\nUpdated Successfully");
		
	}

	@Override
	public double getTotal() {
		double total = 0.0;
		for (Map.Entry<String, Double> entry : bill.entrySet()) {
            total +=  entry.getValue();
        }
		return total;	}

	@Override
	public void getTotalBill() {
		for (Map.Entry<String, Double> entry : bill.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
		System.out.println("\nTotal : " + getTotal());
	}
}
