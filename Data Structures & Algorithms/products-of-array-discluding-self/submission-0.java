class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int [] leftProduct = new int [len];
        int [] rightProduct = new int [len];

        leftProduct[0] = 1;
        rightProduct[len-1] = 1;

        for(int i = 1 ; i < len ; i++) leftProduct[i] = leftProduct[i-1] * nums[i-1];
        
        for(int i = len-2 ; i >= 0 ; i--) rightProduct[i] = rightProduct[i+1] * nums[i+1];

        int [] result = new int [len];

        for(int i = 0 ; i < len ; i++) result[i] = leftProduct[i] * rightProduct[i];

        return result;
    }
}  
