package Java8;

//@FunctionalInterface
public interface EmployeeInterface {
    public String toString();
}

//Object
class Employee implements  Cloneable{
    private static Employee emp = null;
    private Employee () {

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Employee class not supported clone");
    }

    public static Employee getEmployee () {
        if(emp == null) {
            emp =  new Employee();
        }
        return emp;
    }
}


//input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].


