package flybits.com.flybits.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import flybits.com.flybits.R;
import flybits.com.flybits.adapter.ContactAdapter;
import flybits.com.flybits.app.AppController;
import flybits.com.flybits.model.FBFriend;

public class ApplicationActivity extends AppCompatActivity {
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.applicationactivity);
        setTitle("");

        AppController appController = new AppController();

        listview = (ListView) findViewById(R.id.listcontact);

        ArrayList<FBFriend> Friends = new ArrayList<FBFriend>();
        for (int i = 0; i < 10; i++) {
            FBFriend contact = new FBFriend();
            contact.setProfileUrl("Test");
            contact.setAmountTimeSpent(80);
            Friends.add(contact);
        }

        ContactAdapter adapter = new ContactAdapter(this, Friends);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ApplicationActivity.this, "touch works!!", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(this, DisplayMessageActivity.class);
//                Bundle b = new Bundle();
//                b.putString("photourl", imageurl);
//                intent.putExtras(b);
//                startActivity(intent);
            }
        });
    }
}
