package parkingservice_publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ParkingPublisherActivator implements BundleActivator {

	ServiceRegistration<?> serviceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Parking Service Started......");
		ParkingService garage = new ParkingServiceImpl();
		
		serviceRegistration = context.registerService(ParkingService.class.getName(), garage, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Parking Service Stopped.....");
		serviceRegistration.unregister();
	}

}
