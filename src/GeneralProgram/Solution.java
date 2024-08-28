package GeneralProgram;

import java.util.*;

public class Solution {

    private static Map<String, List<String>> createReverseMap(Map<String, List<String>> map) {
        Map<String, List<String>> reverseMap = new HashMap<>();
        for(String key : map.keySet()) {
            for(String val: map.get(key)) {
                reverseMap.putIfAbsent(val, new ArrayList<>());
                reverseMap.get(val).add(key);
            }
        }
        return  reverseMap;
    }

    private static Map<String, Integer> calculateDependencies(Map<String, List<String>> map) {
        Map<String, Integer> countDependencies = new HashMap<>();
        for(String key: map.keySet()) {
            Set<String> visited = new HashSet<>();
            countDependencies(key, map, visited);
            countDependencies.put(key, visited.size()-1);
        }
        return countDependencies;
    }

    private static void countDependencies(String item, Map<String, List<String>> reverseDep, Set<String> visited) {
        if(visited.contains(item)) {
            return;
        }
        visited.add(item);
        if(reverseDep.containsKey(item)) {
            for(String dep: reverseDep.get(item)) {
                countDependencies(dep, reverseDep, visited);
            }
        }

    }

    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("A", List.of("C"));
        map.put("B", List.of("C"));
        map.put("C", List.of("F"));
        map.put("D", List.of("E"));
        map.put("E", List.of("F"));
        map.put("F", List.of("F"));
        Map<String, List<String>> reverseMap = createReverseMap(map);
        Map<String, Integer> countDependencies = calculateDependencies(reverseMap);
        for(Map.Entry<String, Integer> entry: countDependencies.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


    }
}


// A, C

// B, C

// C, F

// D, E

// E, F

// F, F



// A -> 0

// C -> 2 // A, B

// F -> 6 // C, E, F, A, B, D