package flybits.com.flybits;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import flybits.com.flybits.DummyData.DummyData;
import flybits.com.flybits.DummyData.DummyData2;
import flybits.com.flybits.adapter.ContactAdapter;
import flybits.com.flybits.adapter.EventAdapter;
import flybits.com.flybits.app.AppController;

/**
 * Created by user on 2016-04-09.
 */
public class EventActivity extends AppCompatActivity {
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventactivity);

        listview = (ListView) findViewById(R.id.listevent);

        EventAdapter adapter = new EventAdapter(this, DummyData2.getDummyData());
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), EventTagsActivity.class);
                /*
                Bundle b = new Bundle();
                b.putString("photo_url", DummyData.getDummyData().get(position).getProfileUrl());
                b.putString("name", DummyData.getDummyData().get(position).getProfileName());
                b.putString("time", String.valueOf(DummyData.getDummyData().get(position).getAmountTimeSpent()));
                intent.putExtras(b);
                */
                EventActivity.this.startActivity(intent);
            }
        });
    }
}
