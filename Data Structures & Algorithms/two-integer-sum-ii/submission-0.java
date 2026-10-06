class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int start = 0;
        int end = len-1;
        int [] result = new int [2];
        result[0] = -1;
        result[1] = -1;

        while(start < end){
            int currentPairSum = numbers[start] + numbers[end];
            if(currentPairSum == target){
                result[0] = start+1;
                result[1] = end+1;
                break;
            }else if(currentPairSum < target){
                start++;
            }else{
                end--;
            }
        }

        return result;
    }
}
