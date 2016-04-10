package flybits.com.flybits;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.flybits.core.api.Flybits;
import com.flybits.core.api.FlybitsOptions;
import com.flybits.core.api.context.FlybitsContext;
import com.flybits.core.api.context.contracts.ContextContract;
import com.flybits.core.api.context.plugins.AvailablePlugins;
import com.flybits.core.api.exceptions.FeatureNotSupportedException;
import com.flybits.core.api.exceptions.FlybitsPushException;
import com.flybits.core.api.interfaces.IRequestCallback;
import com.flybits.core.api.interfaces.IRequestGeneralCallback;
import com.flybits.core.api.interfaces.IRequestLoggedIn;
import com.flybits.core.api.interfaces.IRequestPaginationCallback;
import com.flybits.core.api.models.Pagination;
import com.flybits.core.api.models.Push;
import com.flybits.core.api.models.User;
import com.flybits.core.api.models.Zone;
import com.flybits.core.api.utils.filters.LoginOptions;
import com.flybits.core.api.utils.filters.ZoneOptions;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import me.gujun.android.taggroup.TagGroup;

public class ApplicationActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.applicationactivity);

        FlybitsOptions builder = new FlybitsOptions.Builder(this)
                //Additional Options Can Be Added Here
                .enableContextUploading(1, ContextContract.Priority.HIGH)
                //Allows the application to retrieve rules and their last evaluated values.
                .enableContextRules(1)
                .setDebug(true)
                .build();
        Flybits.include(this).initialize(builder);

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
                ApplicationActivity.this.startActivity(intent);
            }
        });
    }
}