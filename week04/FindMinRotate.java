public class FindMinRotate {

    public int findMin(int[] nums) {

        if(nums == null || nums.length == 0)
            return 0;

        if(nums.length == 1){
            return nums[0];
        }

        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;


        return subFindMin(nums,low,mid) > subFindMin(nums,mid+1,high) ? subFindMin(nums,mid+1,high) : subFindMin(nums,low,mid);
    }

    private int subFindMin(int[] nums, int low, int high) {
        if(low == high || nums[low] < nums[high])
            return nums[low];

        int mid = (low + high) / 2;
        return subFindMin(nums,low,mid) > subFindMin(nums,mid+1,high) ? subFindMin(nums,mid+1,high) : subFindMin(nums,low,mid);
    }
}
