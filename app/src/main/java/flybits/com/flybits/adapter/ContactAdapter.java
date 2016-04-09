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
import flybits.com.flybits.model.FBFriend;

/**
 * Created by larrychong on 16-04-09.
 */
public class ContactAdapter extends ArrayAdapter<FBFriend> {
    // View lookup cache
    private static class ViewHolder {
        ImageView avatar;
        TextView timeSpent;
    }

    public ContactAdapter(Context context, ArrayList<FBFriend> friend) {
        super(context, R.layout.item_contact, friend);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        FBFriend contact = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_contact, parent, false);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.profileimage);
            viewHolder.timeSpent = (TextView) convertView.findViewById(R.id.timespent);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

//        viewHolder.avatar.setText(user.name);
        viewHolder.timeSpent.setText("Test");

        Picasso.with(getContext())
                .load("https://scontent-yyz1-1.xx.fbcdn.net/hphotos-xaf1/t31.0-8/842984_10151496485382853_984212292_o.jpg")
                .into(viewHolder.avatar);
        return convertView;
    }
}