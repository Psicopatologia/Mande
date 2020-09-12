package utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import Controller.Product;
import Controller.Store;
import Controller.User;

public class DataBaseMande extends SQLiteOpenHelper {

    public DataBaseMande(Context context) {
        super(context, "Mande", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Users(user_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name VARCHAR,email VARCHAR, password VARCHAR,user_type INTEGER);");
        db.execSQL("CREATE TABLE IF NOT EXISTS Stores(store_id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR, owner INTEGER," +
                "FOREIGN KEY (owner) REFERENCES Users (user_id) ON DELETE CASCADE  ON UPDATE NO ACTION);");
        db.execSQL("CREATE TABLE IF NOT EXISTS Products(product_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "store_id INTEGER, price INTEGER, amount INTEGER," +
                "name VARCHAR, description VARCHAR," +
                "FOREIGN KEY (store_id) REFERENCES Stores (store_id) ON DELETE CASCADE  ON UPDATE NO ACTION);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS Users");
        db.execSQL("DROP TABLE IF EXISTS Stores");
        db.execSQL("DROP TABLE IF EXISTS Products");

        // Create tables again
        onCreate(db);
    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("password", user.getPassword());
        values.put("email", user.getEmail());
        values.put("user_type", 1);

        db.insert("Users", null, values);

        db.close();
    }

    /**
     * Adds store to data base
     *
     * @param store store to be inserted
     */
    public void addStore(Store store) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", store.getName()); // Contact Name
        values.put("owner", 0); // Contact Phone

        db.insert("Stores", null, values);

        db.close();
    }

    /**
     * Return a single store
     *
     * @param id store's id
     * @return store
     */
    public Store getStore(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("Stores", new String[]{"store_id", "name", "owner"}, "store_id" + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Store store = new Store(Integer.parseInt(cursor.getString(0)), cursor.getString(1), Integer.parseInt(cursor.getString(2)));

        return store;
    }

    public Store getStoreByOwner(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("Stores", new String[]{"store_id", "name", "owner"}, "user_id" + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Store store = new Store(Integer.parseInt(cursor.getString(0)), cursor.getString(1), Integer.parseInt(cursor.getString(2)));

        return store;
    }

    /**
     * Returns a list with all of the stores
     *
     * @return
     */
    public List<Store> getAllStores() {
        List<Store> storeList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM Stores";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                storeList.add(new Store(Integer.parseInt(cursor.getString(0)), cursor.getString(1), Integer.parseInt(cursor.getString(2))));
            } while (cursor.moveToNext());
        }

        // return contact list
        return storeList;
    }

    public void deleteStore(Store store) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Stores", "store_id" + " = ?",
                new String[] { String.valueOf(store.getId()) });
        db.close();
    }

    /**
     * Adds product to data base
     *
     * @param product product to be inserted
     */
    public void addProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", product.getName());
        values.put("amount", product.getAmount());
        values.put("description", product.getDescription());
        values.put("price", product.getPrice());
        values.put("store", product.getStore());

        db.insert("Products", null, values);

        db.close();
    }

    /**
     * Return a single product
     *
     * @param id product's id
     * @return product
     */
    Product getProduct(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("Products", new String[]{"store_id", "store", "price", "amount", "name", "description"}, "product_id" + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Product product = new Product(
                Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(1)),
                Integer.parseInt(cursor.getString(2)),
                Integer.parseInt(cursor.getString(3)),
                cursor.getString(4),
                cursor.getString(4)
        );

        return product;
    }

    /**
     * Returns a list with all of the products
     *
     * @return
     */
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM Products";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                productList.add(new Product(
                        Integer.parseInt(cursor.getString(0)),
                        Integer.parseInt(cursor.getString(1)),
                        Integer.parseInt(cursor.getString(2)),
                        Integer.parseInt(cursor.getString(3)),
                        cursor.getString(4),
                        cursor.getString(4)
                ));
            } while (cursor.moveToNext());
        }

        // return contact list
        return productList;
    }

    public int updateProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", product.getName());
        values.put("amount", product.getAmount());
        values.put("description", product.getDescription());
        values.put("price", product.getPrice());
        values.put("store", product.getStore());

        // updating row
        return db.update("Products", values, "product_id" + " = ?",
                new String[] { String.valueOf(product.getId()) });
    }

    public void deleteProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Products", "id" + " = ?",
                new String[] { String.valueOf(product.getId()) });
        db.close();
    }
}
