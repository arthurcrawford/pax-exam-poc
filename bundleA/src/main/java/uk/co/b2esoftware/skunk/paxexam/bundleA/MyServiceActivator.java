package uk.co.b2esoftware.skunk.paxexam.bundleA;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Hashtable;

/**
 * User: art
 * Date: 11/08/2014
 * Time: 14:26
 */
public class MyServiceActivator implements BundleActivator
{
    private static Logger log = LoggerFactory.getLogger(MyServiceActivator.class);

    @Override
    public void start(final BundleContext bundleContext) throws Exception
    {
        log.info("MyServiceActivator started");
        Hashtable<String, String> props = new Hashtable<String, String>();
        props.put("Language", "English");
        final ServiceRegistration serviceReference = bundleContext.registerService(
            MyService.class.getName(),
            new MyService()
            {
                @Override
                public String getMessage()
                {
                    return "Hello Pax!";
                }
            },
            props);
        log.info(String.format("Service registered: %s", serviceReference));
    }

    @Override
    public void stop(final BundleContext bundleContext) throws Exception
    {
        log.info("MyServiceActivator stopped");
    }
}
