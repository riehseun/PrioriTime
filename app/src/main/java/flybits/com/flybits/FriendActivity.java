package flybits.com.flybits;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import flybits.com.flybits.DummyData.DummyData;
import flybits.com.flybits.adapter.ContactAdapter;
import flybits.com.flybits.app.AppController;

/**
 * Created by user on 2016-04-09.
 */
public class FriendActivity extends AppCompatActivity{
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friendactivity);
        setTitle("");

        AppController appController = new AppController();

        listview = (ListView) findViewById(R.id.listcontact);

        ContactAdapter adapter = new ContactAdapter(this, DummyData.getDummyData());
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(ApplicationActivity.this, "touch works!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), ProfileActivity.class);
                Bundle b = new Bundle();
                b.putString("photo_url", DummyData.getDummyData().get(position).getProfileUrl());
                b.putString("name", DummyData.getDummyData().get(position).getProfileName());
                b.putString("time", String.valueOf(DummyData.getDummyData().get(position).getAmountTimeSpent()));
                intent.putExtras(b);
                FriendActivity.this.startActivity(intent);
            }
        });
    }
}
