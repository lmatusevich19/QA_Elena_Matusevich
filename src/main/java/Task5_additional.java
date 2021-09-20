import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Task5_additional {
    public static void main(String[] args) {
        Collection<Integer> collection = Arrays.asList(1, 2, 3, 0, -1, 10, 11, -20, 40);

        List<Integer> collectOne = collection.stream()
                .filter(value -> value > 0)
                .collect(Collectors.toList());

        List<Integer> collectTwo = collection.stream()
                .filter(value -> value < 0)
                .collect(Collectors.toList());

        List<Integer> collectThree = collection.stream()
                .filter(value -> value % 5 == 0)
                .collect(Collectors.toList());

        List<Integer> collectFour = collection.stream()
                .filter(value -> value % 10 == 0)
                .collect(Collectors.toList());

        System.out.println("Source collection: " + collection);
        System.out.println("Sort collection (value > 0): " + collectOne);
        System.out.println("Sort collection (value < 0): " + collectTwo);
        System.out.println("Sort collection (value % 5): " + collectThree);
        System.out.println("Sort collection (value % 10): " + collectFour);

    }
}
