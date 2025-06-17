import java.util.logging.Logger;

public class No_424_Longest_Repeating_Character_Replacement {

    private static final Logger logger = Logger.getLogger(No_424_Longest_Repeating_Character_Replacement.class.getName());


    public static void main(String[] args) {
        Solution solution = new Solution();
//        Example 1:
//
//        Input: s = "ABAB", k = 2
//        Output: 4
//        Explanation: Replace the two 'A's with two 'B's or vice versa.
        logger.info(String.valueOf(solution.characterReplacement("ABAB", 2)));

//        Example 2:
//
//        Input: s = "AABABBA", k = 1
//        Output: 4
//        Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
//                The substring "BBBB" has the longest repeating letters, which is 4.
//        There may exists other ways to achieve this answer too.
        logger.info(String.valueOf(solution.characterReplacement("AABABBA", 1)));


//        Input s = "BAAAB"
//        k = 2
//        Expected
//        5
          logger.info(String.valueOf(solution.characterReplacement("BAAAB", 2)));


    }

    static class Solution {
        public int characterReplacement(String s, int k) {

            int [] counter = new int[26];
            char bias = 'A';
            int l = 0;
            int maxLen = 0;
            int maxCount = 0;

            char[] chars = s.toCharArray();
            for (int r = 0; r < chars.length; r++) {
                char c = chars[r];
                counter[c - bias]++;
                maxCount = Math.max(maxCount, counter[c - bias]);
                int pLen = r - l + 1;
                int needSwap = pLen - maxCount;
                if ( k < needSwap) {
                    counter[chars[l] - bias]--;
                    l++;
                } else {
                    maxLen = Math.max(maxLen, r - l +1);
                }

            }
            return maxLen;

        }
    }


}
