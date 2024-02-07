class Solution {
    public String addBinary(String a, String b) {
        // StringBuilder to build the result
        StringBuilder result = new StringBuilder();
        // Start from the end of both strings
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        // Carry for bits addition
        int carry = 0;
        
        while (i >= 0 || j >= 0) {
            // Sum of two bits
            int sum = carry;
            
            if (i >= 0) sum += a.charAt(i--) - '0'; // Convert char to int and add to sum
            if (j >= 0) sum += b.charAt(j--) - '0'; // Convert char to int and add to sum
            
            // If sum is 2 or 3, we have a carry
            carry = sum > 1 ? 1 : 0;
            
            // Append the result of sum % 2 to the result string
            result.append(sum % 2);
        }
        
        // If there is a carry left, append it to the result
        if (carry != 0) result.append(carry);
        
        // Reverse the result (since we've been adding digits in reverse order) and return it
        return result.reverse().toString();
    }
}