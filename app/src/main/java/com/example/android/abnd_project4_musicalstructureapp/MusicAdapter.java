package com.example.android.abnd_project4_musicalstructureapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicAdapter extends ArrayAdapter<Music> {

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context       The current context. Used to inflate the layout file.
     * @param music         A List of Music objects to display in a list
     */
    public MusicAdapter(Activity context, ArrayList<Music> music) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context,0, music);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Music lastItem = new Music();
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.music_item, parent, false);
        }

        // Get the Music object located at this position in the list
        final Music currentItem = getItem(position);

        ImageView playPauseButton = listItemView.findViewById(R.id.play_pause_button);
        final boolean isPlaying = currentItem.getPlayingStatus();

        if (isPlaying) {
            playPauseButton.setImageResource(R.drawable.baseline_pause_black_48);
        } else {
            playPauseButton.setImageResource(R.drawable.baseline_play_circle_filled_white_black_48);
        }


        playPauseButton.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {

                Log.d("PlayStatus", "Clicked");
                // I know it's backwards but when we're playing, we need to
                // set the status to off so that the correct icon displays and
                // the status gets changed the next time an item is clicked
                if (isPlaying) {
                    currentItem.setPlayingStatus(false);
                } else {
                    currentItem.setPlayingStatus(true);
                }
                Music lastItem = new Music(currentItem.getSongName(), currentItem.getArtist(),
                        currentItem.getAlbum(), false);
                notifyDataSetChanged();
            }
        });

        final Button detailsButton = listItemView.findViewById(R.id.details_button);
        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code below based on: https://stackoverflow.com/a/15941755/9645654
                // and https://stackoverflow.com/a/30145642/9645654
                Context onClickcontext = getContext();
                Intent detailsIntent = new Intent(new Intent(onClickcontext, DetailsActivity.class));
                detailsIntent.putExtra("SongName",currentItem.getSongName());
                detailsIntent.putExtra("AlbumName",currentItem.getAlbum());
                detailsIntent.putExtra("ArtistName",currentItem.getArtist());
                detailsIntent.putExtra("Playing",currentItem.getPlayingStatus());
                onClickcontext.startActivity(detailsIntent);
            }
        });


            // This piece of code is based on : https://jmsliu.com/2444/click-button-in-listview-and-get-item-position.html
            //playPauseButton.setOnClickListener(playPauseButtonOnClickListener);

        // Find the TextView in the music_item.xml layout with the ID song_name_textView
        TextView songNameTextView = (TextView) listItemView.findViewById(R.id.song_name_textView);
        // Get the name of the Song from the current Music object and
        // set this text on the name TextView
        songNameTextView.setText(currentItem.getSongName());

        // Find the TextView in the music_item.xml layout with the ID artist_name_textView
        TextView artistNameTextView = (TextView) listItemView.findViewById(R.id.artist_name_textView);
        // Get the default translation from the current Word object and
        // set this text on the number TextView
        artistNameTextView.setText(currentItem.getArtist());

        // Find the TextView in the music_item.xml layout with the ID album_name_textView
        TextView albumNameTextView = (TextView) listItemView.findViewById(R.id.album_name_textView);
        // Get the default translation from the current Word object and
        // set this text on the number TextView
        albumNameTextView.setText(currentItem.getAlbum());

        // Return the whole music item layout (containing 3 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }

    // This method is based on : https://jmsliu.com/2444/click-button-in-listview-and-get-item-position.html
    private View.OnClickListener playPauseButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final boolean isPaused = true;

            View parentRowView = (View) view.getParent();
            ListView musicListView = (ListView)parentRowView.getParent();
            final int position = musicListView.getPositionForView(parentRowView);
            Button playPauseButton = (Button) musicListView.findViewById(R.id.play_pause_button);
            // Set the appropriate image resource based on whether or not we are paused

        }
    };
}
