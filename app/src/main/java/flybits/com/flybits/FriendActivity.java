package flybits.com.flybits;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.flybits.core.api.Flybits;
import com.flybits.core.api.context.FlybitsContext;
import com.flybits.core.api.context.contracts.ContextContract;
import com.flybits.core.api.context.plugins.AvailablePlugins;
import com.flybits.core.api.exceptions.FeatureNotSupportedException;
import com.flybits.core.api.interfaces.IRequestCallback;
import com.flybits.core.api.interfaces.IRequestGeneralCallback;
import com.flybits.core.api.interfaces.IRequestLoggedIn;
import com.flybits.core.api.models.User;
import com.flybits.core.api.utils.filters.LoginOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import flybits.com.flybits.DummyData.DummyData;
import flybits.com.flybits.adapter.ContactAdapter;
import flybits.com.flybits.adapter.DummyAdapter;
import flybits.com.flybits.app.AppController;

/**
 * Created by user on 2016-04-09.
 */
public class FriendActivity extends AppCompatActivity{
    private ListView listview;
    private String zoneId;
    //private static final String JWT = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiI5RTc1QkE4My0xOUZCLTQ3NjktQUY4My1BQjMyNDBFMERCQzYiLCJ0ZW5hbnRJZCI6IkU5OUUzNDdBLTYyOEYtNDNGNC1BMTVCLTRGODBDMURGNTI3MSIsImFwaUtleSI6IkMxQzBGOURFLUI4RkMtNDBENy1BOTRFLTY3MDZCMEIzOTRDMCIsImRldmljZUlkIjoiMDQwMjMwQTYtQ0RDRS00NDdELTk1QzYtOEYxNzMyRDhFNDgxIiwiZXhwaXJlc0F0IjoiMTQ2MDMwODY2OCIsInBoeXNpY2FsRGV2aWNlSWQiOiI3M2Y2Mjg1NDA0MjFkMjM2IiwidHlwZSI6IkFuZHJvaWQiLCJkYXRhIjoie1wiVXNlcklkXCI6XCI5RTc1QkE4My0xOUZCLTQ3NjktQUY4My1BQjMyNDBFMERCQzZcIixcIlRlbmFudElkXCI6XCJFOTlFMzQ3QS02MjhGLTQzRjQtQTE1Qi00RjgwQzFERjUyNzFcIixcIkFwaUtleVwiOlwiQzFDMEY5REUtQjhGQy00MEQ3LUE5NEUtNjcwNkIwQjM5NEMwXCIsXCJEZXZpY2VJZFwiOlwiMDQwMjMwQTYtQ0RDRS00NDdELTk1QzYtOEYxNzMyRDhFNDgxXCIsXCJFeHBpcmVzQXRcIjoxNDYwMzA4NjY4LFwiUGh5c2ljYWxEZXZpY2VJZFwiOlwiNzNmNjI4NTQwNDIxZDIzNlwiLFwiVHlwZVwiOjF9IiwiaXNzIjoiaHR0cHM6Ly9kZW1vX3NldV9hYjQ4YzA3Ny5mbHliaXRzLmNvbSIsImF1ZCI6Imh0dHBzOi8vZGVtb19zZXVfYWI0OGMwNzcuZmx5Yml0cy5jb20iLCJleHAiOjE0NjAzMDg2NjgsIm5iZiI6MTQ2MDMwNjc0OH0.tQ-PeHkKpUlcqpy3Bc0optykFd9ozcS_NFCPQS9tenY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friendactivity);

        listview = (ListView) findViewById(R.id.listcontact);

        Intent intent = getIntent();
        zoneId = intent.getStringExtra("zone_id");
        getToken();
    }

    public void sendRequest(String zoneId, final String jwt) {
        String url = "https://gateway.flybits.com/location/zone/" + zoneId;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(final String response) {

                        Log.d("response", response);
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();

                        DummyAdapter adapter = new DummyAdapter(getApplicationContext(), DummyData.getDummyData());
                        listview.setAdapter(adapter);

                        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent = new Intent(view.getContext(), ProfileActivity.class);
                                Bundle b = new Bundle();
                                b.putString("photo_url", DummyData.getDummyData().get(position).getProfileUrl());
                                b.putString("name", DummyData.getDummyData().get(position).getProfileName());
                                b.putStringArray("skills", DummyData.getDummyData().get(position).getSkills());
                                intent.putExtras(b);
                                FriendActivity.this.startActivity(intent);
                            }
                        });
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Error handling
                Log.d("error", "Something went wrong!");
                error.printStackTrace();
            }
        }) {
            @Override
            public Map<String,String> getHeaders(){
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                headers.put("X-Authorization",jwt);
                headers.put("User-agent", "My useragent");
                return headers;
            }
        };

        // Add the request to the queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    public void getToken() {
        Flybits.include(this).isUserLoggedIn(true, new IRequestLoggedIn() {
            @Override
            public void onLoggedIn(User user) {
                Flybits.include(getApplicationContext()).refreshJWT(new IRequestGeneralCallback() {
                    @Override
                    public void onSuccess() {
                        FlybitsContext contextObj = new FlybitsContext(AvailablePlugins.LOCATION, 60000, ContextContract.Priority.LOW);
                        try {
                            Flybits.include(getApplicationContext()).activateContext(null, contextObj);
                        } catch (FeatureNotSupportedException e) {
                            e.printStackTrace();
                        }
                        String jwt = Flybits.include(getApplicationContext()).getSavedJWTToken();
                        Log.d("JWT", jwt);
                        sendRequest(zoneId, jwt);
                    }

                    @Override
                    public void onException(Exception e) {

                    }

                    @Override
                    public void onFailed(String s) {

                    }

                    @Override
                    public void onCompleted() {

                    }
                });
            }

            @Override
            public void onNotLoggedIn() {
                LoginOptions options = new LoginOptions.Builder(getApplicationContext())
                        .loginAnonymously()
                        .setDeviceOSVersion()
                        .setRememberMeToken()
                        .build();

                Flybits.include(getApplicationContext()).login(options, new IRequestCallback<User>() {
                    @Override
                    public void onSuccess(User data) {
                        FlybitsContext contextObj = new FlybitsContext(AvailablePlugins.LOCATION, 60000, ContextContract.Priority.LOW);
                        try {
                            Flybits.include(getApplicationContext()).activateContext(null, contextObj);
                        } catch (FeatureNotSupportedException e) {
                            e.printStackTrace();
                        }
                        Log.d("JWT", data.jwtToken);
                        sendRequest(zoneId, data.jwtToken);
                        /*
                        Intent intent = new Intent(getApplicationContext(), PersonalTagsActivity.class);
                        Bundle b = new Bundle();
                        b.putString("jwt", data.jwtToken);
                        intent.putExtras(b);
                        EventActivity.this.startActivity(intent);
                        */
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
        });
    }

}
