public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";

        for(int k = 0; k < n; k++){
            for(int i = 0; i + k < n; i++){
                int j = i + k;
                if(k == 0){
                    dp[i][j] = true;
                }else if(k == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                }
                if(dp[i][j] && j - i + 1 > ans.length()){
                    ans = s.substring(i,j+1);
                }
            }
        }
        return ans;
    }
}