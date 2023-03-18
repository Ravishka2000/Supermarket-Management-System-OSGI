package main_app;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import billingservice_subscriber.BillingSubscriberActivator;
import employeemanagement_subscriber.EmployeeSubscriberActivator;
import parkingservice_subscriber.ParkingSubscriberActivator;
import stockmanagement_subscriber.StockSubscriberActivator;

public class ServiceActivator implements BundleActivator {

	ServiceReference<StockSubscriberActivator> stockServiceReference;
	StockSubscriberActivator stockActivator;
	
	ServiceReference<ParkingSubscriberActivator> parkingServiceReference;
	ParkingSubscriberActivator parkingActivator;
	
	ServiceReference<EmployeeSubscriberActivator> employeeServiceReference;
	EmployeeSubscriberActivator employeeActivator;
	
	ServiceReference<BillingSubscriberActivator> billingServiceReference;
	BillingSubscriberActivator billigActivator;
	
	Scanner sc = new Scanner(System.in);

	public void start(BundleContext context) throws Exception {
		
		String choice = "start";
		
		stockServiceReference = context.getServiceReference(StockSubscriberActivator.class);
		stockActivator = context.getService(stockServiceReference);
		
		parkingServiceReference = context.getServiceReference(ParkingSubscriberActivator.class);
		parkingActivator = context.getService(parkingServiceReference);
		
		employeeServiceReference = context.getServiceReference(EmployeeSubscriberActivator.class);
		employeeActivator = context.getService(employeeServiceReference);
		
		billingServiceReference = context.getServiceReference(BillingSubscriberActivator.class);
		billigActivator = context.getService(billingServiceReference);
		
		while(choice.equalsIgnoreCase("stop")) {
			System.out.print("a.Manage Stocks : ");
			System.out.print("b.Manage Parking : ");
			System.out.print("c.Manage Billing : ");
			System.out.print("d.Manage Employees : ");
			
			choice = sc.next();
			
			if (choice.equalsIgnoreCase("a")) {
				stockActivator.start(context);
			}else if (choice.equalsIgnoreCase("b")) {
				parkingActivator.start(context);
			}else if (choice.equalsIgnoreCase("c")) {
				billigActivator.start(context);
			}else if (choice.equalsIgnoreCase("d")) {
				employeeActivator.start(context);
			}else {
				break;
			}
		}
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Main App Stopped....");
		context.ungetService(billingServiceReference);
		context.ungetService(employeeServiceReference);
		context.ungetService(parkingServiceReference);
		context.ungetService(stockServiceReference);
	}

}
