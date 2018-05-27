package com.example.android.abnd_project4_musicalstructureapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Set;

public class DetailsActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        context = this;
        // Code below is based on: https://stackoverflow.com/a/44186705/9645654
        // and https://stackoverflow.com/a/30145642/9645654
        Intent intent = this.getIntent();
        if (intent != null) {
            TextView songName_tv = findViewById(R.id.details_song_name_tv);
            TextView artistName_tv = findViewById(R.id.details_artist_name_tv);
            TextView albumName_tv = findViewById(R.id.details_album_name_tv);
            ImageView albumArt_iv = findViewById(R.id.album_art);

            songName_tv.setText(intent.getStringExtra("SongName"));
            artistName_tv.setText(intent.getStringExtra("ArtistName"));
            albumName_tv.setText(intent.getStringExtra("AlbumName"));
            // Code below is based on https://stackoverflow.com/a/20021447/9645654
            String drawableName = intent.getStringExtra("AlbumArt");
            albumArt_iv.setImageResource(getDrawableImageID(drawableName));
            // End attribution
            setTitle(intent.getStringExtra("ActivityTitle"));
        }
        // End attribution

        // Set an onClickListener so we can return to the Main Activity
        Button songsButton = findViewById(R.id.song_list_button);
        songsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context onClickcontext = v.getContext();
                Intent mainActivityIntent = new Intent(new Intent(onClickcontext, MainActivity.class));
                onClickcontext.startActivity(mainActivityIntent);

            }
        });
    }



                // Code below is based on https://stackoverflow.com/a/20021447/9645654
                /**
                 * Get the Image ID for the drawable
                 */
        public int getDrawableImageID (String drawable){
            return context.getResources().getIdentifier(drawable, "drawable", context.getPackageName());
        }
        // End attribution
    }
