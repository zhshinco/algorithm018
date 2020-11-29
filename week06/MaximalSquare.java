public class MaximalSquare {
public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        /** 
         状态转移方程：1,dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]) + 1;
         或者：2,dp[i][j] = 1
         1,2两种条件都必须满足matrix[i][j] == '1'
        */

        int M = matrix.length, N = matrix[0].length;
        int[][] dp = new int[M][N];
        int max = 0;
        for(int i=0;i<M;i++){
            if(matrix[i][0] == '1') {
                dp[i][0] = 1;
                if(max == 0) max = 1;
            }
        }

        for(int j=0;j<N;j++){
            if(matrix[0][j] == '1') {
                dp[0][j] = 1;
                if(max == 0) max = 1;
            }
        }

        for(int i=1;i<M;i++){
            for(int j=1;j<N;j++){
                if(matrix[i][j] == '1') {
                    if (dp[i - 1][j] != 0 && dp[i][j - 1] != 0 && dp[i-1][j-1] != 0){
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                    }else{
                        dp[i][j] = 1;
                    }
                    max = Math.max(max,dp[i][j] * dp[i][j]);
                }
            }
        }
        return max;
    }
}