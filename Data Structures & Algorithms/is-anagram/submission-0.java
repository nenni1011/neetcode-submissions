class Solution {
    public boolean isAnagram(String s, String t) {
        int [] lenofS = new int [26];
        int [] lenofT = new int [26];
        Arrays.fill(lenofS, 0);
        Arrays.fill(lenofT, 0);
        for(int i = 0 ; i < s.length() ; i++){
            int existing = lenofS[(s.charAt(i)-97)];
            lenofS[(s.charAt(i)-97)] = existing+1;
        }

        for(int i = 0 ; i < t.length() ; i++){
            int existing = lenofT[(t.charAt(i)-97)];
            lenofT[(t.charAt(i)-97)] = existing+1;
        }

        for(int i = 0 ; i < 26 ; i++) if(lenofS[i] != lenofT[i]) return false;

        return true;

    }
}
