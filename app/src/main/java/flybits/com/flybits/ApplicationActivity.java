package flybits.com.flybits;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import flybits.com.flybits.app.AppController;

public class ApplicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.applicationactivity);

        AppController appController = new AppController();


    }
}
