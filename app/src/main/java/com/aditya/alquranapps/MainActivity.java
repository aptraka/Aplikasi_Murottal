package com.aditya.alquranapps;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    ListView list;
    String[] namasurat = {
            "An Nas",
            "Al Falaq",
            "Al Ikhlas"
    };
    int[] suarasurat = {
            R.raw.annas,
            R.raw.alfalaq,
            R.raw.alikhlas
    };
    int[] gambarsurat = {
            R.drawable.ic_launcher_background,
            0,
            R.drawable.ic_launcher_background
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = new MediaPlayer();
        list = findViewById(R.id.listView_item);
        CustomAdapter adapter = new CustomAdapter(MainActivity.this, namasurat, gambarsurat);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                playSurah(position);
            }
        });
    }

    private void playSurah(int position) {
        mp.reset();
        mp = MediaPlayer.create(MainActivity.this, suarasurat[position]);
        mp.start();
    }

}
