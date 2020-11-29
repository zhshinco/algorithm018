public class NumDecodings {
    int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

        int pre = 1, curr = 1;//dp[-1] = dp[0] = 1
        for (int i = 1; i < s.length(); i++) {
            int tmp = curr;
            if (s.charAt(i) == '0')
                if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2') curr = pre; //dp[i] = dp[i-2]
                else return 0;
            else if (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6'))
                curr = curr + pre;//dp[i] = dp[i-1] + dp[i-2]
            pre = tmp;
        }
        return curr;
    }

}