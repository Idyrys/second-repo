package kg.mega.shop.models;

public class Product {
    private int id;
    private String name;
    private double price;
    private int amount;
    private Category category;
    private String barcode;

    public Product(int id, String name, double price, int amount, Category category,String barcode) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.category = category;
        this.barcode = barcode;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
