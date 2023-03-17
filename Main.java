import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        Lien_ket_don list = new Lien_ket_don();

        int choice;
        while (true) { // tạo ds menu
            String m = menu();
            System.out.print(m);
            writeFile2(m);
            choice = input.nextInt();
            if (choice == 0) {
                System.out.println(" Good bye, have a nice day!");
                break;
            }

            switch (choice) {
                case 1:
                    try {
                        // đọc file và lưu vào list
                        readFile(list, "input.txt");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    while (true) {
                        System.out.print("1. nhập đầu list | 2. nhập đuôi list | 0.thoát ");
                        int chon = input.nextInt();
                        if (chon == 0) {
                            break;
                        }

                        switch (chon) {
                            case 1:
                                // thêm dữ liệu vào node
                                System.out.println("nhập id | nhập tên sp | nhập giá | nhập số lượngv");
                                int id = input.nextInt();
                                String tenSP = input.next();
                                int gia = input.nextInt();
                                int soLuong = input.nextInt();
                                list.add(new ListNode(new Product(id, tenSP, gia, soLuong)), 0);
                                // list.addToTail(new ListNode(new Product(id, tenSP, gia, soLuong)), new
                                // Product(id, tenSP, gia, soLuong));
                                break;

                            case 2:
                                System.out.println("nhập id | nhập tên sp | nhập giá | nhập số lượngv");
                                int id2 = input.nextInt();
                                String tenSP2 = input.next();
                                int gia2 = input.nextInt();
                                int soLuong2 = input.nextInt();
                                // list.add(new ListNode(new Product(id, tenSP, gia, soLuong)),0);
                                list.addToTail(new ListNode(new Product(id2, tenSP2, gia2, soLuong2)),
                                        new Product(id2, tenSP2, gia2, soLuong2));

                        }
                    }

                case 3:
                    // hàm in ra màn hình
                    // list.printList2();
                    list.printList();
                    System.out.println("------------");

                    // Lưu lại tất cả output in ra màn hình

                    try {
                        writeFile(list, "console_output.txt");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
                case 4:
                    // lưu hàm vào file
                    try {
                        writeFile(list, "input.txt");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:

                    System.out.print("nhập số cần tìm: ");
                    int searchId = input.nextInt();
                    ListNode searchNode = list.search(searchId); // tìm id trong list
                    if (searchNode != null) {
                        System.out.print("Id cần tìm: ");
                        searchNode.hienThi();
                    } else {
                        System.out.println("Id không có trong danh sách " + "\n" + "-----------------");
                    }

                    /*
                     * try {
                     * writeFile2(searchNode, "console_output.txt");
                     * } catch (Exception e) {
                     * e.printStackTrace();
                     * }
                     */
                    break;
                case 6:// xóa dữ liệu theo id
                    System.out.print("nhập số id cần xóa: ");
                    int searchIdDele = input.nextInt();
                    list.removeAtLast(searchIdDele);
                    /*
                     * // list.deleteNode(searchIdDele);
                     * list.xoa(searchIdDele);
                     * //list.printList2();
                     * list.printList();
                     */

                    /*
                     * try {
                     * writeFile(list, "console_output.txt");
                     * } catch (Exception e) {
                     * e.printStackTrace();
                     * }
                     */
                    break;
                case 7:// sắp xếp theo id
                    list.sortById(list);
                    System.out.print("đã sắp xếp");

                    /*
                     * try {
                     * writeFile(list, "console_output.txt");
                     * } catch (Exception e) {
                     * e.printStackTrace();
                     * }
                     */
                    break;
                case 8: // lấy dữ liệu node đầu tiên trả về số đếm nhị phân
                    int x = list.soLuong();
                    deQuy(x);

                case 9:
                    Stack stack = new Stack();
                    try {
                        readFileStock(stack, "input.txt");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    stack.print();
                    System.out.println("======lấy 1 node ra===========");
                    stack.pop();
                    stack.print();

                    break;
                case 10:
                    Queue queue = new Queue();
                    try {
                        readFileQueue(queue, "input.txt");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    queue.print();
                    break;
                case 11:
                    try {
                        docFile("console_output.txt");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 12:
                    // sắp xếp quicksort
                    ListNode n = list.head;
                    while (n.next != null)
                        n = n.next;

                    System.out.println("Linked List trước khi sắp xếp");
                    list.printList();

                    list.sort(list.head, n);

                    System.out.println("\nLinked List sau khi sắp xếp");
                    list.printList();

                    try {
                        writeFile(list, "console_output.txt");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

            }
        }

    }

    public static String menu() {
        String i1 = " Choose your option:";
        String i2 = "  1. Đọc dữ liệu có sẵn từ file chứa các sản phẩm rồi lưu vào Linked List";
        String i3 = "  2. Nhập và thêm một sản phẩm vào cuối của danh sách Linked List";
        String i4 = "  3. Hiển thị thông tin của các sản phẩm trong Linked List";
        String i5 = "  4. Lưu danh sách các sản phẩm vào file";
        String i6 = "  5. Tìm kiếm thông tin của sản phẩm theo ID";
        String i7 = "  6. Xóa sản phẩm trong danh sách theo ID";
        String i8 = "  7. Sắp xếp các sản phẩm  trong danh sách theo ID";
        String i9 = "  8. Biểu diễn số lượng sản phẩm (đang ở hệ đếm cơ số 10) của phần tử đầu tiên trong Linked List về hệ đếm nhị phân bằng phương pháp đệ quy.";
        String i10 = "  9. Đọc dữ liệu từ file chứa các sản phẩm rồi lưu vào stack. Liệt kê ra màn hình các sản phẩm có trong stack.";
        String i11 = "  10. Đọc dữ liệu từ file chứa các sản phẩm lưu vào queue. Hiển thị ra màn hình các sản phẩm có trong queue.";
        String i12 = "  11.đọc file";
        String i13 = "  12.QuickSort";
        String i14 = "  0. Exit\n";
        String i15 = "  Your selection (0 -> 8): ";
        return i1 + "\n" + i2 + "\n" + i3 + "\n" + i4 + "\n" + i5 + "\n" + i6
                + "\n" + i7 + "\n" + i8 + "\n" + i9 + "\n" + i10 + "\n" + i11 + "\n" + i12 + "\n" + i13
                + "\n" + i14 + "\n" + i15;
    }

    public static void readFileQueue(Queue queue, String fileName) throws IOException {
        String thisLine;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            while ((thisLine = br.readLine()) != null) {
                String[] info = thisLine.split("\\|");
                Product newProduct = new Product(Integer.parseInt(info[0]), String.valueOf(info[1]),
                        Integer.parseInt(info[2]), Integer.parseInt(info[3]));
                ListNode list = new ListNode(newProduct);

                queue.addQueue(list);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br.readLine() != null) {
                br.close();

            }
        }
    }

    public static void readFileStock(Stack stack, String fileName) throws IOException {
        String thisLine;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            while ((thisLine = br.readLine()) != null) {
                String[] info = thisLine.split("\\|");
                Product newProduct = new Product(Integer.parseInt(info[0]), String.valueOf(info[1]),
                        Integer.parseInt(info[2]), Integer.parseInt(info[3]));
                ListNode list = new ListNode(newProduct);

                stack.push(list);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br.readLine() != null) {
                br.close();

            }
        }

    }

    // trả về hệ đếm nhị phân
    public static void deQuy(int x) {
        if (x == 0) { // điều kiện dừng
            return;
        } else {
            int r = x % 2;
            deQuy(x / 2);
            System.out.print(r);
            try {
                FileOutputStream fo = new FileOutputStream("console_output.txt");
                PrintWriter out = new PrintWriter(fo, true);

                out.println(r); // in dữ liệu vào file

                out.close();
            } catch (Exception e) {
            }
        }

    }

    public static void docFile(String fileName) throws IOException {
        try {
            FileReader fr = new FileReader(fileName);
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // hàm đọc file và lưu vào list
    public static void readFile(Lien_ket_don lkd, String fileName) throws IOException {
        String thisLine;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            while ((thisLine = br.readLine()) != null) {
                String[] info = thisLine.split("\\|"); // phương thức tách chuỗi
                // lấy dữ liệu từ file
                Product newProduct = new Product(Integer.parseInt(info[0]), String.valueOf(info[1]),
                        Integer.parseInt(info[2]), Integer.parseInt(info[3]));
                // đưa dữ liệu vào node
                ListNode list = new ListNode(newProduct);
                lkd.addToTail(list, newProduct);
                // lkd.add(list,0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br.readLine() != null) {
                br.close();

            }
        }

    }

    public static void writeFile(Lien_ket_don list, String fileName) throws IOException {

        ListNode current = list.head;
        FileOutputStream fo = new FileOutputStream(fileName);
        PrintWriter out = new PrintWriter(fo, true);
        while (current != null) { // vòng lặp head khác null

            // out.println(current.product.toString()); //in dữ liệu vào file
            out.println(current.printData2());
            current = current.next;
        }
        out.close();

    }

    public static void writeFile2(String str) throws IOException {

        FileOutputStream fo = new FileOutputStream("console_output.txt");
        PrintWriter out = new PrintWriter(fo, true);
        out.write(str);
        out.close();

    }

}
