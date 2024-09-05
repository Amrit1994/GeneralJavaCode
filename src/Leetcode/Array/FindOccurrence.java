package Leetcode.Array;

public class FindOccurrence {

    private static int findFirstOccurrence(int[] arr, int target) {
        int l=0, r = arr.length-1;
        int result = -1;
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(arr[mid] == target) {
                result = mid; // record the result
                r = mid-1; // Move left to find earlier occurrence
            }
            else if(arr[mid] < target) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return result;
    }

    private static int findLastOccurrence(int[] arr, int target) {
        int l=0, r = arr.length-1;
        int result = -1;
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(arr[mid] == target) {
                result = mid; // record the result
                l = mid+1; // Move right to find later occurrence
            }
            else if(arr[mid] < target) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return result;
    }

    public static int countOccurrences(int[] arr, int x) {
        int first = findFirstOccurrence(arr, x);
        if(first == -1) {
            return 0;
        }
        int last = findLastOccurrence(arr, x);
        return last - first + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int x = 2;
        System.out.println(countOccurrences(arr, x));
    }
}
