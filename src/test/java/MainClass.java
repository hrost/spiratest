import com.inflectra.spiratest.addons.junitextension.SpiraTestListener;
import org.junit.runner.JUnitCore;


    public class MainClass {
        public static void main (String[] args)
        {
            System.out.println("We are in Main class");

            //Instantiate the JUnit core
            JUnitCore core = new JUnitCore();

            //Add the custom SpiraTest listener
            core.addListener(new SpiraTestListener());

            //Finally run the test fixture
            core.run(Test2.class);


        }

}
