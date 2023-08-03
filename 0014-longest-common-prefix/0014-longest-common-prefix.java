class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1){
            return strs[0];
        }
        
        String ret = "";
        
        int shortestLength = strs[0].length();
        
        for (int i = 1; i < strs.length; i++){
            if (strs[i].length() < shortestLength)
                shortestLength = strs[i].length();
        }
        
        for (int i = 0; i < shortestLength; i++){
            char prevChar = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++){
                if (strs[j].charAt(i) != prevChar)
                    return ret;
            }
            ret = ret + prevChar;
        }
        
        
        return ret;
    }
}