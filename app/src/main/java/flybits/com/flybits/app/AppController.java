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
import java.util.concurrent.ExecutorService;

/**
 * Created by user on 2016-04-08.
 */
public class AppController extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        FlybitsOptions builder = new FlybitsOptions.Builder(this)
                //Additional Options Can Be Added Here
                .build();
        AppController.context = getApplicationContext();
        //Initialize the FlybitsOptions
        Flybits.include(this).initialize(builder);
    }

    public void createZones() {
        Zone zone = new Zone();
    }

    public static void getZones() {
        ZoneOptions options  = new ZoneOptions.Builder()
                .build();

        Flybits.include(context).getZones(options, new IRequestPaginationCallback<ArrayList<Zone>>() {
            @Override
            public void onSuccess(ArrayList<Zone> data, Pagination pagination) {
                //Some Logic on UI Thread
                System.out.println(data);
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
    }
}
