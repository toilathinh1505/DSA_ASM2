public class Lien_ket_don {
    ListNode head;
    ListNode tail;

    Lien_ket_don() {
        head = tail = null;
    }

    Lien_ket_don(ListNode node) {
        head = tail = node;

    }

    public void addToTail(ListNode headNode, Product value) {
        ListNode newNode = new ListNode(value);


        if (this.head == null) {
            this.head = newNode;
            return;
        }

        //xác định lastNode => lastNode.next=null
        ListNode lastNode = this.head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            //gán next cho lastNode=newNode
        }
        lastNode.next = newNode;
    }


    public void add(ListNode node, int position) {
        if (position < 1) {
            node.next = this.head;
            this.head = node;
        }
        if (this.tail == null) {
            this.tail = node;
        }


    }

    public void sortById(Lien_ket_don list) {

        for (ListNode current = this.head; current != null; current = current.next) {
            for (ListNode nextCurrent = current.next; nextCurrent != null; nextCurrent = nextCurrent.next) {
                int x = current.product.id;
                int y = nextCurrent.product.id;
                if (x > y) {  //nếu id head > head.next sẽ hoán vị trí dữ liệu trong product
                    swap(current, nextCurrent); //hàm hoán dữ liệu product
                }

            }

        }
    }

    //hàm hoán dữ liệu product
    public void swap(ListNode<Product> firstNode, ListNode<Product> secondNode) {
        Product data = new Product();
        data.id = firstNode.product.id;
        data.tenSanPham = firstNode.product.tenSanPham;
        data.soLuong = firstNode.product.soLuong;
        data.giaCach = firstNode.product.giaCach;

        firstNode.product.id = secondNode.product.id;
        firstNode.product.tenSanPham = secondNode.product.tenSanPham;
        firstNode.product.soLuong = secondNode.product.soLuong;
        firstNode.product.giaCach = secondNode.product.giaCach;

        secondNode.product.id = data.id;
        secondNode.product.tenSanPham = data.tenSanPham;
        secondNode.product.soLuong = data.soLuong;
        secondNode.product.giaCach = data.giaCach;


    }
    public  void removeHead(){
        this.head=this.head.next;
    }
// kiểm tra xem những phần tử còn lại trong danh sách liên kết có chứa key cần xoá hay không
    private boolean isUniqueInRange(ListNode cur, int data) {
        if (cur == null)
            return false;
        while (cur.getNext() != null) {
            if (cur.getNext().product.id==data)
                return true;
            cur = cur.getNext();
        }
        return false;
    }

    public boolean removeAtLast(int key) {
        if (this.head.product.id==key && !this.isUniqueInRange(this.head, key)) {
            this.removeHead();
            return true;
        }

        ListNode cur = this.head;
        while (cur.next != null && cur.product.id==key || this.isUniqueInRange(cur.getNext(), key)) {
            cur = cur.getNext();
        }

        if (cur.getNext() == null)
            return false;

        cur.setNext(cur.getNext().getNext());
        return true;
    }



    void xoa(int id) {  //xóa node theo id
        if (head == null) {
            return;
        }

        ListNode currentNode = this.head;
        ListNode pre = new ListNode<>();

        while (currentNode.next != null) {
            if (currentNode.timKiemId(id)) {

                return;
            }

            pre = currentNode;
            currentNode = currentNode.next;
        }


    }


//    void deleteNode(int key) {
//        ListNode temp = head, prev = null;
//        if (temp != null && temp.timKiemId(key)) {
//            head = temp.next;
//            return;
//        }
//        while (temp != null && temp.timKiemId2(key)) {   //vòng lặp nếu id cần tìm và id trong node khác nhau
//            prev = temp;
//            temp = temp.next;
//        }
//        if (temp == null) return;
//
//        prev.next = temp.next;
//    }

    public ListNode search(int id) {
        ListNode curentNode = this.head;
        while (curentNode != null) {
            if (curentNode.timKiemId(id)) {  //hàm tìm kiếm id cần tìm và id trong node giống nhau
                return curentNode;
            }
            curentNode = curentNode.next;
        }

        return null;
    }


    public void printList() {
        System.out.println("ID |  Title   | Quantity | price");
        ListNode curentNode = this.head;
        while (curentNode != null) {
            curentNode.printData();
            curentNode = curentNode.next;
        }

    }



    void sort(ListNode start, ListNode end) {
        if (start == null || start == end || start == end.next)
            return;


        ListNode pivot_prev = paritionLast(start, end);
        sort(start, pivot_prev);


        if (pivot_prev != null && pivot_prev == start)
            sort(pivot_prev.next, end);


        else if (pivot_prev != null
                && pivot_prev.next != null)
            sort(pivot_prev.next.next, end);
    }


    ListNode paritionLast(ListNode start, ListNode end) {
        if (start == end || start == null || end == null)
            return start;

        ListNode pivot_prev = start;
        ListNode curr = start;
        Product pivot = end.product;

        while (start != end) {
            if (start.product.id < end.product.id) {

                pivot_prev = curr;
                Product temp = curr.product;
                curr.product = start.product;
                start.product = temp;
                curr = curr.next;
            }
            start = start.next;
        }
        Product temp = curr.product;
        curr.product = pivot;
        end.product = temp;

        return pivot_prev;
    }

    public int soLuong() {
        ListNode curentNode = this.head;
        return curentNode.soLuong();
    }
}
