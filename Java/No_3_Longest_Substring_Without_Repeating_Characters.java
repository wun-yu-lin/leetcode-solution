import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class No_3_Longest_Substring_Without_Repeating_Characters {
    static Logger logger = Logger.getLogger(No_3_Longest_Substring_Without_Repeating_Characters.class.getName());
    public static void main(String[] args) {
        Solution solution = new Solution();
//        Example 1:
//
//        Input: s = "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
        logger.info(String.valueOf(solution.lengthOfLongestSubstring("abcabcbb")));


//        Example 2:
//
//        Input: s = "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.
        logger.info(String.valueOf(solution.lengthOfLongestSubstring("bbbbb")));
//        Example 3:
//
//        Input: s = "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
        logger.info(String.valueOf(solution.lengthOfLongestSubstring("pwwkew")));


    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {

            if (s == null || s.isEmpty()) {
                return 0;
            }

            int l = 0;
            int r = 0;
            int res = 0;
            Set<Character> set = new HashSet<>();
            while (r < s.length()) {
                char c = s.charAt(r);
                if (set.contains(c)) {
                    set.remove(s.charAt(l));
                    l++;
                } else {
                    r++;
                    set.add(c);
                }

                res = Math.max(res, r- l);
            }

            return res;
        }
    }
}
