class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = 0, c = 0;
        
        while (r < matrix.length && target >= matrix[r][c]){
            r++;
        }
        
        if (r > 0)
            r--;
        
        while (c < matrix[r].length){
            if (matrix[r][c] == target)
                return true;
            c++;
        }
        
        return false;
    }
}