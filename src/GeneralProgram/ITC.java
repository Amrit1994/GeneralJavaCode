package GeneralProgram;

import java.util.HashMap;
import java.util.Map;

public class ITC {

    private static  void findTheCount(char[] arr) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        for(char ch : map.keySet()) {
            int val = map.get(ch);
            if(val == 1)
             System.out.println(ch +" "+ val);
        }
    }

    public static void main(String[] args) {
        //String str="Java is programing language"
        String str="GoodEvening";
        findTheCount(str.toCharArray());
    }
}
