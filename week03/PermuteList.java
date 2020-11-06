public class PermuteList {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        if(nums == null || nums.length == 0){
            ansList.add(new ArrayList<Integer>());
            return ansList;
        }

        int len = nums.length;
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, new ArrayList<Integer>(), used, ansList);

        return ansList;
    }

    private void dfs(int[] nums, int len, int depth, ArrayList<Integer> perList, boolean[] used, List<List<Integer>> ansList) {
        if(depth == len){
            ansList.add(new ArrayList<>(perList));
            return;
        }

        for(int i=0;i<len;i++){
            if(!used[i]){
                used[i] = true;
                perList.add(nums[i]);
                dfs(nums, len, depth+1, perList, used, ansList);
                used[i] = false;
                perList.remove(perList.size() - 1);
            }
        }
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        if(nums == null || nums.length == 0){
            ansList.add(new ArrayList<Integer>());
            return ansList;
        }

        int len = nums.length;
        boolean[] used = new boolean[len];

        dfsUnique(nums, len, 0, new ArrayList<Integer>(), used,ansList);

        return ansList;
    }

    private void dfsUnique(int[] nums, int len, int depth, ArrayList<Integer> perList, boolean[] used,
                            List<List<Integer>> ansList) {
        if(depth == len){
            ansList.add(new ArrayList<>(perList));
            return;
        }

        Set<Integer> usedSet = new HashSet<Integer>();

        for(int i=0;i<len;i++){
            if(!used[i] && !usedSet.contains(nums[i])){
                used[i] = true;
                perList.add(nums[i]);
                dfsUnique(nums, len, depth+1, perList, used,ansList);
                used[i] = false;
                perList.remove(perList.size() - 1);

                usedSet.add(nums[i]);
            }
        }
    }
}
