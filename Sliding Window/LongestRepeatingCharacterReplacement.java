import java.util.*;

class Solution {
    /*
     * Solution 1
     * Check if a window is valid or not based on characters to replace
     * If yes save it.
     * Shrink the window...
     */
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int i = 0, j = 0;
        Map<Character, Integer> count = new HashMap<>();
        int max = 0;

        while (j < n) {
            char ch = s.charAt(j);
            count.put(ch, count.getOrDefault(ch, 0) + 1);
            int wSize = j - i + 1;
            int toReplace = wSize - maxCount(count);

            if (toReplace <= k) {
                max = Math.max(max, wSize);
            } else {
                while (toReplace > k && i <= j) {
                    char ch2 = s.charAt(i);
                    count.put(ch2, count.get(ch2) - 1);
                    i++;
                    wSize = j - i + 1;
                    toReplace = wSize - maxCount(count);
                }
            }

            j++;
        }

        return max;
    }

    public int maxCount(Map<Character, Integer> map) {
        int max = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }

        return max;
    }
}