class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer, Integer> map = new HashMap <> ();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0)+1);
        List <Map.Entry<Integer, Integer>> list = new ArrayList (map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int [] result = new int[k];
        int i = 0;

        for(Map.Entry <Integer, Integer> entry : list){
            result[i++] = entry.getKey();
            if(i == k) break;
        }

        return result;
    }
}
