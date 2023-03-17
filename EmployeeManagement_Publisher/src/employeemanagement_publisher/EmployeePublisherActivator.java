package employeemanagement_publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class EmployeePublisherActivator implements BundleActivator {

	ServiceRegistration<?> servicePublishRegistration;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Employee Service Started.....");
		EmployeeService servicepublisher = new EmployeeServiceImpl();
		servicePublishRegistration = bundleContext.registerService(EmployeeService.class.getName(), servicepublisher, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		System.out.println("Employee Service Stopped.....");
		servicePublishRegistration.unregister();
		
	}

}
