package Controller;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class Owner extends User {
    private SQLiteDatabase db;
    private int ID;

    public Owner(int ID) {
        this.ID = ID;
    }

    ArrayList<Store> stores;

    public ArrayList<Store> getStores() {
        stores = new ArrayList<>();
        db();
        String query= "SELECT store_id FROM Stores WHERE owner = "+this.ID;
        Cursor resultSet = db.rawQuery(query,null);
        resultSet.moveToFirst();
        do{
            this.stores.add(new Store(Integer.parseInt(resultSet.getString(0))));
        } while(resultSet.moveToNext());
        return stores;
    }

    public ArrayList<Store> addStore(Store s) {
        db();
        String query = "INSERT INTO Stores(name,owner) VALUES("+s.getName()+","+this.ID+");";
        db.execSQL(query);
        return getStores();
    }

    public ArrayList<Store> removeStore(Store s) {
        db();
        String query = "DELETE FROM Stores where store_id = "+s.getId();
        db.execSQL(query);
        return getStores();
    }

    public ArrayList<Store> updateStore(Store s) {
        db();
        String query = "UPDATE Stores SET name="+s.getName()+"  WHERE store_id="+s.getId();
        db.execSQL(query);
        return getStores();
    }

    private void db() {
        db = openOrCreateDatabase("Mande",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Users(user_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name VARCHAR,email VARCHAR, password VARCHAR,user_type INTEGER);");
        db.execSQL("CREATE TABLE IF NOT EXISTS Stores(store_id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR, owner INTEGER," +
                "FOREIGN KEY (owner) REFERENCES Users (user_id) ON DELETE CASCADE  ON UPDATE NO ACTION);");
    }
}
