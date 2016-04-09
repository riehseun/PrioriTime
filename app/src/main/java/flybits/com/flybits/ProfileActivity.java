package flybits.com.flybits;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.CallbackManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.net.URL;

/**
 * Created by user on 2016-04-09.
 */
public class ProfileActivity extends FragmentActivity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar bar;
    private ImageView imageUrl;
    private TextView nameView;
    private TextView timeView;
    private int max = 100;
    private int min = 0;
    private int step = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profileactivity);

        Intent intent = getIntent();
        String photoUrl = intent.getStringExtra("photo_url");
        String name = intent.getStringExtra("name");
        String time = intent.getStringExtra("time");

        imageUrl = (ImageView) findViewById(R.id.header_imageview);
        nameView = (TextView) findViewById(R.id.name);
        timeView = (TextView)findViewById(R.id.time);
        Picasso.with(this).load(photoUrl).into(imageUrl);
        nameView.setText(name);
        timeView.setText(time);

        bar = (SeekBar)findViewById(R.id.seekBar1);
        bar.setOnSeekBarChangeListener(this);
        bar.setMax( (max - min) / step );
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //Toast.makeText(this, "start", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //Toast.makeText(this, "stop", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        double value = min + (progress * step);
        //Toast.makeText(this, String.valueOf(value), Toast.LENGTH_SHORT).show();
        System.out.println("value: " + value);
    }
}
