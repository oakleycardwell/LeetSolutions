class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> returnRanges = new ArrayList<String>();
        if (nums.length == 0)
            return returnRanges;
        else if (nums.length == 1){
            returnRanges.add(""+nums[0]);
            return returnRanges;
        }

        int firstNum = nums[0];
        int previousNum = nums[0];
        int rangeLength = 1;
        int currentNum = 0; 

        for (int i = 1; i < nums.length; i++){
           currentNum = nums[i]; 
            if (currentNum != previousNum + 1){
                if (rangeLength > 1){
                    returnRanges.add(firstNum + "->" + previousNum);
                }
                else{
                    returnRanges.add(""+firstNum);
                }
                firstNum = currentNum;
                rangeLength = 0;
            }
            rangeLength++;
            previousNum = currentNum;

        }
        if (currentNum != previousNum + 1){
                if (rangeLength > 1){
                    returnRanges.add(firstNum + "->" + previousNum);
                }
                else{
                    returnRanges.add(""+firstNum);
                }
                firstNum = currentNum;
                rangeLength = 0;
            }
        return returnRanges;
    }
}