public class ListNode<next> {
   public Product product;
    public ListNode head;
    ListNode  next, prev;



    public ListNode(Product product) {
        this.product=product;
        this.next=prev=null;

    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    int soLuong(){
        return product.soLuong;
    }

    public boolean timKiemId(int id){
        return this.product.getId()==id;
    }


    public boolean timKiemId2(int id){
        return this.product.getId()!=id;
    }

    public ListNode() {

    }
    public void hienThi(){
       System.out.print(product.id+"    " +product.tenSanPham+"         "+product.giaCach+"          "+product.soLuong);
       System.out.println();
    //  return product.id+"    " +product.tenSanPham+"         "+product.giaCach+"          "+product.soLuong;
//return product.toString();
    }
    public String printData2(){
       return product.id+"|"+product.tenSanPham+"|"+product.giaCach+"|"+product.soLuong;

    }
    public void printData(){
       System.out.println(product.toString());

    }

}

