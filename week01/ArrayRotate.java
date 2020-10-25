public class ArrayRotate {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;//计数，统计交换的次数
        for(int i=0;count<nums.length;i++){//外循环是交换的轮次
           int current = i;    //当前位置
           int prev = nums[i]; //交换的数字
           //内循环是一轮中需要交换的位置
           do {
               int next = (current + k) % nums.length; //下一个位置
               //两个数字交换位置
               int temp = nums[next];
               nums[next] = prev;
               prev = temp;

               current = next;//更新当前位置
               count ++;
           }while (i != current);//当前一轮交换完毕
        }
    }
}