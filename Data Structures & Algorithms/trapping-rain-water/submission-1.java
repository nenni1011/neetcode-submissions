class Solution {
    public int trap(int[] height) {
        int len = height.length;
        if (len < 3) return 0;

        int i = 0;
        int totalAmountCanStore = 0;

        while(i < len-2){
            if(height[i] == 0){
                i++;
                continue;
            }

            int rightIndex = findRightIndex(i, height);
            if(rightIndex == -1) break;

            int currentAmount = calculateAmountBetweenWalls(i, rightIndex, height);

            totalAmountCanStore += currentAmount;

            i = rightIndex;
        }


        return totalAmountCanStore;
    }

    public int findRightIndex(int currentIndex, int [] height){
         // Case 1:
        // Find the first wall that is >= current wall.
        for (int i = currentIndex + 1; i < height.length; i++) {
            if (height[i] >= height[currentIndex]) {
                return i;
            }
        }

        // Case 2:
        // No wall >= current wall.
        // Find the highest wall on the right.
        int rightIndex = -1;
        int maxHeight = 0;

        for (int i = currentIndex + 1; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                rightIndex = i;
            }
        }

        return rightIndex;
    }

    public int calculateAmountBetweenWalls(int leftIndex, int rightIndex, int [] height){
        int minHeight = Math.min(height[leftIndex], height[rightIndex]);
        int noOfPlacesInBetween = (rightIndex-leftIndex)-1;
        int maxAmountCanOccupy = noOfPlacesInBetween * minHeight;
        int amountOfBlocksInBetween = 0;
        for(int i = leftIndex+1 ; i < rightIndex ; i++){
            amountOfBlocksInBetween += height[i];
        }

        int currentAmountCanOccupy = maxAmountCanOccupy - amountOfBlocksInBetween;
        return currentAmountCanOccupy;
    }
}
