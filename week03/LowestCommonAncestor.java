public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);

        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null) //p,q,节点都不在左子树中
            return right;
        if(right == null) //p,q节点都不在右子树中
            return left;
        return root; //p,g节点在左右树各自存在
    }
}