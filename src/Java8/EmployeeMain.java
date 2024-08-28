package Java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EmployeeMain {

    private static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];   // 2, 7, 11, 15
                                    // target = 9
        for(int i=0; i<arr.length; i++) {
            if(map.containsKey(target - arr[i])) {
                result[0] = map.get(target - arr[i]);
                result[1] = i;
                return result;
            }
            map.put(arr[i], i);
        }
        return result;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
//        Employee emp1 = Employee.getEmployee();
//        Employee emp2 = Employee.getEmployee();
//        try {
//            Employee emp3 = (Employee) emp1.clone();
//        }catch (Exception ex) {
//
//        }

        //System.out.println(emp1.hashCode());
//        System.out.println(emp2.hashCode());

        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}

//input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].