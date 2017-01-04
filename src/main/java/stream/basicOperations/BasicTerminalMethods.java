package stream.basicOperations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Basic terminal operations.
 *
 * Created by dkorolev on 1/4/2017.
 */
public class BasicTerminalMethods {

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("Bob", "Tom", "Mike", "Tom");
        List<Integer> integerList = Arrays.asList(3, 1, 5, 2, 3);

        //findFirst - get 1st element from the stream
        System.out.println(integerList.stream().findFirst().orElse(10));

        //findAny - get any element from the stream
        System.out.println(integerList.stream().findAny().orElse(10));

        //collect - pack results of operations into collections or other types of data
        System.out.println(stringList.stream().filter(s->s.contains("o"))
                .collect(Collectors.toList()));

        //count - return number of elements in stream
        System.out.println(stringList.stream().filter("Tom"::equals).count());

        //anyMatch - return true if condition is done at least for 1 element
        System.out.println(integerList.stream().anyMatch(Integer.valueOf(3)::equals));

        //noneMatch - return true if condition is not done for each elements
        System.out.println(stringList.stream().noneMatch(s->!s.equals("o")));

        //allMatch - return true, if condition satisfies for all elements
        System.out.println(stringList.stream().limit(2).allMatch(s -> s.contains("o")));

        //min - returns min element
        System.out.println(integerList.stream().min(Integer::compareTo).get());

        //max - returns max element
        System.out.println(stringList.stream().max(String::compareTo).get());

        //forEach - apply function to each element of a stream
        stringList.stream().forEach(s-> System.out.println(s.concat("_2")));

        //forEachOrdered - the same forEach but with guaranteed order(parallel stream)
        stringList.parallelStream().forEachOrdered(s-> System.out.println(s.concat("_2")));

        //toArray - returns array values from stream
        String[] strings = stringList.stream().map(String::toUpperCase).toArray(String[]::new);
        for (String string : strings) {
            System.out.print(string);
        }
        System.out.println();

        //reduce - allows to do aggregation functions and return one result
        System.out.println(integerList.stream().reduce((s1, s2) -> s1 + s2).orElse(-10));
    }
}
