import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by Sam Coache on 3/31/17.
 */
@RunWith(Arquillian.class)
public class MainControllerTest {
    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void panic() throws Exception {
    }

    @org.junit.Test
    public void search() throws Exception {
    }

    @org.junit.Test
    public void login() throws Exception {
    }

    @org.junit.Test
    public void goToHelp() throws Exception {
    }

    @org.junit.Test
    public void initialize() throws Exception {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(MainController.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
