class Solution {
    public boolean isPowerOfTwo(int n) {
        long num = 1;

        for (int i = 0; i < 32; i++){
            if (num == n){
                return true;
            }
            num *= 2;
        }

        return false;


    }
}