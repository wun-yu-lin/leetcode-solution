class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (Character.isLetterOrDigit(temp)) {
                sb.append(s.charAt(i));
            }
        }
        s = sb.toString();
        if (s.isEmpty()) {
            return true;
        }
        int p2 = s.length() - 1;
        for (int p1 = 0; p1 <= s.length(); p1++) {
            if (s.charAt(p1) != s.charAt(p2)) {
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