class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if(length == 0) return 0;
        if(length == 1) return 1;

        int maxLength = 0;
        HashSet <Character> tracker = new HashSet <> ();
        int l = 0;


        for(int r = 0 ; r < length ; r++){
            while(tracker.contains(s.charAt(r))){
                tracker.remove(s.charAt(l));
                l++;
            }

            tracker.add(s.charAt(r));
            maxLength = Math.max(maxLength, r-l+1);
        }


        return maxLength;
    }
}
