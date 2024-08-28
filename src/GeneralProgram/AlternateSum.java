package GeneralProgram;

public class AlternateSum {

    private int alternateSum(int n) {
        int[] target = new int[n];
        for(int i =0; i<n; i++) {
            target[i] = i+1;
        }
        int result = 0;
        while(target.length > 1) {
            int alternateSum = 0;
            for(int i=0; i<target.length; i+=2) {
                alternateSum += target[i];
            }
            result += alternateSum;
            int newLength = (target.length+1)/2;
            int[] newArr = new int[newLength];
           // for(int i=0, j=1; j< target.length, i++; j += 2) {

            //}                                                                                                                                                                                                                                                                                                                                                                                                                                                                               j<target.lenght)
        }
        return 0;
    }
}
