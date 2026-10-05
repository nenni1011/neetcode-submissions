class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List <List<String>> result = new ArrayList <List<String>> ();
        HashMap <String, ArrayList<Integer>> map = new HashMap <> ();
        for(int i = 0 ; i < strs.length ; i++){
            String anagramString = prepareAnagramString(strs[i]);
            if(map.containsKey(anagramString)){
                ArrayList <Integer> list = map.get(anagramString);
                list.add(i);
                map.put(anagramString, list);
            }else{
                ArrayList <Integer> list = new ArrayList <> ();
                list.add(i);
                map.put(anagramString, list);
            }
        }

        for(Map.Entry <String, ArrayList<Integer>> entry : map.entrySet()){
            ArrayList <Integer> values = entry.getValue();
            List <String> currentAnagramSet = new ArrayList <String> ();
            for(int index : values) currentAnagramSet.add(strs[index]);

            result.add(currentAnagramSet);
        }


        return result;
    }


    public String prepareAnagramString(String str){
        int [] tracker = new int [26];
        Arrays.fill(tracker, 0);

        for(int i = 0 ; i < str.length() ; i++) tracker[str.charAt(i)-97]++;

        String result = "";

        for(int i = 0 ; i < 26 ; i++){
            if(tracker[i] > 0){
                result += ((char) (i+97)) + "" + (tracker[i]);
            }
        }

        return result;
            
    }
}
