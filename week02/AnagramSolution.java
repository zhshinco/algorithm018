public class AnagramSolution {
    public boolean isAnagram1(String s, String t) {
        if(s == null ||  t == null){
            return false;
        }

        char[] schars = s.toCharArray();
        Arrays.sort(schars);
        s = new String(schars);

        char[] tchars = t.toCharArray();
        Arrays.sort(tchars);
        t = new String(tchars);

        return s.equals(t);
    }

    public boolean isAnagram2(String s, String t) {
        if(s == null ||  t == null ){
            return false;
        }

        int[] schars = new int[26];
        int[] tchars = new int[26];
        for(int i=0;i<s.length();i++){
            schars[s.charAt(i) - 'a'] += 1;
        }
        for(int i=0;i<t.length();i++){
            tchars[t.charAt(i) - 'a'] += 1;
        }
        for(int i=0;i<26;i++){
            if(schars[i] != tchars[i]){
                return false;
            }
        }
        return true;
    }
}