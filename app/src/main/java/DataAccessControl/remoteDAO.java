package DataAccessControl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vajira Prabuddhaka on 6/22/2017.
 */

public class remoteDAO {
    private SQLiteDatabase database;
    private Context ctx;

    public remoteDAO(SQLiteDatabase db, Context ctx){
        this.database = db;
        this.ctx = ctx;
    }

    public List<String> getRemoteList(){
        Cursor data = database.rawQuery("SELECT Remotename FROM Remote",null);
        //Initialize a list to store the relevant data
        List<String> remlist = new ArrayList<String>();

        //Loop the iterator and add data to the List
        if(data.moveToFirst()) {
            do {
                remlist.add(data.getString(data.getColumnIndex("Remotename")));
            } while (data.moveToNext());
        }
        //Return the list
        return remlist;
    }

    public void addRemote(String name, String id){
        //database.execSQL();
        database.execSQL("insert into Remote (ID, Remotename) values ("+ id + ","+name +");");

        Toast.makeText(ctx, "Sucessfully added", Toast.LENGTH_SHORT).show();
        //whatever logic to add
    }
}
