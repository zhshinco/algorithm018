public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length < 1) return 0;

        int[] dp = new int[nums.length];

        dp[0] = 1;
        int res = 1;
        for(int i = 1;i < nums.length;i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }


        return res;
    }
}