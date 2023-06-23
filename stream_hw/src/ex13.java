import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ex13 {
    public static void main(String[] args) {
        // Tạo dữ liệu
        Product test1 = new Product((long) 0, "Lốp xe máy", "Phụ tùng phương tiện", (double) 100);
        Product test2 = new Product((long) 1, "Tôi tài giỏi và bạn cũng thế", "Sách", (double) 120);
        Product test3 = new Product((long) 2, "Bánh tráng trộn", "Đồ ăn vặt", (double) 30);
        Product test4 = new Product((long) 3, "Nhật ký trong tù", "Sách", (double) 100);
        List<Product> products = Arrays.asList(test1, test2, test3, test4);

        // Tạo map với danh sách tên sản phẩm theo danh mục
        Map<String, List<String>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.mapping(Product::getName, Collectors.toList())));

        // In danh sách tên sản phẩm theo danh mục
        for (Map.Entry<String, List<String>> entry : productsByCategory.entrySet()) {
            String category = entry.getKey();
            List<String> productNames = entry.getValue();
            System.out.println("Danh mục: " + category);
            System.out.println("Danh sách sản phẩm:");
            for (String productName : productNames) {
                System.out.println("- " + productName);
            }
            System.out.println();
        }
    }
}
