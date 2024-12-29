class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) { // empty array
            return "";
        }
        Arrays.sort(strs);// sort by string
        String first = strs[0];
        String last = strs[strs.length - 1];
        int prefixIdx = 0;
        if (first == null) {
            return "";
        }
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) == last.charAt(i)) {
                prefixIdx++;
                continue;
            }
            break;
        }
        return prefixIdx == 0 ? "" : first.substring(0, prefixIdx);
    }
}