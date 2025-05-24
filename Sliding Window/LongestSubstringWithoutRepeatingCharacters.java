import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // HashSet to store characters in the current window
        Set<Character> set = new HashSet<>();

        // Two pointers to define the sliding window
        int i = 0, j = 0;

        // Variable to store the maximum length found so far
        int max = 0;

        // Iterate through the string with the 'j' pointer
        while (j < s.length()) {
            char ch = s.charAt(j);

            // If character not in set, it's a unique character in current window
            if (!set.contains(ch)) {
                // Calculate current window length and update max if needed
                int len = j - i + 1;
                if (len > max) {
                    max = len;
                }
            } else {
                // If character is already in set, move 'i' pointer to right
                // until the duplicate character is removed
                while (set.contains(ch)) {
                    set.remove(s.charAt(i));
                    i++;
                }
            }

            // Add the current character to the set
            set.add(ch);

            // Move 'j' pointer forward to expand the window
            j++;
        }

        // Return the length of the longest substring without repeating characters
        return max;
    }
}
