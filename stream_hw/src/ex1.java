import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ex1 {
    public static void main(String[] args) {
        /*
        Tạo dữ liệu để test
         */
        Product test1 = new Product((long) 0, "Lốp xe máy", "Phụ tùng phương tiện", (double) 100);
        Product test2 = new Product((long) 1, "Tôi tài giỏi và bạn cũng thế", "Sách", (double) 120);
        Product test3 = new Product((long) 2, "Bánh tráng trộn", "Đồ ăn vặt", (double) 30);
        Product test4 = new Product((long) 3, "Nhật ký trong tù", "Sách", (double) 100);
        List<Product> products = Arrays.asList(test1, test2, test3, test4);
        /*
         Lấy danh sách các sản phẩm thuộc category “Sách” có giá >100
         */
        List<Product> filterProduct = products.stream()
                .filter(product -> product.getCategory().equals("Sách") && product.getPrice() > 100)
                .collect(Collectors.toList());
        filterProduct.forEach(System.out::println);
    }
}
