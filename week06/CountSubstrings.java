public class CountSubstrings {
    /**
    状态转移方程：dp[i][j] = dp[i+1][j-1],同时 s[i] = s[j], j - 2 < 2
     */

    public int countSubstrings(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }

        return ans;
    }
}