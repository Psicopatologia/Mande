package Controller;

import java.util.ArrayList;

public class Car {
    private ArrayList<Product> products;

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product p) {
        this.products.add(p);
    }



    public void removeProduct(int i) {products.remove(i);}
}
