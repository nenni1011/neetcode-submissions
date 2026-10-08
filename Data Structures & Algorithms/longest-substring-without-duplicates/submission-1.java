class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if(length == 0) return 0;
        if(length == 1) return 1;

        int maxLength = 0;
        for(int i = 0 ; i < length ; i++){
            HashSet <Character> set = new HashSet <> ();
            int currLen = 1;
            set.add(s.charAt(i));
            for(int j = i+1 ; j < length ; j++){
                char ch = s.charAt(j);
                if(set.contains(ch)) break;
                set.add(s.charAt(j));
                currLen++;
            }
            maxLength = Math.max(maxLength, currLen);
        }
        return maxLength;
    }
}
