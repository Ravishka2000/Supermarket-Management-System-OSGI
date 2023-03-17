package employeemanagement_subscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class EmployeeSubscriberActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		EmployeeSubscriberActivator.context = bundleContext;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		EmployeeSubscriberActivator.context = null;
	}

}
