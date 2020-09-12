package Controller;

import android.database.Cursor;

import java.util.ArrayList;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class Store {
    private String name="";
    private int id;
    private int owner;

    public Store(int id, String name, int owner) {
        this.id = id;
        this.name = name;
        this.owner = owner;
    }

    public int getOwner() {
        return owner;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}
