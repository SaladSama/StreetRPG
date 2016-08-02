package eu.epitech.eip.streetrpg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by LAT on 19/7/2016.
 */

public class MyAdapter extends BaseAdapter {
    private LayoutInflater myInflater;
    String[] names;
    String[] lists;

    public MyAdapter(Context c, String[] names, String[]lists) {
        myInflater = LayoutInflater.from(c);
        this.names = names;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        convertView = myInflater.inflate(R.layout.list_item, null);

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView list = (TextView) convertView.findViewById(R.id.txtengname);

        name.setText(names[position]);
        list.setText(lists[position]);

        return convertView;
    }
}
