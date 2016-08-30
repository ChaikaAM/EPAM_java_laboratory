import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Chaika Aleksei on 22.08.2016.
 */
public class Range {

    private final int MAX;
    private final int MIN;
    public Range(int MIN, int MAX) {
        this.MAX = MAX;
        this.MIN = MIN;
    }

    boolean isBefore(int a){
        return MAX<a;
    }

    boolean isAfter(int a){
        return a<MIN;
    }

    boolean contains(int a){
        return (a>=MIN && a<=MAX);
    }

    boolean isConcurrent(Range other){
        return (other.MAX>=MIN && other.MIN<=MAX);
    }

    private Iterator<Integer> iterator = new Iterator<Integer>() {
        private int data = getLowerBound()-1;

        public boolean hasNext() {
            return (data)<getUpperBound();
        }

        public Integer next() {
            return ++data;
        }
    };

    public int getUpperBound() {
        return MAX;
    }

    public int getLowerBound() {
        return MIN;
    }

    List<Integer> asList(){
        List<Integer> result = new ArrayList<Integer>(MAX-MIN+1);
        for (int i = MIN; i < MAX+1; i++) {
            result.add(i);
        }
        return result;
    }

    public Iterator<Integer> getIterator() {
        return iterator;
    }

    public void setIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }
}
