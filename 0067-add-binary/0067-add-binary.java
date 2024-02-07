class Solution {
    public String addBinary(String a, String b) {
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        String result = "";

        int aValue = 0, bValue = 0, carryOver = 0;
        while (aIndex >= 0 || bIndex >= 0){
            aValue = 0;
            bValue = 0;
            if (aIndex >= 0){
                aValue = a.charAt(aIndex) - '0';
            }
            
            if (bIndex >= 0){
                bValue = b.charAt(bIndex) - '0';
            }
            
            result = (aValue + bValue + carryOver) % 2 + result;
            if ((aValue + bValue + carryOver) >= 2)
                carryOver = 1;
            else
                carryOver = 0;
            
            aIndex--;
            bIndex--;
        }
        if (carryOver != 0)
            result = carryOver + result;
        return result;
    }
}