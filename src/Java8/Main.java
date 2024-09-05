package Java8;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static int findMaxNumber(List<Integer> numberList) {
        return numberList.stream().max(Integer::compareTo).orElseThrow(() -> new RuntimeException("List is Empty"));
    }

    private static String findRepeatedChar(String str) {
        Map<Character, Long> map = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.entrySet().stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

    private static String findUniqueChars(String str) {
        return str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
    // Parallel Stream
    private static int summingElements(List<Integer> list) {
        return list.parallelStream().mapToInt(Integer::intValue).sum();
    }
    private static int findingMaxValue(List<Integer> list) {
        return list.parallelStream().mapToInt(Integer::intValue).max().orElseThrow();
        // Alternatively, convert a sequential stream to parallel using parallel()
        //return list.stream().parallel().mapToInt(Integer::intValue).max().orElseThrow();
    }

    private static List<String> combiningStreamAndParallelStream(List<String> words) {
        return words.stream().filter(word -> word.length() > 5)
                .parallel().map(String :: toUpperCase).collect(Collectors.toList());
    }

    private static List<Double> generateRandomNumber(int n) {
        Stream<Double> randomNumbers = Stream.generate(Math::random).limit(n);
        return randomNumbers.collect(Collectors.toList());
    }
    private static List<Integer> iterateOddNumber(int n) {
        Stream<Integer> numbers = Stream.iterate(1, i->i+2).limit(n);
        return numbers.collect(Collectors.toList());
    }
    private static List<Integer> iterateEvenNumber(int n) {
        Stream<Integer> numbers = Stream.iterate(0, i->i+2).limit(n);
        return numbers.collect(Collectors.toList());
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Random Numbers -> "+ generateRandomNumber(n));
        System.out.println("Odd Numbers -> "+ iterateOddNumber(n));
        System.out.println("Even Numbers -> "+ iterateEvenNumber(n));
    }
}
