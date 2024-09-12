package Solutions.pack5_new;


public class MyStackL {
    private Node top;

    public MyStackL() {
        top = null;
    }

    public void push(String d) {
        Node p = new Node(d);
        p.next = top;
        top = p;

    }

    public String pop() {
        String d = top.value;
        top = top.next;
        return d;
    }

    public String peek() {
        String d = top.value;
        return d;
    }
    public boolean isEmpty(){
        return  top==null ;
    }
    public boolean isFull() {
        return false;
    }

    public class Node {
        String value;
        Node next;

        public Node(String d) {
            value = d;
            next = null;
        }
    }
}
