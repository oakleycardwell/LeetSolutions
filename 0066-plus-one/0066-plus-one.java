class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            // Increment the last digit and check if there's a carry
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If the digit is 9, it becomes 0 (carry over to the next significant digit)
            digits[i] = 0;
        }
        
        // If all digits were 9, the code reaches here. Need to add a new digit at the beginning
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        // No need to set other digits to 0 as int arrays are initialized with 0 in Java
        return newDigits;
    }
}