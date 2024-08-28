package GeneralProgram;

import java.util.Arrays;
import java.util.Collections;

public class Game {
    private static int findMaxDuration(int N, Integer[] A) {
        // Sort the energies in descending order
        Arrays.sort(A, Collections.reverseOrder());
        int maxDuration = 0;
        while (true) {
            // Find the first player with non-zero energy
            int firstNonZeroIndex = -1;
            for (int i = 0; i < N; i++) {
                if (A[i] > 0) {
                    firstNonZeroIndex = i;
                    break;
                }
            }
            // if all the players has zero index break the loop
            if (firstNonZeroIndex == -1) {
                break;
            }
            // Reduce the energy of the player
            A[firstNonZeroIndex]--;
            maxDuration++;

            // Sort the array again to keep the highest energy players at the front
            Arrays.sort(A, Collections.reverseOrder());
        }
        return maxDuration;
    }

    public static void main(String[] args) {
        Integer[] arr = {2,1,1,1};
        int n = arr.length;
        System.out.println(findMaxDuration(n, arr));
    }
}
