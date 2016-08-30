import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by Chaika Aleksei on 22.08.2016.
 */
public class RangeTest {

    private Range range;
    private Range anotherRange1;
    private Range anotherRange2;

    @Test
    @Before
    public void initRanges(){
        range = new Range(100,200);
        anotherRange1 = new Range(0,99);
        anotherRange2 = new Range(0,100);
    }

    @Test
    public void testIsBefore() throws Exception {
        assertTrue(range.isBefore(201));
        assertFalse(range.isBefore(200));
    }

    @Test
    public void testIsAfter() throws Exception {
        assertTrue(range.isAfter(99));
        assertFalse(range.isAfter(100));
    }

    @Test
    public void testContains() throws Exception {
        assertTrue(range.contains(101));
        assertTrue(range.contains(100));
        assertFalse(range.contains(99));
    }

    @Test
    public void testIsConcurrent() throws Exception {
        assertFalse(range.isConcurrent(anotherRange1));
        assertTrue(range.isConcurrent(anotherRange2));
    }

    @Test
    public void testGetUpperBound() throws Exception {
        assertEquals(anotherRange1.getUpperBound()+1, anotherRange2.getUpperBound());
    }

    @Test
    public void testGetLowerBound() throws Exception {
        assertEquals(anotherRange1.getLowerBound(), anotherRange2.getLowerBound());
    }

    @Test
    public void testAsList() throws Exception {
        assertEquals(anotherRange1.asList().size()+1, anotherRange2.asList().size());
    }

    @Test
    public void testIteratorWork(){
        Iterator<Integer> iterator = range.getIterator();
        int i=0;
        while (iterator.hasNext()){
            System.out.print(iterator.next() + ", ");
            if (++i%10==0) System.out.println();
        }
    }
}