class Solution {
    public int longestConsecutive(int[] nums) {
        int maxConsecutive = 0;

        HashSet <Integer> tracker = new HashSet <> ();
        for(int num : nums) tracker.add(num);

        for(int i = 0 ; i < nums.length ; i++){
            if(tracker.contains(nums[i]-1)) continue;

            int curr = nums[i];
            int currConsecutive = 0;

            while(tracker.contains(curr)){
                currConsecutive++;
                curr++;
            }

            maxConsecutive = Math.max(maxConsecutive, currConsecutive);

        }

        return maxConsecutive;
    }
}
