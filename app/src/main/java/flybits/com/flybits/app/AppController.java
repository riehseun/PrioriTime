package flybits.com.flybits.app;

import android.app.Application;

import com.flybits.core.api.Flybits;
import com.flybits.core.api.FlybitsOptions;

/**
 * Created by user on 2016-04-08.
 */
public class AppController extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FlybitsOptions builder = new FlybitsOptions.Builder(this)
                //Additional Options Can Be Added Here
                .build();

        //Initialize the FlybitsOptions
        Flybits.include(this).initialize(builder);
    }

    public void methodOne() {
        Flybits.
    }
}
