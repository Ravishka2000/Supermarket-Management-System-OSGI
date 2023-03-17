package billingservice_publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class BillingPublisherActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		BillingPublisherActivator.context = bundleContext;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		BillingPublisherActivator.context = null;
	}

}
