class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivot = findPivot(nums, n);
        if (nums[pivot] == target)
            return pivot;

        int lp = bSearch(nums, 0, pivot, target);
        if (lp != -1)
            return lp;

        int rp = bSearch(nums, pivot + 1, n - 1, target);
        if (rp != -1)
            return rp;

        return -1;
    }

    int bSearch(int[] nums, int l, int h, int t) {
        int i = -1;

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (t == nums[m]) {
                return m;
            } else if (t > nums[m]) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        return -1;
    }

    int findPivot(int[] nums, int n) {
        int l = 0, h = n - 1;
        int pivot = -1;

        while (l <= h) {
            if (nums[l] <= nums[h])
                return l;

            int m = l + (h - l) / 2;

            if (nums[m] >= nums[l]) {
                pivot = l;
                l = m + 1;
            } else {
                h = m;
            }
        }

        return pivot;
    }
}