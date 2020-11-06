
public class CombineInt {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> retList = new ArrayList<>();
      getCombine(n, k, 1, new ArrayList<>(),retList);
      return retList;
  }

  public void getCombine(int n, int k, int start, List<Integer> list,List<List<Integer>> retList) {
      if(k == 0) {
          retList.add(new ArrayList<>(list));
          return;
      }
      for(int i = start;i <= n - k + 1;i++) {
          list.add(i);
          getCombine(n, k - 1, i+1, list,retList);
          list.remove(list.size() - 1);//剪枝操作，可以理解为出栈
      }
  }
}