package com.example.vajiraprabuddhaka.microcontroller_sem5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vajiraprabuddhaka.microcontroller_sem5.R;

public class add_remote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_remote);

        //Configure button submit
        Button submit = (Button) findViewById(R.id.add_submit);
        final EditText name = (EditText) findViewById(R.id.rem_name);
        EditText ID = (EditText)findViewById(R.id.rem_ID);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rem_name = name.getText().toString();
            }
        });
    }
}
