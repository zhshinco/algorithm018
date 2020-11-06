public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTreeNode(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    public TreeNode buildTreeNode(int[] preorder, int preorder_l,int preoder_r,int[] inorder,int inorder_l,int inoder_right){
        if(preorder_l == preoder_r){
            return null;
        }

        TreeNode treeNode = new TreeNode();
        treeNode.val = preorder[preorder_l];
        if(inorder_l == inoder_right || preoder_r == preorder_l){
            return treeNode;
        }

        int rootVal = preorder[preorder_l];
        int inorder_root_index = preorder_l;
        for(int i=inorder_l;i<=inoder_right;i++){
            if(inorder[i] == rootVal){
                inorder_root_index = i;
                break;
            }
        }

        //左子树的节点数目
        int leftNum = inorder_root_index - inorder_l;

        //构造左子树
        //前序遍历数组索引从原来的  preorder_l + 1开始取，最多取到preorder_l + leftNum + 1(长度位leftNum)
        //中序遍历从inorder_l开始取，最多要比当前根节点在左子树里的索引-1 （长度也是leftNum）
        treeNode.left = buildTreeNode(preorder,preorder_l+1,preorder_l + leftNum + 1,
                inorder,inorder_l,inorder_root_index-1);


        //构造右子树
        //前序遍历数组索引从原来的  preorder_l + leftNum + 1 开始取，可以取到 preoder_r
        // 中序遍历数组的索引从当前根节点在左子树里的索引+1开始取，最多可以取到inoder_right
        treeNode.right = buildTreeNode(preorder,preorder_l + leftNum +1,preoder_r,
                inorder,inorder_root_index+1,inoder_right);

        return treeNode;
    }
}