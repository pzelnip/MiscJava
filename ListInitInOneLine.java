import java.util.*;

public class ListInitInOneLine {

    public static void main(String[] args) {

        // method 1: double-brace initialization (DBI)
        ArrayList<String> ar = new ArrayList<String>() {
            {
                add("This");
                add("is");
                add("a");
                add("list");
            }
        };
        System.out.println(ar);

        // note that this actually creates a temporary subclass of ArrayList,
        // which is assigned to ar.

        // method 2: Arrays.toList()

        List<String> ar2 = Arrays.asList(new String[] { "This", "is", "a",
                "list" });
        System.out.println(ar2);

        // note here that the return type of Arrays.asList() is List<T>, so if
        // you want an ArrayList, or some other specific List implementation
        // you'll have to convert it somehow.

        // method 3: create a variable argument factory method:

        ArrayList<String> ar3 = initList("This", "is", "a", "list");
        System.out.println(ar3);
    }

    // note that args is essentially just an array, so if the return type
    // were List<String> we could avoid the loop and do: Arrays.asList(args)
    public static ArrayList<String> initList(String... args) {
        ArrayList<String> ar = new ArrayList<String>();

        for (String s : args)
            ar.add(s);

        return ar;
    }
}
