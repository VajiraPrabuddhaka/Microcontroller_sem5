package DataAccessControl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vajira Prabuddhaka on 6/22/2017.
 */

public class remoteDAO {
    private SQLiteDatabase database;

    public remoteDAO(SQLiteDatabase db){
        this.database = db;
    }

    public List<String> getRemoteList(){
        Cursor data = database.rawQuery("SELECT Name FROM remote",null);
        //Initialize a list to store the relevant data
        List<String> remlist = new ArrayList<String>();

        //Loop the iterator and add data to the List
        if(data.moveToFirst()) {
            do {
                remlist.add(data.getString(data.getColumnIndex("Account_no")));
            } while (data.moveToNext());
        }
        //Return the list
        return remlist;
    }
}
