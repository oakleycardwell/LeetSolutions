class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        int[] prefixProducts = new int[len];
        prefixProducts[0] = 1;
        for (int i = 1; i < len; i++) {
            prefixProducts[i] = prefixProducts[i - 1] * nums[i - 1];
        }

        int suffixProduct = 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] = prefixProducts[i] * suffixProduct;
            suffixProduct *= nums[i];
        }

        return result;
    }
}