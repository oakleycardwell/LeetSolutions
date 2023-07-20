class Solution {
    public boolean isPalindrome(int x) {
        String forwards = "" + x;
        int len = forwards.length();
        
        int j = len-1;
        for (int i = 0; i < len; i++){
            if (forwards.charAt(i) != forwards.charAt(j))
                return false;
            j--;
        }
        
        return true;
    }
}