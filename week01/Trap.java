public class Trap {
    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
           while(!stack.isEmpty() && height[current] > height[stack.peek()]){
               int top = stack.pop();
               if(stack.isEmpty())
                   break;
               int recHeight = Math.min(height[current],height[stack.peek()]) - height[top];
               sum += recHeight * (current - stack.peek() - 1);
           }
           stack.push(current);
           current++;
        }
        return sum;
    }
}