public class Product {
    int id;
    String tenSanPham;
    int giaCach;
    int soLuong;


    public Product(int id, String tenSanPham, int giaCach, int soLuong){
        this.id=id;
        this.tenSanPham=tenSanPham;
        this.giaCach=giaCach;
        this.soLuong=soLuong;
    }

    @Override
    public String toString() {
        return
                 id +
                "      " + tenSanPham + "      " +
                "      " + giaCach +
                "        " + soLuong +
                ' ';
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}