package flybits.com.flybits.app;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.flybits.core.api.Flybits;
import com.flybits.core.api.FlybitsOptions;
import com.flybits.core.api.interfaces.IRequestPaginationCallback;
import com.flybits.core.api.models.Pagination;
import com.flybits.core.api.models.Zone;
import com.flybits.core.api.utils.filters.ZoneOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
/**
 * Created by user on 2016-04-08.
 */
public class AppController extends Application {
    public static final String TAG = AppController.class.getSimpleName();

    private static Context context;
    private static ArrayList<Zone> zones;

    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private static AppController mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        FlybitsOptions builder = new FlybitsOptions.Builder(this)
                //Additional Options Can Be Added Here
                .build();
        AppController.context = getApplicationContext();
        //Initialize the FlybitsOptions
        Flybits.include(this).initialize(builder);

        mInstance = this;
    }

    public static List<Zone> getZone() {
        final List<Zone> zones = new ArrayList<>();

        ZoneOptions options  = new ZoneOptions.Builder()
                .build();

        Flybits.include(context).getZones(options, new IRequestPaginationCallback<ArrayList<Zone>>() {
            @Override
            public void onSuccess(ArrayList<Zone> data, Pagination pagination) {
                System.out.println("DATA size: " + data.size());
                zones.addAll(data);
            }

            @Override
            public void onFailed(String reason) {
                System.out.println("fail");
            }

            @Override
            public void onException(Exception exception) {
                System.out.println("exception");
            }

            @Override
            public void onCompleted() {
                //Clean up function on UI Thread
            }
        });

        return zones;
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
