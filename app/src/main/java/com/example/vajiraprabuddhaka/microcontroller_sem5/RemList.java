package com.example.vajiraprabuddhaka.microcontroller_sem5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.vajiraprabuddhaka.microcontroller_sem5.R;
import java.util.ArrayList;
import java.util.List;

import DataAccessControl.DBcreator;
import DataAccessControl.remoteDAO;

public class RemList extends AppCompatActivity {
    Context ctx;
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rem_list);


        //find list view through id
        lv = (ListView) findViewById(R.id.list);

        // will replace with the data that are taken from the database

        /*SQLiteDatabase mydatabase = openOrCreateDatabase("remController", MODE_PRIVATE, null);

        //If it's the first time, we have to create the databases.
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS Remote(" +
                "ID VARCHAR PRIMARY KEY," +
                "Remotename VARCHAR," +
                " );");


        //It is a reserved keyword and will give errors in queries
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS remotebuttons(" +
                "ID VARCHAR," +
                "Account_no VARCHAR," +
                "FOREIGN KEY (ID) REFERENCES Remote(ID)" +
                ");");*/

        DBcreator mydb = new DBcreator(getApplicationContext());
        remoteDAO dao = new remoteDAO(mydb.getDB(), getApplicationContext());
        List<String> my_array_list;
        my_array_list = dao.getRemoteList();

        my_array_list.add("Sony Rm512");
        my_array_list.add("Haier Htr18A");


        if (!my_array_list.isEmpty()) {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_1,
                    my_array_list);

            lv.setAdapter(arrayAdapter);
        }
        else{
            Toast.makeText(getApplicationContext(), "No remots can be found", Toast.LENGTH_SHORT).show();
        }

    }
}
