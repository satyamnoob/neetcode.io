import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int[] s1Count = new int[26];
        int[] win = new int[26];

        for (char ch : s1.toCharArray()) {
            s1Count[ch - 'a']++;
        }

        int i = 0;
        for (int j = 0; j < n; j++) {
            char ch = s2.charAt(j);
            win[ch - 'a']++;

            if (j - i + 1 > s1.length()) {
                win[s2.charAt(i) - 'a']--;
                i++;
            }

            if ((j - i + 1 == s1.length()) && Arrays.equals(win, s1Count))
                return true;
        }

        return false;
    }
}