import org.junit.Test;

import java.util.ArrayList;

public class JUnitTest {

    ArrayList list = new ArrayList();

    @Test
    public void testArray(){
        assert (list.size() == 0);
    }
}
