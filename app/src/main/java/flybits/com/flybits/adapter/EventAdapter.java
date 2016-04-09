package flybits.com.flybits.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import flybits.com.flybits.R;
import flybits.com.flybits.model.Event;
import flybits.com.flybits.model.FBFriend;

/**
 * Created by user on 2016-04-09.
 */
public class EventAdapter extends ArrayAdapter<Event> {
    private static class ViewHolder {
        TextView name;
    }

    public EventAdapter(Context context, ArrayList<Event> event) {
        super(context, R.layout.eventlist, event);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Event event = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.eventlist, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.event);
            convertView.setTag(viewHolder);
            viewHolder.name.setText("Shoot");
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.name.setText(event.getName());

        return convertView;
    }
}
