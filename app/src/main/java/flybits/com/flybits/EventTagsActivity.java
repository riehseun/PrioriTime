package flybits.com.flybits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class EventTagsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventtagsactivity);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FriendActivity.class);
                EventTagsActivity.this.startActivity(intent);
            }
        });

        ImageView event = (ImageView) findViewById(R.id.eventimage);

        Picasso.with(this)
                .load("https://world.apps-world.net/files/92363-400x200-flybits_new_logo.jpg")
                .into(event);
    }
}
