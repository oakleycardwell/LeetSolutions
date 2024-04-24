class Solution {
    public int minMoves(int[] nums, int k) {
        // List to store indices of '1's in the array
        List<Integer> positionsOfOnes = new ArrayList<>();

        // Collect all positions of '1's
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) {
                positionsOfOnes.add(i);
            }
        }

        // Calculate initial moves needed to align the first k '1's around the median
        final int initialMedian = positionsOfOnes.get(getMedianIndex(0, k));
        int currentMoves = 0;
        for (int i = 0; i < k; ++i) {
            currentMoves += Math.abs(positionsOfOnes.get(i) - initialMedian);
        }

        // Store the minimum moves found starting with the initial configuration
        int minimumMoves = currentMoves;

        // Slide the window of k '1's through the rest of the list, adjusting moves
        for (int i = 1; i <= positionsOfOnes.size() - k; ++i) {
            final int oldMedianIndex = positionsOfOnes.get(getMedianIndex(i - 1, k));
            final int newMedianIndex = positionsOfOnes.get(getMedianIndex(i, k));
            
            // Update moves: Consider the effect of shifting the median
            if (k % 2 == 1) {
                currentMoves += newMedianIndex - oldMedianIndex;
            }
            currentMoves -= newMedianIndex - positionsOfOnes.get(i - 1);
            currentMoves += positionsOfOnes.get(i + k - 1) - newMedianIndex;

            // Update the minimum moves found
            minimumMoves = Math.min(minimumMoves, currentMoves);
        }

        // Subtract the triangular number series sums from the answer for exact count
        return minimumMoves - nthTriangularNumber((k - 1) / 2) - nthTriangularNumber(k / 2);
    }

    // Helper method to get the median index for the window [i, i + k)
    private int getMedianIndex(int i, int k) {
        return (i + (i + k - 1)) / 2;
    }

    // Helper method to calculate the sum of the first n natural numbers: 1 + 2 + ... + n
    private int nthTriangularNumber(int n) {
        return n * (n + 1) / 2;
    }

}