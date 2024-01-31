import java.util.*;

class Solution {
    public long flowerGame(int n, int m) {
        long evenX = n / 2; // Count of even numbers in range [1, n]
        long oddX = n - evenX; // Count of odd numbers in range [1, n]
        long evenY = m / 2; // Count of even numbers in range [1, m]
        long oddY = m - evenY; // Count of odd numbers in range [1, m]

        // Alice wins if one number is odd and the other is even
        return oddX * evenY + evenX * oddY;
    }
}