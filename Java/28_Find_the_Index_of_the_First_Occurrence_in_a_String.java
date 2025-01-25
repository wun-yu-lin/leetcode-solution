class Solution1 {
    // time complexity O(n * m)
    public int strStr(String haystack, String needle) {
        // for loop in haystack
        for (int i = 0; i < haystack.length(); i++) {
            // for each in needle
            for (int p = 0; p < needle.length(); p++) {
                int idxForHayCompare = i + p;
                if (haystack.length() - 1 < idxForHayCompare) {
                    break;
                }
                if (haystack.charAt(idxForHayCompare) != needle.charAt(p)) {
                    break;
                }
                // full match
                if (p == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

}

class Solution2 {
    // https://yeefun.github.io/kmp-algorithm-for-beginners/
    // KMP algorithm
}