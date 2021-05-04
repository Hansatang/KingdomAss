import org.junit.Test;
import utility.collection.ArrayList;

public class JUnitTest {

    ArrayList list = new ArrayList();

    @Test
    public void testArray(){
        assert (list.size() == 0);
    }
}
