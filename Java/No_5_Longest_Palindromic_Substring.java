import java.util.Arrays;

public class No_5_Longest_Palindromic_Substring {
    //https://bclin.tw/2021/07/22/leetcode-5/
    //http://manacher-viz.s3-website-us-east-1.amazonaws.com/#/

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Example 1:
//
//        Input: s = "babad"
//        Output: "bab"
        System.out.println(solution.longestPalindrome("babad"));

//        Explanation: "aba" is also a valid answer.
//                Example 2:
//
//        Input: s = "cbbd"
//        Output: "bb"
        System.out.println(solution.longestPalindrome("cbbd"));

//        Input: s = "bb"
//        Output: "bb"
        System.out.println(solution.longestPalindrome("bb"));

        // input s = "a"
        //output = "a"
        System.out.println(solution.longestPalindrome("a"));

        // input s = "ac"
        //output = "a"
        System.out.println(solution.longestPalindrome("ac"));


    }

    static class Solution {
        public String longestPalindrome(String s) {

            if (s.length() <= 1) {
                return s;
            }

            String insertedStr = insertString(s);
            int[] pLen = new int[insertedStr.length()];
            for (int i = 0; i < insertedStr.length(); i++) {
                int maxLen = 0;
                int p1 = i -1, p2 = i + 1;

                //find max len of palindrome then current char
                boolean isPalindrome = true;
                while (isPalindrome) {

                    //out of index
                    if (p1 < 0 || p2 >= insertedStr.length()) {
                        pLen[i] = maxLen;
                        isPalindrome = false; continue;
                    }

                    if (insertedStr.charAt(p1) == insertedStr.charAt(p2) ) {
                        maxLen++;
                        p1--;
                        p2++;
                        pLen[i] = maxLen;
                        continue;
                    }

                    isPalindrome = false;
                }
            }

            //find max value pLen
            int maxIdx = 0; int maxLen = 0;
            for (int i = 0; i < pLen.length; i++) {
                if (pLen[i] > maxLen) {
                    maxLen = pLen[i];
                    maxIdx = i;
                }
            }
            int startIdx = maxIdx - maxLen ;
            int endIdx = maxIdx + maxLen;
            String res = String.valueOf(Arrays.copyOfRange(insertedStr.toCharArray(), startIdx, endIdx +1));

            return res.replaceAll("#", "");
        }

        /**
         * abc -> a#b#c
         */
        private String insertString(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("#");
            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt(i));
                sb.append("#");
            }
            return sb.toString();
        }

    }

    //TO-DO manacher algorithm
}
