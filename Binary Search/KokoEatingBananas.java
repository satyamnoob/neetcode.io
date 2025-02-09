class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length;
        int low = 1, high = piles[n - 1];
        int ans = high;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int nh = findHours(piles, mid);

            if(nh <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        } 

        return ans;
    }

    public int findHours(int[] piles, int speed) {
        int result = 0;

        for(int i = 0; i < piles.length; i++) {
            result += Math.ceil(piles[i] / (speed * 1.0));
        }

        return result;
    }
}