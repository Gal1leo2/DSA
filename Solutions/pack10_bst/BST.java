package Solutions.pack10_bst;

public class BST {
    TreeNode root;

    public BST() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }
    //My code
    public void printInOrder() {
        printInOrderRecurse(root);
        System.out.println();
    }

    private void printInOrderRecurse(TreeNode node) {
        if (node == null)
            return;
        printInOrderRecurse(node.left);
        System.out.print(node.data + " ");
        printInOrderRecurse(node.right);
    }

}
