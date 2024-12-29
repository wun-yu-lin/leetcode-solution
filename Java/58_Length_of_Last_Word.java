class Solution {
    public int lengthOfLastWord(String s) {
        String[] subStrList = s.split(" ");
        String lastString = subStrList[subStrList.length - 1].replace(" ", "");
        return lastString.length();
    }
}