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

import flybits.com.flybits.DummyData.DummyData;
import flybits.com.flybits.R;
import flybits.com.flybits.model.FBFriend;
import me.gujun.android.taggroup.TagGroup;

/**
 * Created by user on 2016-04-10.
 */
public class DummyAdapter extends ArrayAdapter<FBFriend> {
    private static class ViewHolder {
        ImageView avatar;
        TextView name;
        TagGroup mTagGroup;
    }

    public DummyAdapter(Context context, ArrayList<FBFriend> friend) {
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
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.mTagGroup = (TagGroup) convertView.findViewById(R.id.tag_group);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //viewHolder.avatar.setText(user.name);
        viewHolder.name.setText(contact.getProfileName());
        Picasso.with(getContext())
                .load(contact.getProfileUrl())
                .into(viewHolder.avatar);

        viewHolder.mTagGroup.setTags(contact.getSkills());
        return convertView;
    }
}
