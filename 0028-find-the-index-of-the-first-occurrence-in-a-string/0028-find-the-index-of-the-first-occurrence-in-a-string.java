class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++){
            if (haystack.charAt(i) == needle.charAt(0) && (i + needle.length()) <= haystack.length()){
                if (haystack.substring(i, needle.length()+ i).equals(needle))
                    return i;
            }
        }
        return -1;
    }
}