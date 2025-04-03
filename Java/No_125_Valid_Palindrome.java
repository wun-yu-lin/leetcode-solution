public class No_125_Valid_Palindrome {
    static class Solution {
        public boolean isPalindrome(String s) {
            String lowcaseString = s.toLowerCase();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < lowcaseString.length(); i++) {
                char temp = lowcaseString.charAt(i);
                if (Character.isLetterOrDigit(temp)) {
                    sb.append(lowcaseString.charAt(i));
                }
            }
            String filtedString = sb.toString();
            if (filtedString.isEmpty()) {
                return true;
            }
            int p2 = filtedString.length() - 1;
            for (int p1 = 0; p1 < filtedString.length(); p1++) {
                if (filtedString.charAt(p1) != filtedString.charAt(p2)) {
                    break;
                }
                if (p1 >= p2) {
                    return true;
                }
                p2--;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Example 1:
//
//        Input: s = "A man, a plan, a canal: Panama"
//        Output: true
//        Explanation: "amanaplanacanalpanama" is a palindrome.
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));

//                Example 2:
//
//        Input: s = "race a car"
//        Output: false
//        Explanation: "raceacar" is not a palindrome.
        System.out.println(solution.isPalindrome("race a car"));


//        Example 3:
//
//        Input: s = " "
//        Output: true
//        Explanation: s is an empty string "" after removing non-alphanumeric characters.
//                Since an empty string reads the same forward and backward, it is a palindrome.
        System.out.println(solution.isPalindrome(" "));
    }
}

