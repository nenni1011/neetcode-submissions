class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int curr = nums[i];
            int start = i + 1;
            int end = len - 1;

            while (start < end) {
                int added = curr + nums[start] + nums[end];
                if (added == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(curr);
                    triplet.add(nums[start]);
                    triplet.add(nums[end]);
                    result.add(triplet);
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    while (start < end && nums[end] == nums[end - 1]) end--;
                    start++;
                    end--;
                } else if (added > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        return result;
    }
}