package DataAccessControl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Vajira Prabuddhaka on 6/26/2017.
 */

public class DBcreator {
    public static SQLiteDatabase db;
    public DBcreator(Context ctx){
        SQLiteDatabase mydatabase = ctx.openOrCreateDatabase("remController", ctx.MODE_PRIVATE, null);

        //If it's the first time, we have to create the databases.
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS Remote(" +
                "ID VARCHAR PRIMARY KEY," +
                "Remotename VARCHAR" +
                " );");


        //It is a reserved keyword and will give errors in queries
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS remotebuttons(" +
                "ID VARCHAR," +
                "Btn_name VARCHAR," +
                "raw_data VARCHAR," +
                "loop VARCHAR,"  +
                "FOREIGN KEY (ID) REFERENCES Remote(ID)" +
                ");");

        this.db = mydatabase;
    }

    public SQLiteDatabase getDB(){
        return this.db;
    }
}
