class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int i = 0, j = 1;
        int max = 0;

        while(j < n) {
            if(prices[j] > prices[i]) {
                int p = prices[j] - prices[i];
                if(p > max) max = p;
            } else {
                i = j;
            }

            j++;
        }

        return max;
    }
}