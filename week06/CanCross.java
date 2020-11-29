public class CanCross {

    public boolean canCross(int[] stones) {
        /*
         状态转移方程：dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1]
        */
        int len = stones.length;

        if(stones[1] != 1){
            return false;
        }

        boolean[][] dp = new boolean[len][len + 1];
        dp[0][0] = true;
        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                int k = stones[i] - stones[j];
                // 根据从第0个单元到第1个单元，可以判断k<=j+1或者k<=i
                if(k <= j + 1){
                    dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                    //提前结束循环直接返回结果
                    if(i == len - 1 && dp[i][k]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}