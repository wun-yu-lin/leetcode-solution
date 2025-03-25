import java.util.HashMap;
import java.util.Map;

public class No_242_Valid_Anagram {

    public static class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;

            //Count the number of characters in string s.
            //Key: each character, Value: the count of each character.
            Map<Character, Integer> charCountMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (charCountMap.containsKey(s.charAt(i))) {
                    charCountMap.put(s.charAt(i), charCountMap.get(s.charAt(i)) + 1);
                } else {
                    charCountMap.put(s.charAt(i), 1);
                }
            }

            for (int i = 0; i < t.length(); i++) {
                if (charCountMap.containsKey(t.charAt(i))) {
                    // When the counts do not match.
                    if (charCountMap.get(t.charAt(i)) == 0) return false;

                    //When the characters match, decrement the count by 1
                    charCountMap.put(t.charAt(i), charCountMap.get(t.charAt(i)) - 1);
                } else {
                    // when not match count
                    return false;
                }
            }

            return true;

        }


        public static void main(String[] args) {
//            Example 1:
//
//            Input: s = "anagram", t = "nagaram"
//
//            Output: true
            System.out.println(new Solution().isAnagram("anagram", "nagaram"));

//
//            Example 2:
//
//            Input: s = "rat", t = "car"
//
//            Output: false
            System.out.println(new Solution().isAnagram("rat", "car"));
        }


    }
}
