package com.masoud.example.listitembaseadapter;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.listView);
        list.setAdapter(new masoudAdapter(this));
    }
}

class SingleRow {
    String title;
    String description;
    int image;

    SingleRow(String title, String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }


}

class masoudAdapter extends BaseAdapter {

    ArrayList<SingleRow> list;
    Context context;

    masoudAdapter(Context c) {
        list = new ArrayList<SingleRow>();
        context = c;
        Resources rec = c.getResources();
        String[] title = rec.getStringArray(R.array.title);
        String[] description = rec.getStringArray(R.array.descriptions);
        int[] image = {R.drawable.pic01, R.drawable.pic02, R.drawable.pic03, R.drawable.pic04,
                R.drawable.pic05, R.drawable.pic06, R.drawable.pic07, R.drawable.pic08,
                R.drawable.pic09, R.drawable.pic10};
        for (int i = 0; i < 10; i++) {
            list.add(new SingleRow(title[i], description[i], image[i]));
        }
    }

    @Override

    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single_row,parent,false);
        TextView title= (TextView) row.findViewById(R.id.textView);
        TextView discription= (TextView) row.findViewById(R.id.textView2);
        ImageView image= (ImageView) row.findViewById(R.id.imageView);

        SingleRow temp=list.get(position);
        title.setText(temp.title);
        discription.setText(temp.description);
        image.setImageResource(list.get(position).image);

        return row;
    }
}