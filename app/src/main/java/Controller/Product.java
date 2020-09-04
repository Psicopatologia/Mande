package Controller;

public class Product {
    private String Name, Description;
    private int Price, Amount, ID;

    public Product(int id, int price, int amount , String name, String description) {
        Name = name;
        Description = description;
        Price = price;
        Amount = amount;
        ID =id;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public int getPrice() {
        return Price;
    }

    public int getAmount() {
        return Amount;
    }
}
