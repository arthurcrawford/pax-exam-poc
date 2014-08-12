package uk.co.b2esoftware.skunk.paxexam;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerMethod;
import uk.co.b2esoftware.skunk.paxexam.bundleA.MyService;

import javax.inject.Inject;

import static org.junit.Assert.*;
import static org.ops4j.pax.exam.CoreOptions.*;


/**
 * Unit test for simple App.
 */
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerMethod.class)
public class AppTest
{
    @Inject
    private MyService myService;

    @Configuration
    public Option[] config() {

        return options (

            // These bundles will export slf4j Logger with log4j binding
            wrappedBundle(mavenBundle("log4j", "log4j", "1.2.17")),
            mavenBundle("org.ops4j.pax.logging", "pax-logging-api", "1.7.2"),
            mavenBundle("org.ops4j.pax.logging", "pax-logging-service", "1.7.2"),

            // Load the bundle under test
            mavenBundle("uk.co.b2esoftware.skunk.paxexam", "uk.co.b2esoftware.skunk.paxexam.bundleA", "1.0"),

            // Load junit bundles so the test can be run inside the OSGI container
            junitBundles()
        );
    }

    @Test
    public void myService()
    {
        assertNotNull(myService);
        assertEquals("Hello Pax!", myService.getMessage());
    }
}