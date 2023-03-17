package parkingservice_publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ParkingPublisherActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		ParkingPublisherActivator.context = bundleContext;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		ParkingPublisherActivator.context = null;
	}

}
