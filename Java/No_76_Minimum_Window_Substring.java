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

    public static class Solution2 {
        public String minWindow(String s, String t) {
            if (s.length() < t.length()) return "";

            Map<Character, Integer> template = new HashMap<>();
            for (char c : t.toCharArray()) {
                template.put(c, template.getOrDefault(c, 0) + 1);
            }

            Map<Character, Integer> window = new HashMap<>();
            int have = 0, need = template.size();
            int lp = 0, minLen = Integer.MAX_VALUE, minStart = 0;

            for (int rp = 0; rp < s.length(); rp++) {
                char c = s.charAt(rp);
                window.compute(c, (k, v) -> v == null ? 1 : v + 1);

                if (template.containsKey(c) && window.get(c).equals(template.get(c))) {
                    have++;
                }

                while (have == need) {
                    // update result if smaller window found
                    if (rp - lp + 1 < minLen) {
                        minLen = rp - lp + 1;
                        minStart = lp;
                    }

                    // shrink window from left
                    char leftChar = s.charAt(lp);
                    window.compute(leftChar, (k, v) -> v == null ? null : v -1);
                    if (template.containsKey(leftChar) &&
                            window.get(leftChar) < template.get(leftChar)) {
                        have--;
                    }
                    lp++;
                }
            }

            return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
        }

    }


    public static void main(String[] args) {
        Solution2 s = new Solution2();
//        Example 1:
//
//        Input: s = "ADOBECODEBANC", t = "ABC"
//        Output: "BANC"
//        Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
        logger.info("example 1:" + s.minWindow("ADOBECODEBANC", "ABC"));
//                Example 2:
//
//        Input: s = "a", t = "a"
//        Output: "a"
//        Explanation: The entire string s is the minimum window.
        logger.info("example 2:" + s.minWindow("a", "a"));

//        Example 3:
//
//        Input: s = "a", t = "aa"
//        Output: ""
//        Explanation: Both 'a's from t must be included in the window.
//                Since the largest window of s only has one 'a', return empty string.
        logger.info("example 3:" + s.minWindow("a", "aa"));

        //s = "aa", t="aa"
        //output "aa"
        logger.info("example 4:" + s.minWindow("aa", "aa"));

    }

}
