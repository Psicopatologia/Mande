package Controller;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class Owner extends User {
    private int ID;

    public Owner(int ID) {
        this.ID = ID;
    }

}
