import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ex5 {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Sản phẩm A", "Sách", 150.0));
        products.add(new Product(2L, "Sản phẩm B", "Sách", 90.0));
        products.add(new Product(3L, "Sản phẩm C", "Đồ chơi", 200.0));
        products.add(new Product(4L, "Sản phẩm D", "Sách", 120.0));
        products.add(new Product(5L, "Sản phẩm E", "Sách", 80.0));

        Optional<Product> ex5 = products.stream()
                .filter(product -> product.getCategory().equals("Sách"))
                .min((product1, product2) -> Double.compare(product1.getPrice(), product2.getPrice()));

        if (ex5.isPresent()) {
            Product product = ex5.get();
            System.out.println("Sản phẩm rẻ nhất trong category \"Sách\":");
            System.out.println(product.getName() + " - Giá: " + product.getPrice());
        } else {
            System.out.println("Không có sản phẩm nào trong category \"Sách\".");
        }
    }
}
