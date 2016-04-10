package flybits.com.flybits;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.flybits.core.api.Flybits;
import com.flybits.core.api.interfaces.IRequestPaginationCallback;
import com.flybits.core.api.models.Pagination;
import com.flybits.core.api.models.Zone;
import com.flybits.core.api.utils.filters.ZoneOptions;

import java.util.ArrayList;

import flybits.com.flybits.adapter.EventAdapter;

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

        getZone();
    }

    public void getZone() {
        ZoneOptions options  = new ZoneOptions.Builder()
                .build();

        Flybits.include(this).getZones(options, new IRequestPaginationCallback<ArrayList<Zone>>() {
            @Override
            public void onSuccess(final ArrayList<Zone> data, Pagination pagination) {
                EventAdapter adapter = new EventAdapter(getApplicationContext(), data);
                listview.setAdapter(adapter);

                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(view.getContext(), FriendActivity.class);

                        Bundle b = new Bundle();
                        b.putString("zone_id", data.get(position).id);
                        intent.putExtras(b);

                        EventActivity.this.startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailed(String reason) {

            }

            @Override
            public void onException(Exception exception) {

            }

            @Override
            public void onCompleted() {

            }
        });
    }

}
