package Solutions.pack10_bst;

public class TreeNode {
        int data;
        TreeNode left, right, parent;

        public TreeNode(int d) {
            data = d;
        }
    
    @Override
    public String toString() {
        if(left==null&&right==null) return "null<-"+data+"->null";
        if(left==null) return "null<-"+data+"->"+right.data;
        if(right==null) return left.data+"<-"+data+"->null";
        return left.data + "<-" + data + "->" + right.data;
    }
}