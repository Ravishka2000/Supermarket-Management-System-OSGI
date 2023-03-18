package parkingservice_subscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import parkingservice_publisher.ParkingService;

public class ParkingSubscriberActivator implements BundleActivator {

	Scanner scanner = new Scanner(System.in);
	
	private ServiceReference<ParkingService> garageServiceRef;
    private ParkingService garageService;
    private ServiceRegistration<ParkingSubscriberActivator> registration;

    public void start(BundleContext context) throws Exception {
		
		String operation = "start";
		
		garageServiceRef = context.getServiceReference(ParkingService.class);
		garageService = context.getService(garageServiceRef);
		registration = context.registerService(ParkingSubscriberActivator.class, this, null);
		
		System.out.println("\n================================= ");
		System.out.println("   Welcome to Parking Service 🚗  	 ");
		System.out.println("=================================");
		
		System.out.println("\nPlease choose the service you want.");
		
		while(!operation.equalsIgnoreCase("stop")) {
			
			System.out.println("--------------------------------");
			System.out.println("|️ a. Park a vehicle.           |");
			System.out.println("| ‍️b. Remove a vehicle.         |");
			System.out.println("| c. Get parked vehicles count.|");
			System.out.println("| d. Check free space.         |");
			System.out.println("| e. Calculate parking fee.    |");
			System.out.println("| f. Export status to CSV.     |");
			System.out.println("| g. Import status from CSV.   |");
			System.out.println("| h. Type \"Stop\" to End.       |");
			System.out.println("--------------------------------");
			
			System.out.print("\nEnter the service type : ");
			operation = scanner.next();
			
			if(operation.equalsIgnoreCase("a")) {
				
			    System.out.print("Enter Vehicle name(Car/Bike/ThreeWheeler): ");
			    String vehicleName = scanner.next();
			    
			    System.out.print("Enter quantity: ");
			    int quantity = scanner.nextInt();

			    garageService.addVehicle(vehicleName, quantity);
			    
			}else if(operation.equalsIgnoreCase("b")) {
				
				System.out.print("Enter Vehicle name: ");
			    String vehicleName = scanner.next();
			    
			    System.out.print("Enter quantity: ");
			    int quantity = scanner.nextInt();

			    garageService.removeVehicle(vehicleName, quantity);
			    
			}else if(operation.equalsIgnoreCase("c")) {
				
				System.out.print("Enter vehicle name: ");
			    String vehicleName = scanner.next();

			    System.out.println(vehicleName + " : " + garageService.getVehicles(vehicleName));
			    
			}else if(operation.equalsIgnoreCase("d")) {
				
				garageService.getFreeSlots();
			    
			}else if(operation.equalsIgnoreCase("e")) {
				
				System.out.print("Enter Vehicle name: ");
			    String vehicleName = scanner.next();
			    
			    System.out.print("Enter time in minutes: ");
			    int mins = scanner.nextInt();
			    
				garageService.getParkingFee(vehicleName, mins);
			    
			}else if(operation.equalsIgnoreCase("f")) {
				
				garageService.printParkDetailsToCSV();
			}else if(operation.equalsIgnoreCase("g")) {
				
				garageService.importDetails();
			}
			
			else {
				break;
			}
		}
		
		System.out.println("\n------------------------------------------");
		System.out.println("|          Thank you for using our        |");
		System.out.println("|               Garage App!               |");
		System.out.println("------------------------------------------");
		 
		

	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stop Parking App....");
		context.ungetService(garageServiceRef);
		registration.unregister();
	}

}
