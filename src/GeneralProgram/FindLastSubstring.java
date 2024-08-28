package GeneralProgram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindLastSubstring {

    public String lastSubstring(String s) {
        List<String> substrings = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            substrings.add(s.substring(0, i) + s.substring(i+1));
        }
        Collections.sort(substrings);
        return substrings.getLast();
    }
}
