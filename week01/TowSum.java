public class TowSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2){
            return new int[0];
        }

        Map<Integer,Integer> indexMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(indexMap.get(target - nums[i]) != null){
                return new int[]{indexMap.get(target - nums[i]),i};
            }
            indexMap.put(nums[i],i);
        }
        
        return new int[0];
    }
}