package stockmanagement_subscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class StockSubscriberActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		StockSubscriberActivator.context = bundleContext;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		StockSubscriberActivator.context = null;
	}

}
