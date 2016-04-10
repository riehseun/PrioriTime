package flybits.com.flybits.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.flybits.core.api.models.Zone;

import java.util.List;

import flybits.com.flybits.R;

/**
 * Created by user on 2016-04-09.
 */
public class EventAdapter extends ArrayAdapter<Zone> {
    private static class ViewHolder {
        TextView name;
    }

    public EventAdapter(Context context, List<Zone> zones) {
        super(context, R.layout.eventlist, zones);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Zone zone = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.eventlist, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.event);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.name.setText(zone.getName());

        return convertView;
    }
}
