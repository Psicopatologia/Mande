package Controller;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class Store {
    private String Name="";
    private int id;
    private ArrayList<Product> products;
    private SQLiteDatabase db;

    public Store(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        if (Name=="") {
            db();
            String query= "SELECT name FROM Stores WHERE store_id = "+this.id;
            Cursor resultSet = db.rawQuery(query,null);
            resultSet.moveToFirst();
            this.Name = resultSet.getString(1);
        }
        return Name;
    }

    public ArrayList<Product> getProducts() {
        products = new ArrayList<>();
        db();
        String query= "SELECT product_id, price, amount, name, description FROM Products WHERE store_id = "+this.id;
        Cursor resultSet = db.rawQuery(query,null);
        resultSet.moveToFirst();
        do{
            this.products.add(new Product(Integer.parseInt(resultSet.getString(0)),
                    Integer.parseInt(resultSet.getString(1)),
                    Integer.parseInt(resultSet.getString(2)),
                    resultSet.getString(3),
                    resultSet.getString(4)
            ));
        } while(resultSet.moveToNext());
        return products;
    }

    public ArrayList<Product> addProduct(Product p) {
        db();
        String query = "INSERT INTO Products(store_id,price,amount,name,description) VALUES("+this.id+","+p.getPrice()+","+p.getAmount()+","+p.getName()+","+p.getDescription()+");";
        db.execSQL(query);
        return getProducts();
    }

    public ArrayList<Product> removeProduct(Product p) {
        db();
        String query = "DELETE FROM Products where product_id = "+p.getID();
        db.execSQL(query);
        return getProducts();
    }

    public ArrayList<Product> updateProduct(Product p) {
        db();
        String query = "UPDATE Products SET id_store="+this.id+",price="+p.getPrice()+",amount="+p.getAmount()+",name="+p.getName()+",description="+p.getDescription()+" WHERE id_producto="+p.getID()+";";
        db.execSQL(query);
        return getProducts();
    }

    private void db() {
        db = openOrCreateDatabase("Mande",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Stores(store_id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR, owner INTEGER," +
                "FOREIGN KEY (owner) REFERENCES Users (user_id) ON DELETE CASCADE  ON UPDATE NO ACTION);");
        db.execSQL("CREATE TABLE IF NOT EXISTS Products(product_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "store_id INTEGER, price INTEGER, amount INTEGER," +
                "name VARCHAR, description VARCHAR," +
                "FOREIGN KEY (store_id) REFERENCES Stores (store_id) ON DELETE CASCADE  ON UPDATE NO ACTION);");
    }
}
