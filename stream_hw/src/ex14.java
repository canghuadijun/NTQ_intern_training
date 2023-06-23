import java.util.*;
import java.util.stream.Collectors;

public class ex14 {
    public static void main(String[] args) {
        // Tạo dữ liệu
        Product test1 = new Product((long) 0, "Lốp xe máy", "Phụ tùng phương tiện", (double) 100);
        Product test2 = new Product((long) 1, "Tôi tài giỏi và bạn cũng thế", "Sách", (double) 120);
        Product test3 = new Product((long) 2, "Bánh tráng trộn", "Đồ ăn vặt", (double) 30);
        Product test4 = new Product((long) 3, "Nhật ký trong tù", "Sách", (double) 100);
        List<Product> products = Arrays.asList(test1, test2, test3, test4);

        // Lấy sản phẩm đắt nhất theo danh mục
        Map<String, Optional<Product>> mostExpensiveProductsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));

        // In sản phẩm đắt nhất theo danh mục
        for (Map.Entry<String, Optional<Product>> entry : mostExpensiveProductsByCategory.entrySet()) {
            String category = entry.getKey();
            Optional<Product> mostExpensiveProduct = entry.getValue();
            System.out.println("Danh mục: " + category);
            mostExpensiveProduct.ifPresentOrElse(
                    product -> System.out.println("Sản phẩm đắt nhất: " + product.getName() + ", có giá " + product.getPrice()),
                    () -> System.out.println("Không có sản phẩm trong danh mục này.")
            );
            System.out.println();
        }

    }
}
