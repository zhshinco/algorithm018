public class NTreePreorder {
    public List<Integer> preorder(Node root) {
        List<Integer> resList = new ArrayList<>();
        if(root == null){
            return resList;
        }
        resList.add(root.val);
        if(root.children != null && root.children.size() > 0) {
            for(Node childNode : root.children)
                preTravelsNode(resList, childNode);
        }
        return resList;
    }

    private void preTravelsNode(List<Integer> resList, Node node) {
        resList.add(node.val);
        if(node.children != null && node.children.size() > 0) {
            for(Node childNode : node.children)
                preTravelsNode(resList, childNode);
        }
    }
}