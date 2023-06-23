import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ex3 {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Sản phẩm A", "Đồ chơi", 100.0));
        products.add(new Product(2L, "Sản phẩm B", "Đồ chơi", 150.0));
        products.add(new Product(3L, "Sản phẩm C", "Quần áo", 200.0));
        products.add(new Product(4L, "Sản phẩm D", "Đồ chơi", 120.0));
        products.add(new Product(5L, "Sản phẩm E", "Đồ chơi", 80.0));

        // Lấy danh sách sản phẩm có category = “Đồ chơi” và sau đó áp dụng giảm giá 10% vào giá sản phẩm
        List<Product> ex3 = products.stream()
                .filter(product -> product.getCategory().equals("Đồ chơi"))
                .map(product -> {
                    double discount = product.getPrice() * 0.9;
                    product.setPrice(discount);
                    return product;
                }).collect(Collectors.toList());
        System.out.println("Danh sách sản phẩm có category \"Đồ chơi\" sau khi áp dụng giảm giá 10%:");
        for (Product product : ex3) {
            System.out.println(product.getName() + " - Giá: " + product.getPrice());
        }
    }
}
