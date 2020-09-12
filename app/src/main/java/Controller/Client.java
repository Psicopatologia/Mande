package Controller;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class Client extends User {
    private ArrayList<Integer> car;
    private SQLiteDatabase db;

    public Client() {
        car = new ArrayList<>();
    }

    public ArrayList<Integer> getCar() {
        return car;
    }

    public void addToCar(int id_product) {
        car.add(id_product);
    }

    public int removeFromCar(int i) {
        return car.remove(i);
    }
}
