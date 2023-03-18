package employeemanagement_subscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import employeemanagement_publisher.EmployeeService;


public class EmployeeSubscriberActivator implements BundleActivator {

	ServiceReference<?> serviceReference;
	Scanner scanner = new Scanner(System.in);

	public void start(BundleContext bundleContext) throws Exception {
		
		System.out.println("\nStart Employee Management App...");
		serviceReference = bundleContext.getServiceReference(EmployeeService.class.getName());
		EmployeeService servicePublish = (EmployeeService) bundleContext.getService(serviceReference);
		
		String action;
		int id;
		
		System.out.println("\n-----------------------------------------");
		System.out.println("| Welcome to Employee Managment System |");
		System.out.println("-----------------------------------------");
		
		System.out.println();
		System.out.println("a. To add an employee enter 'ADD'");
		System.out.println("b. To remove an employee enter 'REMOVE'");
		System.out.println("c. To view all employees enter 'VIEW'");
		System.out.println("d. To view an employee enter 'VIEW EMPLOYEE'");
		System.out.println("e. To exit enter 'EXIT'"+"\n");
		
		//enter your choice
		System.out.print("Enter: ");
		action = scanner.nextLine();
		
		System.out.println();
		
		while(!action.equalsIgnoreCase("exit")) {
			
			if(action.equalsIgnoreCase("add")) {
				
				System.out.print("Enter the id of the employee: ");
				id = scanner.nextInt();
				
				if(servicePublish.contains(id)==true) {
					System.out.println("Employee already exists! "+"\n");
					
				}else {
					
					System.out.print("Enter the name of the employee: ");
					String name = scanner.next();
					System.out.print("Enter the contact number of the employee: ");
					String contact = scanner.next();
				    
				    while(contact.length()!=10) {
				    	System.out.print("Incorrect contact number.Please enter again: ");
					    contact = scanner.next();
				    }
					System.out.print("Enter the age of the employee: ");
					int age = scanner.nextInt();
				  
					System.out.println();
				    
					servicePublish.addEmployees(id, name, contact, age);
					System.out.println("Employee is Added"+"\n");
					
				}
				
			}else if(action.equalsIgnoreCase("remove")) {
				System.out.print("Enter the id of the employee you want to remove: ");
				id = scanner.nextInt();
				
				if(servicePublish.contains(id)==false) {
					System.out.println("Employee does not exist"+"\n");
					
				}else {
					
					if(servicePublish.removeEmployees(id)==true) {
						System.out.println("Employee is removed"+"\n");
					}
				}	
				
			}else if(action.equalsIgnoreCase("view")){
				servicePublish.viewEmployees();
				
			}else if(action.equalsIgnoreCase("view employee")) {
				System.out.print("Enter the id of the employee: ");
				int eid = scanner.nextInt();
				servicePublish.getAnEmployee(eid);
				
			}else if(!action.equalsIgnoreCase("view") || !action.equalsIgnoreCase("add") || !action.equalsIgnoreCase("remove") || !action.equalsIgnoreCase("exit")|| !action.equalsIgnoreCase("view employee")) {
				System.out.println("Please enter a valid input! ");
				
			}
			
			System.out.println("a. To add an employee enter 'ADD'");
			System.out.println("b. To remove an employee enter 'REMOVE'");
			System.out.println("c. To view all employees enter 'VIEW'");
			System.out.println("d. To view an employee enter 'VIEW EMPLOYEE'");
			System.out.println("e. To exit enter 'EXIT'"+"\n");
			
			System.out.print("Enter: ");
			action = scanner.next();
				
		}
		
		System.out.println("-----------------------------------------");
		System.out.println("|             Thank you!!!              |");
		System.out.println("-----------------------------------------");
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		System.out.println("Stop Employee Service App...");
		bundleContext.ungetService(serviceReference);
	}

}
