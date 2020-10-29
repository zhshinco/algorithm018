public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ret = new int[k];

        Map<Integer,Integer> countMap = new HashMap<>();
        for(int i : nums){
            countMap.put(i,countMap.getOrDefault(i,0)+1);
        }

        PriorityQueue<int []> minHeap = new PriorityQueue<int []>(new Comparator<int[]>() {
            @Override
            public int compare(int[] start, int[] end) {
                return start[1] - end[1];
            }
        });

        Set<Integer> keySet = countMap.keySet();
        for(Integer num : keySet){
            int count = countMap.get(num);
            if(minHeap.size() < k){
                minHeap.add(new int[]{num,count});
            }else{
                if(minHeap.peek()[1] < count){
                    minHeap.poll();
                    minHeap.add(new int[]{num,count});
                }
            }
        }

        for(int i=0;i<k;i++){
            ret[i] = minHeap.poll()[0];
        }
        return ret;
    }
}