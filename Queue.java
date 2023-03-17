public class Queue {
    ListNode head;
    ListNode tail;
    int size;

    public Queue() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void addQueue(ListNode node) {
        if (isEmpty()) {
            this.head = node;
            this.tail = node;
            this.size++;
            return;
        }

        this.tail.next = node;
        this.tail = node;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public void print() {
        ListNode node = this.head;
        while (node != null) {
            node.hienThi();
            node = node.next;
        }
    }
}
