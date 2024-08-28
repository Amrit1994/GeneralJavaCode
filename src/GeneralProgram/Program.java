package GeneralProgram;

public class Program {

    private static void swap(int a, int b) {
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println("After swap a = "+ a + " b = "+ b );
    }

    private static void swapUsingBitwise(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After swap a = "+ a + " b = "+ b );
    }

    // 8421
    private static boolean findOddEven(int num) {
        return (num & 1) != 1;
    }

    public static void main(String[] args) {
        int a =10;
        int b  = -5;
        System.out.println("Before swap a = "+ a + " b = "+ b );
        swapUsingBitwise(a,b);
        int input = 3;
        boolean isEven = findOddEven(input);
        String s = isEven ? input + " is Even " : input + " is odd ";
        System.out.println(s);

    }
}
