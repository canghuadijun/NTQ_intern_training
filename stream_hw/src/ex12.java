import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ex12 {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();

        // Tạo danh sách đơn hàng và sản phẩm
        List<Product> products1 = new ArrayList<>();
        products1.add(new Product(1L, "Sản phẩm A", "Đồ chơi", 120.0));
        products1.add(new Product(2L, "Sản phẩm B", "Đồ chơi", 80.0));
        Order order1 = new Order(1L, "Đã giao hàng", LocalDate.of(2021, 3, 14), LocalDate.of(2021, 3, 20), products1, new Customer(1L, "Khách hàng A", 1));
        orders.add(order1);

        List<Product> products2 = new ArrayList<>();
        products2.add(new Product(3L, "Sản phẩm C", "Quần áo", 150.0));
        products2.add(new Product(4L, "Sản phẩm D", "Đồ chơi", 90.0));
        Order order2 = new Order(2L, "Đã giao hàng", LocalDate.of(2021, 2, 5), LocalDate.of(2021, 2, 10), products2, new Customer(2L, "Khách hàng B", 2));
        orders.add(order2);

        List<Product> products3 = new ArrayList<>();
        products3.add(new Product(5L, "Sản phẩm E", "Đồ chơi", 100.0));
        Order order3 = new Order(3L, "Chưa giao hàng", LocalDate.of(2021, 4, 1), LocalDate.of(2021, 4, 5), products3, new Customer(3L, "Khách hàng C", 2));
        orders.add(order3);

        Map<Order, Double> orderDoubleMap = orders.stream()
                .collect(Collectors.toMap(order -> order, order -> order.getProducts().stream().mapToDouble(Product::getPrice).sum()));

        for (Map.Entry<Order, Double> entry : orderDoubleMap.entrySet()) {
            Order order = entry.getKey();
            Double totalAmount = entry.getValue();
            System.out.println("Đơn hàng #" + order.getId() + ": Tổng số tiền = " + totalAmount);
        }
    }
}
