import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Example showing how a class can support multiple iterators, and implement
 * them in such a way that the class supports for-each style iteration on the
 * result of the iterator calls.
 * 
 * @author aparkin
 * 
 */
public class MultipleIterables {

    Map<String, Integer> stringIntMap = new HashMap<String, Integer>();
    Map<String, Double> stringDblMap = new HashMap<String, Double>();

    /**
     * Iterable over the String/Integer map, note the use of nested anonymous
     * class to provide the iterable implementation.
     */
    public Iterable<Entry<String, Integer>> stringIntIterable() {
        return new Iterable<Entry<String, Integer>>() {

            @Override
            public Iterator<Entry<String, Integer>> iterator() {
                return stringIntMap.entrySet().iterator();
            }
        };
    }

    /**
     * Iterable over the String/Double map, note the use of nested anonymous
     * class to provide the iterable implementation.
     */
    public Iterable<Entry<String, Double>> stringDblIterable() {
        return new Iterable<Entry<String, Double>>() {

            @Override
            public Iterator<Entry<String, Double>> iterator() {
                return stringDblMap.entrySet().iterator();
            }
        };
    }

    public static void main(final String[] args) throws InterruptedException {
        MultipleIterables tt = new MultipleIterables();
        tt.stringIntMap.put("FortyTwo", 42);
        tt.stringIntMap.put("Six times Nine", 6 * 9);
        tt.stringDblMap.put("FortyTwo", 42.0);
        tt.stringDblMap.put("Six times Nine", 6.0 * 9.0);

        // iterate over the string/int map
        for (Entry<String, Integer> entry : tt.stringIntIterable()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // iterate over the string/double map
        for (Entry<String, Double> entry : tt.stringDblIterable()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

