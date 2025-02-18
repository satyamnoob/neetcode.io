class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int low = 0, high = n - 1;
        int min = Integer.MAX_VALUE;

        while(low <= high) {
            // If sub array is already sorted !!
            if(nums[low] <= nums[high]) {
                min = nums[low];
                break;
            } 
            // So it is clear that array is rotated !!
            else {
                int mid = low + (high - low) / 2;
                // Considering curr as smallest
                min = nums[mid];
                
                // If low --> mid is already sorted
                // >= because there can be an edge case where low and mid are same indices !!
                if(nums[mid] >= nums[low]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
                
            }
        }

        return min;
    }
}