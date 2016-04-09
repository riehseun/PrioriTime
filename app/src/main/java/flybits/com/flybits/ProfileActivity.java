package flybits.com.flybits;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.squareup.picasso.Picasso;

/**
 * Created by user on 2016-04-09.
 */
public class ProfileActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar bar;
    private ImageView imageUrl;
    private int max = 100;
    private int min = 0;
    private int step = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profileactivity);

        Intent intent = getIntent();
        String photoUrl = intent.getStringExtra("photo_url");
        System.out.println("photoUrl: " + photoUrl);

        imageUrl = (ImageView) findViewById(R.id.header_imageview);
        Picasso.with(this).load(photoUrl).into(imageUrl);

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
