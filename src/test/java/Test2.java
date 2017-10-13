import com.inflectra.spiratest.addons.junitextension.SpiraTestCase;
import com.inflectra.spiratest.addons.junitextension.SpiraTestConfiguration;
import com.inflectra.spiratest.addons.junitextension.SpiraTestListener;
import junit.framework.JUnit4TestAdapter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Some simple tests using the ability to return results back to SpiraTest
 *
 * @author		Inflectra Corporation
 * @version		3.0.0
 *
 */
@SpiraTestConfiguration(
        url="http://localhost/SpiraTest",
        login="petrov1",
        password="Qwer1234",
        projectId=5,
        releaseId=20,
        testSetId=8
)
public class Test2
{
    protected int fValue1;
    protected int fValue2;

    /**
     * Sets up the unit test
     */
    @Before
    public void setUp()
    {
        fValue1= 2;
        fValue2= 3;
    }

    /**
     * Tests the addition of the two values
     */
    @Test
    @SpiraTestCase(testCaseId=22)
    public void testAdd()
    {
        double result = fValue1 + fValue2;

        // forced failure result == 5
        assertTrue (result == 6);
    }

    /**
     * Tests division by zero
     */
    @Test
    @SpiraTestCase(testCaseId=23)
    public void testDivideByZero()
    {
        int zero = 0;
        int result = 8 / zero;
        result++; // avoid warning for not using result
    }

    /**
     * Tests two equal values
     */
    @Test
    @SpiraTestCase(testCaseId=6)
    public void testEquals()
    {
        assertEquals(12, 12);
        assertEquals(12L, 12L);
        assertEquals(new Long(12), new Long(12));

        assertEquals("Size", 12, 13);
        assertEquals("Capacity", 12.0, 11.99, 0.0);
    }

    /**
     * Tests success
     */
    @Test
    @SpiraTestCase(testCaseId=6)
    public void testSuccess()
    {
        //Successful test
        assertEquals(12, 12);
    }

    /**
     * Entry point for command line execution
     *
     * @param args	The command line arguments
     */
    public static void main (String[] args)
    {
        //Instantiate the JUnit core
        JUnitCore core = new JUnitCore();

        //Add the custom SpiraTest listener
        core.addListener(new SpiraTestListener());

        //Finally run the test fixture
        core.run(Test2.class);


    }

    /**
     * Entry point for JUnit 4.x runners
     *
     * @return		Handle to the test framework
     */
    public static junit.framework.Test suite()
    {
        System.out.println("TEST output");
        return new JUnit4TestAdapter(Test2.class);
    }
}