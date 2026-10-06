class Solution {
    public boolean isPalindrome(String s) {
        s = sanitizeString(s);
        int len = s.length();
        int start = 0;
        int end = len-1;

        while(start <= end){
            char left = s.charAt(start);
            char right = s.charAt(end);
            if(left != right) return false;
            start++;
            end--;
        }


        return true;
    }

    public String sanitizeString(String s){
        String result = s.replaceAll("[^a-zA-Z0-9]", "");
        return result.toLowerCase();
    }
}
