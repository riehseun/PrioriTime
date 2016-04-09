package flybits.com.flybits;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import me.gujun.android.taggroup.TagGroup;

public class PersonalTags extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_tags);

        CircleImageView circle = (CircleImageView) findViewById(R.id.profile_image);
        Picasso.with(this)
                .load("https://randomuser.me/api/portraits/men/81.jpg")
                .into(circle);

        TagGroup mTagGroup = (TagGroup) findViewById(R.id.tag_group);
        mTagGroup.setTags(new String[]{"Java", "Python", "Software Developer",
                "JavaScript", "Flybit", "Database", "SQL", "Finance", "Banking", "Engineer",
                "Adobe", "Android", "iOS", "Go", "Android Studio"});

    }
}
