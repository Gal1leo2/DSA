package Solutions.pack10_bst;

public class BST {
    TreeNode root;

    public BST() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

   public void insert(int d) {
        if(root == null) {
        
        root = new TreeNode(d);
        return;
        
        }
        TreeNode cur = root; /*เริ�ม search หาตําแหน่ง*/
        while (cur != null) {
            if (d < cur.data) {
                if (cur.left != null){
                cur = cur.left;
             } else {
            cur.left = new TreeNode(d);
            cur.left.parent = cur;
        return;
             }
        } else { //! (d < p.data)
            if (cur.right != null){
                cur = cur.right;
            } else {
                cur.right = new TreeNode(d);
                cur.right.parent = cur;
                return;
                }
            }
        }
    } //while
    public void delete(int d){
        delete(d,root);
    }

    void delete(int d,TreeNode cur){
        if(cur == null) return;
        if(d<cur.data) delete(d, cur.left);
        else if(d>cur.data) delete(d, cur.right);
            else {
            if(cur.left==null || cur.right==null){
                TreeNode q = (cur.left==null)?cur.right : cur.left;
            
                if(cur.parent.left ==cur) cur.parent.left = q;
            else cur.parent.right = q;
            if(q!=null)q.parent = cur.parent;

            }

            else{
                TreeNode q = findMaxFrom(cur);
                delete(q.data, cur.left);
                if(cur.parent.left == cur) cur.parent.left = q;
                else cur.parent.right = q;

                q.left = cur.left;
                q.right = cur.right;
                q.parent = cur.parent;
                }
            }
        }
    
    public TreeNode findMaxFrom(TreeNode toBeDelete){
        TreeNode cur = toBeDelete.left;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur;
    }

    public TreeNode search(int d){
        return searchRecurse(d, root);
    }

    public TreeNode searchRecurse(int d,TreeNode n) {
        if(n==null) return null;
        if(d==n.data) return n;
        if(d>n.data) return searchRecurse(d,n.right);
        else return searchRecurse(d,n.left);
     }

    public TreeNode findMax(){
        return maxNode(root);
    } 
    public TreeNode maxNode(TreeNode n){
        TreeNode cur = n;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur;
    }
    public TreeNode findMin(){
        return minNode(root);
    } 
    public TreeNode minNode(TreeNode n){
        TreeNode cur = n;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }
    public int findMedian() {
        int count = count(); 
        if (count == 0) {
            throw new IllegalArgumentException("Tree is empty");
        }

        if (count % 2 == 1) {
            return findKHelp(root, count / 2 + 1); 
        } else {
            int leftMiddle = findKHelp(root, count / 2);     
            int rightMiddle = findKHelp(root, count / 2 + 1); 
            return (leftMiddle + rightMiddle) / 2;         
        }
    }

    public int findRank(int num) {
        return findRank(root, num);
    }

    private int findRank(TreeNode node, int num) {
        if (node == null) {
            return 0;
        }

        if (num < node.data) {
            return findRank(node.left, num);  
        } else if (num == node.data) {
            return countRecurse(node.left) + 1; 
        } else {
            return countRecurse(node.left) + 1 + findRank(node.right, num); 
        }
    }
    private int findKHelp(TreeNode node, int k) {
        int leftCount = countRecurse(node.left);

        if (k <= leftCount) {
            return findKHelp(node.left, k);   
        } else if (k == leftCount + 1) {
            return node.data;               
        } else {
            return findKHelp(node.right, k - leftCount - 1);  
        }
    }

    public int height(){
        return findHeight(root);
    }
    public int findHeight(TreeNode n){
        if(n == null) return 0;

        int leftheight = findHeight(n.left);
        int rightheight = findHeight(n.right);

        return 1+Math.max(leftheight,rightheight);
    }
    public int count(){
        return countRecurse(root);
    }
    public int countRecurse(TreeNode n){
        if(n==null) return 0;
        return 1+countRecurse(n.left)+countRecurse(n.right);
    }
    public void printPostOrder(){
        printPostOrder(root);
    }
    public void printPostOrder(TreeNode node) {
        if(node==null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.println(node.data+" ");
    }

    public void printPreOrder(){
        printPreOrder(root);
    }
    void printPreOrder(TreeNode node) {
        if(node==null) return;
        System.out.println(node.data+" ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

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
