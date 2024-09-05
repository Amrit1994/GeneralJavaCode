package Leetcode.Array;

public class SearchInRotatedSortedArray {

    private int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) {
                return mid;
            }
            // Search in left sorted array
            //if()
        }
        return 0;
    }
}
