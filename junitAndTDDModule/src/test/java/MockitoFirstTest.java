import org.junit.Test;
import org.mockito.Mockito;

import java.util.Iterator;

/**
 * Created by Chaika Aleksei on 23.08.2016.
 */
public class MockitoFirstTest {

    @Test
    public void iteratorTest(){
        Iterator i = Mockito.mock(Iterator.class);
        Mockito.when(i.next()).thenReturn("First mock").thenReturn("second mock").thenReturn("third mock").thenReturn("last");
        Mockito.when(i.hasNext()).thenReturn(true);

        String tmp;
        while (i.hasNext()){
            System.out.println(tmp= (String) i.next());
            if (tmp.equals("last")) break;
        }
    }



}
