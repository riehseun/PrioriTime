package flybits.com.flybits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import me.gujun.android.taggroup.TagGroup;

public class PersonalTagsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personaltagsactivity);

        CircleImageView circle = (CircleImageView) findViewById(R.id.profile_image);
        Picasso.with(this)
                .load("https://randomuser.me/api/portraits/men/81.jpg")
                .into(circle);

        TagGroup mTagGroup = (TagGroup) findViewById(R.id.tag_group);
        mTagGroup.setTags(new String[]{"Java", "Python", "Software Developer",
                "JavaScript", "Flybit", "Database", "SQL", "Finance", "Banking", "Engineer",
                "Adobe", "Android", "iOS", "Go", "Android Studio"});

        Button button = (Button) findViewById(R.id.confirm);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EventActivity.class);
                PersonalTagsActivity.this.startActivity(intent);
            }
        });
    }
}
