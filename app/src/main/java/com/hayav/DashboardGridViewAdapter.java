package com.hayav;

import java.util.ArrayList;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DashboardGridViewAdapter extends ArrayAdapter<Item> {

    Context context;
    int layoutResourceId;
    ArrayList<Item> data = new ArrayList<Item>();

    public DashboardGridViewAdapter(Context context, int layoutResourceId, ArrayList<Item> data)
    {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context; this.data = data;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecordHolder holder = null;
        if (row == null)
        {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new RecordHolder();
            holder.title = (TextView) row.findViewById(R.id.name);
            holder.description = (TextView) row.findViewById(R.id.details);
            row.setTag(holder);
        }
        else
        {
            holder = (RecordHolder) row.getTag();
        }
        Item item = data.get(position);
        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
        return row;
    }

    static class RecordHolder
    {
        TextView title;
        TextView description;
    }
}


