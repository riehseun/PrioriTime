package flybits.com.flybits;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import me.gujun.android.taggroup.TagGroup;

public class EventTagsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_tags);

        ImageView event = (ImageView) findViewById(R.id.eventimage);

        Picasso.with(this)
                .load("https://world.apps-world.net/files/92363-400x200-flybits_new_logo.jpg")
                .into(event);

        TagGroup mTagGroup = (TagGroup) findViewById(R.id.tag_group);
        mTagGroup.setTags(new String[]{"Java", "Python", "Software Developer",
                "JavaScript", "Flybit", "Database", "SQL", "Finance", "Banking", "Engineer",
                "Adobe", "Android", "iOS", "Go", "Android Studio"});
    }
}
