package Solutions.pack4_linkedlist;

public class MyLinkedList {
    public class Node {
        int data;
        Node next;

        public Node(int d) {
        data = d;
    }
}
    Node head = null;

    public int getAt(int i) {
        Node p = head;
        while(i>0) {
            p = p.next;
            i--;
        }
        return p.data;
        }
        public void setAt(int d, int i) {
        Node p = head;
        while(i>0) {
            p = p.next;
            i--;
        }
        p.data = d;
        }

    public void add(int d) {
        Node p = new Node(d);
        p.next = head;
        head = p;
    }
    public void insert(int d, Node p) {
        if (p == null) return;
        Node q = new Node(d);
        q.next = p.next;
        p.next = q;
    }
    public void insert(int d) {
        Node newNode = new Node(d);

        if (head == null) {
            head = newNode;
            return;
        }
        if (d <= head.data) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node p = head;
        while (p.next != null && p.next.data < d) {
            p = p.next;
        }
        // Insert the new node
        newNode.next = p.next;
        p.next = newNode;
    }

    public void delete(Node p) {
        p.next = p.next.next;
    }
    public int find(int d) {
        Node p = head;
        int index = 0;
        while (p != null) {
            if (p.data == d) {
                return index;
            }
            p = p.next;
            index++;
        }
        return -1;
    }
    public void delete(int d) {
        Node t = new Node(0);
        t.next = head;
        Node p = t;
        while ((p.next != null) && (p.next.data != d)) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
        }
        head = t.next;
    }
    public void add(int[] d) {
        for (int i = d.length - 1; i >= 0; i--) {
            add(d[i]);
        }
    }

    public void insert(int[] d) {
        for (int i = 0; i < d.length; i++) {
            insert(d[i]);
        }
    }
    public int size() {
        int length = 0;
        Node p = head;

        while (p != null) {
            length++;
            p = p.next;
        }
        return length;
    }
    public String toString() {
        StringBuffer sb = new StringBuffer("head ");
        Node p = head;
        while(p!=null) {
            sb.append("--> [");
            sb.append(p.data);
            sb.append("] ");
            p = p.next;
        }
        sb.append("-> null");
        return new String(sb);
        }
}