import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created  on 5/15/2017.
 */
public class CoreJavaTest {
    @Test
    public void ascendingFile() throws Exception {
        CoreJava.ascendingFile();
    }

    @Test
    public void descendingFile() throws Exception {
        CoreJava.descendingFile();
    }

    @Test
    public void maxString() throws Exception {
        CoreJava.maxString();
    }
}
