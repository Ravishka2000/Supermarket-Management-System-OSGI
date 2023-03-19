package billingservice_subscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import billingservice_publisher.BillingService;

public class BillingSubscriberActivator implements BundleActivator {

Scanner scanner = new Scanner(System.in);
	
	private ServiceReference<BillingService> billingServiceRef;
    private BillingService billingService;


	public void start(BundleContext context) throws Exception {
		String operation = "start", cutomerType;
		double discount;
		
		billingServiceRef = context.getServiceReference(BillingService.class);
		billingService = context.getService(billingServiceRef);
		
		System.out.println("");
		System.out.println("--------------------------------------");
		System.out.println("|      Welcome to Billing System     |");
		System.out.println("--------------------------------------");
		
		System.out.println("");
		System.out.print("Enter Customer Type(Loyalty-L / Normal-N) : ");
		cutomerType = scanner.next();
		
		while(!operation.equalsIgnoreCase("stop")) {
			
			System.out.println("\nPlease select a task");
			System.out.println("");
			System.out.println("a. Add Item.");
			System.out.println("b. Remove Item.");
			System.out.println("c. Get Total.");
			System.out.println("d. Get Discount.");
			System.out.println("e. Get Total Bill.");
			System.out.println("f. Print Bill.");
			System.out.println("g. Type \"Stop\" to End.");
			System.out.println("");
			
			System.out.print("Enter the Task : ");
			operation = scanner.next();
			System.out.println("");
			
			if(operation.equalsIgnoreCase("a")) {
				
			    System.out.print("Enter Product: ");
			    String productName = scanner.next();
			    
			    System.out.print("Enter quantity: ");
			    int quantity = scanner.nextInt();

			    billingService.addPrice(productName, quantity);
			    
			}else if(operation.equalsIgnoreCase("b")) {
				
				System.out.print("Enter product: ");
			    String productName = scanner.next();
			    
			    System.out.print("Enter quantity: ");
			    int quantity = scanner.nextInt();

			    billingService.removePrice(productName, quantity);
			    
			}else if(operation.equalsIgnoreCase("c")) {
				
				System.out.println("Total : " + billingService.getTotal());
				
				
			}else if(operation.equalsIgnoreCase("d")) {
				if(cutomerType.equalsIgnoreCase("L")) {
					discount = billingService.clacDiscount(15);
				}else {
					discount = 0;
				}
				
				System.out.println("Discount : " + discount);
				
			}else if(operation.equalsIgnoreCase("e")) {
				
				if(cutomerType.equalsIgnoreCase("L")) {
					discount = billingService.clacDiscount(15);
				}else {
					discount = 0;
				}
				
				System.out.println("");
				billingService.getTotalBill(discount);
				
			}else if(operation.equalsIgnoreCase("f")) {
				
				billingService.printBill();
				
			}else {
				
				break;
				
			}
		}
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stop Billing Service....");
		context.ungetService(billingServiceRef);
	}

}
