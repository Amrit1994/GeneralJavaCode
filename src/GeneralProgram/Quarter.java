package GeneralProgram;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Quarter {

    private static String findMinQuarter(String[] strArr) {
        List<String> list = Arrays.asList(strArr);
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                //2q22
                int quarter1 = Integer.parseInt(s1.substring(0, 1));
                int year1 = Integer.parseInt(s1.substring(2, 4));
                int quarter2 = Integer.parseInt(s2.substring(0, 1));
                int year2 = Integer.parseInt(s2.substring(2, 4));
                if (year1 != year2) {
                    return Integer.compare(year1, year2);
                } else {
                    return Integer.compare(quarter1, quarter2);
                }
            }
        };
        return Collections.min(list, comparator);
    }

    public static void main(String[] args) {
        String[] str = {"2Q22", "1Q23", "1Q22"};
        // Find minimum quarter
        System.out.println(findMinQuarter(str));
    }
}
