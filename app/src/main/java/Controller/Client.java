package Controller;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class Client extends User {
    private ArrayList<Product> car = new ArrayList<>();
    private SQLiteDatabase db;

    public ArrayList<Product> getCar() {
        return car;
    }

    public void addToCar(int id_product) {
        db();
        String query= "SELECT price, amount, name, description FROM Products WHERE product_id = "+id_product;
        Cursor resultSet = db.rawQuery(query,null);
        resultSet.moveToFirst();
        Product p=new Product(id_product,
                    Integer.parseInt(resultSet.getString(0)),
                    Integer.parseInt(resultSet.getString(1)),
                    resultSet.getString(2),
                    resultSet.getString(3)
            );
        car.add(p);
    }

    public Product removeFromCar(int i) {
        return car.remove(i);
    }

    public void makeTransaction() {
        db();
        for(Product p : car)
        {
            db.execSQL("DELETE FROM Products where product_id = "+p.getID()+";");
        }
        car = new ArrayList<>();
    }
    private void db() {
        db = openOrCreateDatabase("Mande",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Users(user_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name VARCHAR,email VARCHAR, password VARCHAR,user_type INTEGER);");
    }
}
