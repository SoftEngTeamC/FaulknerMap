/**
 * Created by Sam on 4/2/17.
 */
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class DBTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(DataBaseTesting.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }

}