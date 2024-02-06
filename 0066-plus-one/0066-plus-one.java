class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        digits[i]++;
        while (digits[i] >= 10){
            digits[i] = 0;
            i--;
            if (i < 0){
                int[] newDigits = new int[digits.length+1];
                newDigits[0] = 1;
                for (int j = 1; j < newDigits.length; j++){
                    System.out.println("J: "+ j);
                    newDigits[j] = digits[j-1];
                }
                return newDigits;
            }
            else{
                digits[i]++;
            }
        }
        return digits;
    }
}