public class TreeMidorder {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if(root == null)
            return resList;

        midTravel(resList,root.left);
        resList.add(root.val);
        midTravel(resList,root.right);

        return resList;
    }

    private void midTravel(List<Integer> resList, TreeNode node) {
        if(node != null){
            midTravel(resList,node.left);
            resList.add(node.val);
            midTravel(resList,node.right);
        }
    }
}
