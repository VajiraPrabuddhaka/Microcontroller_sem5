package com.example.vajiraprabuddhaka.microcontroller_sem5;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vajiraprabuddhaka.microcontroller_sem5.R;

import java.util.ArrayList;
import java.util.List;

public class remote_buttons extends AppCompatActivity {
    private ArrayList<String> data = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data.add("Power");
        data.add("Vol +");
        data.add("Vol -");
        data.add("CH+");
        data.add("CH-");
        data.add("1");
        data.add("2");
        data.add("3");
        data.add("4");
        data.add("5");
        data.add("6");
        data.add("7");
        data.add("8");
        data.add("9");
        data.add("0");
        data.add("Menu");
        setContentView(R.layout.activity_remote_buttons);

        ListView lv = (ListView) findViewById(R.id.buttons_list);
        lv.setAdapter(new MyListAdapter(this,R.layout.list_item,data));

    }

    private class MyListAdapter extends ArrayAdapter<String>{
        private int layout;
        public MyListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<String> objects) {
            super(context, resource, objects);
            layout = resource;
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder mainViewHolder = null;
            if (convertView==null){
                LayoutInflater inflator = LayoutInflater.from(getContext());
                convertView = inflator.inflate(layout,parent,false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.thumbnail = (ImageView) convertView.findViewById(R.id.list_item_thumbnail);
                viewHolder.title = (TextView) convertView.findViewById(R.id.list_item_text);
                viewHolder.title.setText(getItem(position));
                System.out.println("I reached here 1");
                System.out.println("Position: " +position);
                viewHolder.btn = (Button) convertView.findViewById(R.id.list_item_btn);
                viewHolder.btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(),"Button is working for list item "+ position,Toast.LENGTH_SHORT);
                        System.out.println("Button clicked: "+position);
                    }
                });
                convertView.setTag(viewHolder);
            }
            else{
                mainViewHolder = (ViewHolder) convertView.getTag();
                mainViewHolder.title.setText(getItem(position));
                System.out.println("I reached here 2");
            }
            return convertView;
        }
    }

    public class ViewHolder{
        ImageView thumbnail;
        TextView title;
        Button btn;
    }
}
