package flybits.com.flybits;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import flybits.com.flybits.DummyData.DummyData;
import flybits.com.flybits.adapter.DummyAdapter;
import flybits.com.flybits.adapter.SkillAdapter;
import me.gujun.android.taggroup.TagGroup;

import android.content.SharedPreferences;

/**
 * Created by user on 2016-04-09.
 */
public class ProfileActivity extends FragmentActivity implements SeekBar.OnSeekBarChangeListener {
    private ListView listview;
    private SharedPreferences sharedPreferences;
    private SeekBar bar;
    private ImageView imageUrl;
    private TextView nameView;
    private TextView score;
    private int max = 100;
    private int min = 0;
    private int step = 1;
    private String name;
    private String photoUrl;
    private String[] skills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profileactivity);

        listview = (ListView) findViewById(R.id.listskill);
        sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);

        Intent intent = getIntent();
        photoUrl = intent.getStringExtra("photo_url");
        name = intent.getStringExtra("name");
        skills = intent.getStringArrayExtra("skills");

        imageUrl = (ImageView) findViewById(R.id.header_imageview);
        nameView = (TextView) findViewById(R.id.name);
        score = (TextView)findViewById(R.id.score);
        Picasso.with(this).load(photoUrl).into(imageUrl);
        nameView.setText(name);
        List<String> skillsArrayList = new ArrayList<>();
        for (int i=0; i<skills.length; i++) {
            skillsArrayList.add(skills[i]);
        }
        SkillAdapter adapter = new SkillAdapter(getApplicationContext(), skillsArrayList);
        listview.setAdapter(adapter);
        bar = (SeekBar)findViewById(R.id.seekBar1);
        bar.setOnSeekBarChangeListener(this);
        bar.setMax( (max - min) / step );
        if (sharedPreferences.getString(name, new String()).equals("")) {
            bar.setProgress(0);
        }
        else {
            double value = Double.parseDouble(sharedPreferences.getString(name, new String()));
            bar.setProgress((int)value);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int value = min + (progress * step);
        sharedPreferences.edit().putString(name, String.valueOf(value)).commit();
        score.setText(String.valueOf(value));
    }
}
