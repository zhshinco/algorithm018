public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs){
        if(strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String,List<String>> ans = new HashMap<>();
        for(String str : strs){
            int[] count = new int[26];
            for(int i = 0; i < str.length(); i++){
                count[str.charAt(i) - 'a'] += 1;
            }

            StringBuilder sb = new StringBuilder("#");
            for( int i = 0; i < 26; i++){
                sb.append(count[i]);
                sb.append("#");
            }
           ;
            String key = sb.toString();
            List<String> anaList = ans.get(key);
            if(anaList == null){
                anaList = new ArrayList<>();
                ans.put(key,anaList);
            }
            anaList.add(str);
        }
        return  new ArrayList<>(ans.values());
    }
}
