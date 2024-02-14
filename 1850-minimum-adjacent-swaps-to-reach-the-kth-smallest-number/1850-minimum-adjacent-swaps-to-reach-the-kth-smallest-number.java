class Solution {
    public int getMinSwaps(String num, int k) {
        char[] chars = num.toCharArray();
        // Create kth permutation
        for (int i = 0; i < k; i++) {
            getNextPermutation(chars);
        }
        // Calculate minimum swaps to reach permutation
        return minSwaps(num.toCharArray(), chars);
    }
    
    // Switches to next lexicographical permutation
    private void getNextPermutation(char[] array) {
        int i = array.length - 2;
        while (i > 0 && array[i] >= array[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = array.length - 1;
            while (array[j] <= array[i]) {
                j--;
            }
            swapNums(array, i, j);
        }
        reverse(array, i + 1, array.length - 1);
    }

    // Swaps i and j
    private void swapNums(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Reverses subsection from start to end
    private void reverse(char[] array, int start, int end) {
        while (start < end) {
            swapNums(array, start++, end--);
        }
    }
    
    // Calculates min swaps from original array to target
    private int minSwaps(char[] original, char[] target) {
        int swaps = 0;
        for (int i = 0; i < original.length; i++) {
            if (original[i] != target[i]) {
                int j = i;
                while (original[j] != target[i]) {
                    j++;
                }
                while (j > i) {
                    swapNums(original, j, j - 1);
                    j--;
                    swaps++;
                }
            }
        }
        return swaps;
    }
}