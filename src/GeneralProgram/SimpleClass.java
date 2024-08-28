package GeneralProgram;

public class SimpleClass {

    private static char findNonRepeatable(String str) {
        int[] count = new int[256];
        for(int i=0; i<str.length(); i++) {
            count[str.charAt(i)]++;
        }
        for(int i=0; i<str.length(); i++){
            if(count[str.charAt(i)] == 1){
                return str.charAt(i);
            }
        }
        return '\0';
    }


    public static void main(String[] args) {
        String str = "blueeulbtsblu";     // 265 1
        //String str = "SSDDFGG";         b index b
        //char[] ch = str.toCharArray();  []



    }
}

//Example:
//Input : blueeulbtsblu, Output: t
//Input: ssddffgg, Output: -1