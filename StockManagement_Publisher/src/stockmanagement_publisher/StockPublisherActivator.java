package stockmanagement_publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class StockPublisherActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		StockPublisherActivator.context = bundleContext;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		StockPublisherActivator.context = null;
	}

}
