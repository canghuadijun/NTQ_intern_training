import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ex2 {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();

        // Tạo danh sách đơn hàng và sản phẩm
        List<Product> products1 = new ArrayList<>();
        products1.add(new Product(1L, "Sản phẩm A", "Trẻ em", 120.0));
        products1.add(new Product(2L, "Sản phẩm B", "Đồ chơi", 80.0));
        Order order1 = new Order(1L, "Đã giao hàng", LocalDate.of(2023, 1, 10), LocalDate.of(2023, 1, 15), products1, new Customer(1L, "Khách hàng A", 1));
        orders.add(order1);

        List<Product> products2 = new ArrayList<>();
        products2.add(new Product(3L, "Sản phẩm C", "Trẻ em", 150.0));
        products2.add(new Product(4L, "Sản phẩm D", "Đồ chơi", 90.0));
        Order order2 = new Order(2L, "Đã giao hàng", LocalDate.of(2023, 2, 5), LocalDate.of(2023, 2, 10), products2, new Customer(2L, "Khách hàng B", 2));
        orders.add(order2);

        List<Product> products3 = new ArrayList<>();
        products3.add(new Product(5L, "Sản phẩm E", "Đồ chơi", 100.0));
        Order order3 = new Order(3L, "Chưa giao hàng", LocalDate.of(2023, 3, 20), LocalDate.of(2023, 3, 25), products3, new Customer(3L, "Khách hàng C", 3));
        orders.add(order3);

        // Lấy danh sách đơn hàng chứa sản phẩm thuộc category "Trẻ em"
        List<Order> filteredOrders = orders.stream()
                .filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equals("Trẻ em")))
                .collect(Collectors.toList());

        // In ra danh sách đơn hàng
        System.out.println("Danh sách đơn hàng chứa sản phẩm thuộc category \"Trẻ em\":");
        for (Order order : filteredOrders) {
            System.out.println("Đơn hàng #" + order.getId());
            System.out.println("Khách hàng: " + order.getCustomer().getName());
            System.out.println("Ngày đặt hàng: " + order.getOrderDate());
            System.out.println("Ngày giao hàng dự kiến: " + order.getDeliveryDate());
            System.out.println("Trạng thái: " + order.getStatus());
            System.out.println("Sản phẩm:");
            for (Product product : order.getProducts()) {
                System.out.println("- " + product.getName() + " - Giá: " + product.getPrice());
            }
            System.out.println("--------------------------------------");
        }
    }
}
