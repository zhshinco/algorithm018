public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(s.length() == 0 || p.length() == 0)
            return ans;
        int[] dict = new int[26];
        for(int i = 0;i<p.length();i++){
            dict[p.charAt(i)-'a'] += 1;
        }

        int[] window = new int[26];
        int left = 0;
        int right = 0;
        while(right<s.length()){
            int curR = s.charAt(right)-'a';
            right++;
            window[curR] += 1;
            while(window[curR] > dict[curR]){
                int curL = s.charAt(left)-'a';
                window[curL] -= 1;
                left++;
            }
            if(right - left == p.length()){
                ans.add(left);
            }
        }
        return ans;
    }
}