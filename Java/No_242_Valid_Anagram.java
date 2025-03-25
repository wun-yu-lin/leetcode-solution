import java.util.HashMap;
import java.util.Map;

public class No_242_Valid_Anagram {

    public static class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;

            //Count character num of s
            // key : each character, value: count of each character
            Map<Character, Integer> charMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (charMap.containsKey(s.charAt(i))) {
                    charMap.put(s.charAt(i), charMap.get(s.charAt(i)) + 1);
                } else {
                    charMap.put(s.charAt(i), 1);
                }
            }

            for (int i = 0; i < t.length(); i++) {
                if (charMap.containsKey(t.charAt(i))) {
                    // when not match count
                    if (charMap.get(t.charAt(i)) == 0) return false;

                    //when match character , count -1
                    charMap.put(t.charAt(i), charMap.get(t.charAt(i)) - 1);
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
