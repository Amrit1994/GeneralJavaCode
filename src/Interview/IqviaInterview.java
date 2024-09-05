package Interview;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class IqviaInterview {

    public static void main(String[] args) {
        // get max repeated count element
        //{2,3,1,4,4,1,4,333,3,333,2,2,2,5,222};
        // expected 2
        int[] arr = {2,3,1,4,4,1,4,333,3,333,2,2,2,5,222};
       Optional<Integer> value =  Arrays.stream(arr).boxed().collect(Collectors.groupingBy(e-> e, Collectors.counting()))
                .entrySet().stream().sorted((e1, e2) -> Integer.compare(Integer.parseInt(e2.getValue().toString()), Integer.parseInt(e1.getValue().toString())))
                .map(Map.Entry::getKey).findFirst();

        System.out.println(value.orElse(null)); // 2
    }
}
