package employeemanagement_publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class EmployeePublisherActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		EmployeePublisherActivator.context = bundleContext;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		EmployeePublisherActivator.context = null;
	}

}
