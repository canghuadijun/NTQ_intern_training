import java.time.LocalDate;
import java.util.List;

public class Order {
    public Long id;
    public String status;
    public LocalDate orderDate;
    public LocalDate deliveryDate;
    public List<Product> products;
    public Customer customer;

    public Order(
            Long id, String status, LocalDate orderDate, List<Product> products, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.products = products;
        this.customer = customer;
    }

    public Order(
            Long id,
            String status,
            LocalDate orderDate,
            LocalDate deliveryDate,
            List<Product> products,
            Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String toString() {
        return "ID: "
                + id
                + " Tình trạng đơn hàng: "
                + status
                + " Ngày đặt: "
                + orderDate
                + " Ngày giao: "
                + deliveryDate
                + " Danh sách sản phẩm: "
                + products
                + " Tên khách hàng: "
                + customer.name
                + "\n";
    }
}