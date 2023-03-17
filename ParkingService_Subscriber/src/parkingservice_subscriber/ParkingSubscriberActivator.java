package parkingservice_subscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ParkingSubscriberActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		ParkingSubscriberActivator.context = bundleContext;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		ParkingSubscriberActivator.context = null;
	}

}
