package Controller;

public class Product {
    private String name, description;
    private int price, amount, id, store;

    public Product(int id, int store, int price, int amount , String name, String description) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.id =id;
        this.store = store;
    }

    public int getStore() {
        return store;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStore(int store) {
        this.store = store;
    }
}
