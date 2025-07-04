import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

public class No_76_Minimum_Window_Substring {
    private static final Logger logger = Logger.getLogger(No_76_Minimum_Window_Substring.class.getName());

    public static class Solution {
        public String minWindow(String s, String t) {
            if (s.length() < t.length()) {
                return "";
            }
            Map<Character, Integer> counter = new HashMap<>();
            Map<Character, Integer> templateCounter = new TreeMap<>();
            //prepare counter
            char[] tChars = t.toCharArray();
            for (char tChar : tChars) {
                templateCounter.compute(tChar, (k, v) -> v == null ? 1 : v + 1);
            }

            char[] sChars = s.toCharArray();
            int lp = 0;
            int minLenValue = Integer.MAX_VALUE;
            String result = "";
            for (int rp = 0; rp < sChars.length; rp++) {

                counter.compute(sChars[rp], (k, v) -> v == null ? 1 : v + 1);
                //match counter
                boolean isNotMatch = isCounterNotMatch(counter, templateCounter);

                if (isNotMatch) continue;

                //process match, find minValue
                while (lp <= rp) {
                    int currLen = rp - lp + 1;
                    if (minLenValue > currLen) {
                        minLenValue = currLen;
                        result = s.substring(lp, rp + 1);
                    }

                    //shift pointer
                    counter.compute(sChars[lp], (k, v) -> v == null ? 0 : v - 1);
                    lp++;
                    //update
                    isNotMatch = isCounterNotMatch(counter, templateCounter);
                    if (isNotMatch) break;
                }
            }
            return result;
        }

        private boolean isCounterNotMatch(Map<Character, Integer> target, Map<Character, Integer> template) {
            return template.entrySet().stream().anyMatch( //
                    entry -> target.getOrDefault(entry.getKey(), 0).compareTo(entry.getValue()) < 0); //
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
//        Example 1:
//
//        Input: s = "ADOBECODEBANC", t = "ABC"
//        Output: "BANC"
//        Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
        System.out.println("example 1:" +  s.minWindow("ADOBECODEBANC", "ABC"));
//                Example 2:
//
//        Input: s = "a", t = "a"
//        Output: "a"
//        Explanation: The entire string s is the minimum window.
        System.out.println("example 2:"+s.minWindow("a", "a"));

//        Example 3:
//
//        Input: s = "a", t = "aa"
//        Output: ""
//        Explanation: Both 'a's from t must be included in the window.
//                Since the largest window of s only has one 'a', return empty string.
        System.out.println("example 3:"+s.minWindow("a", "aa"));

    }

}
