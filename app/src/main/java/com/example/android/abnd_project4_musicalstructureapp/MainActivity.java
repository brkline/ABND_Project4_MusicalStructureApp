package com.example.android.abnd_project4_musicalstructureapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView playPauseButton;
    boolean isPaused = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Music> music = new ArrayList<>();

        music.add(new Music("Song1", "Artist1", "Album1"));
        music.add(new Music("Song2", "Artist2", "Album2"));
        music.add(new Music("Song3", "Artist3", "Album3"));
        music.add(new Music("Song4", "Artist4", "Album4"));
        music.add(new Music("Song5", "Artist5", "Album5"));
        music.add(new Music("Song6", "Artist6", "Album6"));
        music.add(new Music("Song7", "Artist7", "Album7"));
        music.add(new Music("Song8", "Artist8", "Album8"));
        music.add(new Music("Song9", "Artist9", "Album9"));
        music.add(new Music("Song10", "Artist10", "Album10"));
        music.add(new Music("Song11", "Artist11", "Album11"));
        music.add(new Music("Song12", "Artist12", "Album12"));
        music.add(new Music("Song13", "Artist13", "Album13"));
        music.add(new Music("Song14", "Artist14", "Album14"));
        music.add(new Music("Song15", "Artist15", "Album15"));
        music.add(new Music("Song16", "Artist16", "Album16"));
        music.add(new Music("Song17", "Artist17", "Album17"));
        music.add(new Music("Song18", "Artist18", "Album18"));
        music.add(new Music("Song19", "Artist19", "Album19"));
        music.add(new Music("Song20", "Artist20", "Album20"));
        music.add(new Music("Song21", "Artist21", "Album21"));
        music.add(new Music("Song22", "Artist22", "Album22"));
        music.add(new Music("Song23", "Artist23", "Album23"));

        // Create an {@link MusicAdapter}, whose data source is a list of {@link Music}. The
        // adapter knows how to create list items for each item in the list.
        final MusicAdapter adapter = new MusicAdapter(this, music);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called music_list, which is declared
        // in the music_list layout file.
        final ListView listView = findViewById(R.id.music_list);

        // Make the {@link ListView} use the {@link MusicAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Music} in the list.
        listView.setAdapter(adapter);
    }
}
