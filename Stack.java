
public class Stack {
    ListNode head;

    Stack() {
        this.head = null;
    }

    public void push(ListNode node) {
        node.next = this.head;
        this.head = node;

    }

    public ListNode pop() {
        if (this.isEmpty()) {
            System.out.print("Stack rỗng");
            return null;
        }
        ListNode node = this.head;
        this.head = node.next;
        return node;
    }

    public ListNode peek() {
        if (this.isEmpty()) {
            System.out.print("Stack rỗng");
            return null;
        }

        return this.head;
    }

    public boolean isEmpty() {
        return (this.head == null);
    }

    public void print() {
        ListNode node = this.head;
        while (node != null) {
            node.hienThi();
            node = node.next;
        }
    }
}
