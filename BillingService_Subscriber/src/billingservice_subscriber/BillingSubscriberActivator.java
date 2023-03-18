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
		String operation = "start";
		
		billingServiceRef = context.getServiceReference(BillingService.class);
		billingService = context.getService(billingServiceRef);
		
		System.out.println("\n-------- Welcome --------");
		
		while(!operation.equalsIgnoreCase("stop")) {
			
			System.out.println("\na. Add a price.");
			System.out.println("b. Remove a price.");
			System.out.println("c. Get Total.");
			System.out.println("d. Get Total Bill.");
			System.out.println("e. Type \"Stop\" to End.");
			System.out.println("");
			
			System.out.print("Enter the Task : ");
			operation = scanner.next();
			
			if(operation.equalsIgnoreCase("a")) {
				
			    System.out.print("Enter Product: ");
			    String productName = scanner.next();
			    
			    System.out.print("Enter quantity: ");
			    int quantity = scanner.nextInt();

			    billingService.addPrice(productName, quantity);
			    
			}else if(operation.equalsIgnoreCase("b")) {
				
				System.out.print("Enter product name: ");
			    String productName = scanner.next();
			    
			    System.out.print("Enter quantity: ");
			    int quantity = scanner.nextInt();

			    billingService.removePrice(productName, quantity);
			    
			}else if(operation.equalsIgnoreCase("c")) {
				
				System.out.println("Total : " + billingService.getTotal());
				
				
			}else if(operation.equalsIgnoreCase("d")) {
				System.out.println("");
				billingService.getTotalBill();
				
			}else {
				
				break;
				
			}
		}
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stop Billing App....");
		context.ungetService(billingServiceRef);
	}

}
