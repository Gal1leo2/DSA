package Solutions.pack4_linkedlist;

public class MyLinkedListTricky extends MyLinkedList {
    private Node rev(Node node) {
        Node prev = null;
        Node cure = node;
        Node next = null;
        while (cure != null) {
            next = cure.next;
            cure.next = prev;
            prev = cure;
            cure = next;
        }
        return prev;
    }
    public void q1_rotate_clockwise(int k) {
        if (head == null || k <= 0) return;
        Node cure = head;
        int length = 1;
        while (cure.next != null) {
            cure = cure.next;
            length++;
        }
        k = k % length;
        if (k == 0) return;

        cure.next = head;

        Node newTail = head;
        for (int i = 1; i < length - k; i++) {
            newTail = newTail.next;
        }

        head = newTail.next;
        newTail.next = null;
    }

    public void q2_reverse() {
        head = rev(head);
    }
    public void q3_remove_dup() {
        if (head == null) return;

        Node cure = head;
        while (cure != null && cure.next != null) {
            Node runner = cure;
            while (runner.next != null) {
                if (runner.next.data == cure.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            cure = cure.next;
        }
    }

    public void q4_add_one() {
        head = rev(head);

        Node cure = head;
        int carry = 1;
        while (cure != null) {
            int sum = cure.data + carry;
            cure.data = sum % 10;
            carry = sum / 10;
            if (carry == 0) break;
            if (cure.next == null && carry > 0) {
                cure.next = new Node(carry);
                carry = 0;
            }
            cure = cure.next;
        }
        head = rev(head);
    }

    public boolean q5_isPalindrome() {
        Node slow = head, fast = head;
        Node prev = null;
        Node current = slow;
        Node next = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        Node fh = head, sh = prev;
        while (sh != null) {
            if (fh.data != sh.data) {
                return false;
            }
            fh = fh.next;
            sh = sh.next;
        }
        return true;
    }
}
