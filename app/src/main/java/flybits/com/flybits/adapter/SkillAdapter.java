package flybits.com.flybits.adapter;

import android.content.Context;
import android.nfc.Tag;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import flybits.com.flybits.R;
import flybits.com.flybits.model.FBFriend;
import me.gujun.android.taggroup.TagGroup;

/**
 * Created by user on 2016-04-10.
 */
public class SkillAdapter extends ArrayAdapter<String> {
    private static class ViewHolder {
        //TextView text;
        TagGroup mTagGroup;
    }

    public SkillAdapter(Context context, List<String> skills) {
        super(context, R.layout.skilllist, skills);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        String skill = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.skilllist, parent, false);
            //viewHolder.text = (TextView) convertView.findViewById(R.id.text);
            viewHolder.mTagGroup = (TagGroup) convertView.findViewById(R.id.tag_group);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //viewHolder.text.setText(skill);
        viewHolder.mTagGroup.setTags(skill);
        return convertView;
    }
}
