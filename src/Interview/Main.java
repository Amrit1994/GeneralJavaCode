package Interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"apple","banana","orange","grapes","apple","orange","orange","banana","banana","banana","apple"};
        List<String> fruitList = Arrays.asList(arr);
        List<Map.Entry<String, Long>> result = fruitList.stream()
                .collect(Collectors.groupingBy(e->e, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
        System.out.println(result); // [apple=3, banana=4, grapes=1, orange=3]
    }
}