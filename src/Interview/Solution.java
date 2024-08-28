package Interview;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee e1 = new Employee("John", 30);
        Employee e2 = new Employee("Alex", 25);
        Employee e3 = new Employee("Bob", 45);
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        employees.stream().sorted((a, b) -> Integer.compare(b.getAge(),a.getAge())).map(e->e.getName());
    }
}
