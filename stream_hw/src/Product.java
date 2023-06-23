public class Product {
    public Long id;
    public String name;
    public String category;
    public Double price;

    public Product(Long id, String name, String category, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String toString() {
        return "ID: "
                + id
                + ", Tên sản phẩm: "
                + name
                + ", Loại sản phẩm: "
                + category
                + ", Giá: "
                + price
                + "\n";
    }
}