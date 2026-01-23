
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
public static void main(String[] args){
    List<Book> listBook = new ArrayList<>();
    Scanner x = new Scanner(System.in);
    String msg = """
            Chương trình quản lý sách
                1. Thêm 1 cuốn sách
                2. Xóa 1 cuốn sách
                3. Thay đổi thông tin sách
                4. Xuất tất cả sách
                5. Tìm sách có tiêu đề chứa 'Lập trình'
                6. Lấy tối đa K sách có giá <= P
                7. Tìm sách theo danh sách tác giả
                0. Thoát
                Chọn:""";

        int chon = 0;
        do {
            System.out.printf(msg);
            chon = x.nextInt();

            switch (chon) {
                case 1 -> {
                    Book newBook = new Book();
                    newBook.input();
                    listBook.add(newBook);
                }
                case 2 -> {
                    System.out.print("Nhập mã sách cần xóa: ");
                    int bookid = x.nextInt();
                    Book find = listBook.stream().filter(p->p.getId() == bookid).findFirst().orElseThrow();
                    listBook.remove(find);
                    System.out.print("Đã xóa sách.");
                }
                case 3 -> {
                    System.out.print("Nhập mã sách cần điều chỉnh: ");
                    int bookid = x.nextInt();
                    Book find = listBook.stream().filter(p->p.getId() == bookid).findFirst().orElseThrow();
                }
                case 4 -> {
                    System.out.println("\nXuất thông tin danh sách");
                    listBook.forEach(p -> p.output());
                }
                case 5 -> {
                    List<Book> list5 = listBook.stream().filter(u->u.getTitle().toLowerCase().contains("lập trình")).toList();
                    list5.forEach(Book::output);
                }
                case 6 -> {
                    System.out.print("Nhập K: ");
                    int k = x.nextInt();
                    System.out.print("Nhập P: ");
                    double p = x.nextDouble();

                    List<Book> result = listBook.stream(). filter(b->b.getPrice()<=p).limit(k).toList();
                    result.forEach(Book::output);
                }
                case 7 -> {
                    x.nextLine();
                    System.out.print("Nhập danh sách tác giả: ");
                    String input = x.nextLine();
                    Set<String> authorSet = Arrays.stream(input.split(",")).map(String::trim).map(String::toLowerCase).collect(Collectors.toSet());
                    listBook.stream().filter(b -> authorSet.contains(b.getAuthor().toLowerCase())).forEach(Book::output);
                }
                case 0 -> System.out.println("Thoát chương trình!");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (chon != 0);
    }
}

