package Interview;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class IqviaInterview {

    public static void main(String[] args) {
        //{2,3,1,4,4,1,4,333,3,333,2,2,2,5,222};
        // expected 2
        int[] arr = {2,3,1,4,4,1,4,333,3,333,2,2,2,5,222};
       Optional<Integer> value =  Arrays.stream(arr).mapToObj(e->e).collect(Collectors.groupingBy(e-> e, Collectors.counting()))
                .entrySet().stream().sorted((e1, e2) -> Integer.compare(Integer.valueOf(e2.getValue().toString()), Integer.valueOf(e1.getValue().toString())))
                .map(e -> e.getKey()).findFirst();

        System.out.println(value.orElse(null));
    }
}
