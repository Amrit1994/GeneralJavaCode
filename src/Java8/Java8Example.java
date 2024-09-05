package Java8;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Java8Example {

    public static void extractDuplicateElement() {
        int[] numbers = {1, 2, 3, 2, 4, 5, 6, 1};
        Set<Integer> set = Arrays.stream(numbers).boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream().filter(e-> e.getValue() > 1).map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println(set);
    }

    public static void printDuplicateChars() {
        String input = "programming";
        Set<Character> set = input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c->c, Collectors.counting()))
                .entrySet().stream().filter(c-> c.getValue() > 1).map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println(set);
    }
    public static void printFirstRepeatedCharacter() {
        String input = "programming";
        Optional<Character> firstRepeated = input.chars().mapToObj(c-> (char) c)
                .collect(Collectors.groupingBy(c->c, Collectors.counting()))
                .entrySet().stream().filter(c->c.getValue() > 1).map(Map.Entry::getKey)
                .findFirst();
        System.out.println(firstRepeated.orElse(null));
    }

    public static void main(String[] args) {
        //extractDuplicateElement();
        //printDuplicateChars();
        printFirstRepeatedCharacter();
    }
}
