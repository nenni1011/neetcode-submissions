class Solution {
    public int maxArea(int[] heights) {
        int len = heights.length;
        int start = 0;
        int end = len-1;
        int maxAmountOfWater = 0;

        while(start < end){
            int currentAmount = amount(start, end, heights);
            maxAmountOfWater = Math.max(maxAmountOfWater, currentAmount);

            if(heights[start] < heights[end]){
                start++;
            }else if(heights[start] > heights[end]){
                end--;
            }else{
                start++;
                end--;
            }
        }


        return maxAmountOfWater;
    }


    public int amount(int leftIndex, int rightIndex, int [] heights){
        int minimumBar = Math.min(heights[leftIndex], heights[rightIndex]);
        int noOfUnits = rightIndex-leftIndex;
        return minimumBar*noOfUnits;
    }
}
