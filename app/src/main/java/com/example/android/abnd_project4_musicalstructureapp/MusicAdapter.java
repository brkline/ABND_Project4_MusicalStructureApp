package com.example.android.abnd_project4_musicalstructureapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicAdapter extends ArrayAdapter<Music> {

    private ImageView mCurrentlyPlaying;
    private int playIcon = R.drawable.baseline_play_circle_filled_white_black_48;
    private int currentDrawable = 0;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param music   A List of Music objects to display in a list
     */
    public MusicAdapter(Activity context, ArrayList<Music> music) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, music);
    }

    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.music_item, parent, false);
        }

        // Get the Music object located at this position in the list
        final Music currentItem = getItem(position);

        final ImageView playPauseButton = listItemView.findViewById(R.id.play_pause_button);
        playPauseButton.setImageResource(R.drawable.baseline_play_circle_filled_white_black_48);
        playPauseButton.setTag(R.drawable.baseline_play_circle_filled_white_black_48);

        // Process a click for the Play/Pause button
        playPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Resets the icon on a previously selected item
                // Code below based on gist provided by mentor, Carlos
                // https://gist.github.com/crlsndrsjmnz/7f6784b5dd8a51cd8db98d170f2b603a
                if (mCurrentlyPlaying != null && mCurrentlyPlaying != playPauseButton) {
                    mCurrentlyPlaying.setImageResource(R.drawable.baseline_play_circle_filled_white_black_48);
                    mCurrentlyPlaying.setTag(R.drawable.baseline_play_circle_filled_white_black_48);

                }
                // End attribution

                // Get the current selected item's Drawable for comparison later
                if (playPauseButton.getTag() != null) {
                    currentDrawable = (int) playPauseButton.getTag();
                }

                // We need to set the appropriate icon.  If the current icon is play, then we need to
                // set it to pause and vice versa.  This allows us to handle the fact that the user may
                // click on the same item twice.
                // Code below based on gist provided by mentor, Carlos
                // https://gist.github.com/crlsndrsjmnz/7f6784b5dd8a51cd8db98d170f2b603a
                if (currentDrawable == playIcon) {
                    playPauseButton.setImageResource(R.drawable.baseline_pause_black_48);
                    playPauseButton.setTag(R.drawable.baseline_pause_black_48);
                } else {
                    playPauseButton.setImageResource(R.drawable.baseline_play_circle_filled_white_black_48);
                    playPauseButton.setTag(R.drawable.baseline_play_circle_filled_white_black_48);
                }

                // Save the current item for use on the next click event
                mCurrentlyPlaying = playPauseButton;
                // End attribution

            }
        });

        final Button detailsButton = listItemView.findViewById(R.id.details_button);
        // Handle a Details button click
        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When the user presses the details button, we need to pass in the values to
                // the activity and start it
                // Code below based on: https://stackoverflow.com/a/15941755/9645654
                // and https://stackoverflow.com/a/30145642/9645654
                Context onClickcontext = getContext();
                Intent detailsIntent = new Intent(new Intent(onClickcontext, DetailsActivity.class));
                detailsIntent.putExtra("SongName", currentItem.getSongName());
                detailsIntent.putExtra("AlbumName", currentItem.getAlbum());
                detailsIntent.putExtra("ArtistName", currentItem.getArtist());
                detailsIntent.putExtra("AlbumArt", currentItem.getAlbumArt());
                // End attribution

                // Get the current selected item's Drawable
                if (playPauseButton.getTag() != null) {
                    currentDrawable = (int) playPauseButton.getTag();
                }

                // We will use this value in the Details activity to indicate if the
                // current selection is playing
                if (currentDrawable == playIcon) {
                    detailsIntent.putExtra("ActivityTitle", "Details");
                } else {
                    detailsIntent.putExtra("ActivityTitle", "Now Playing");
                }

                // Code below based on: https://stackoverflow.com/a/15941755/9645654
                // and https://stackoverflow.com/a/30145642/9645654
                onClickcontext.startActivity(detailsIntent);
                // End attribution

            }
        });

        // Find the TextView in the music_item.xml layout with the ID song_name_textView
        TextView songNameTextView = listItemView.findViewById(R.id.song_name_textView);
        // Get the name of the Song from the current Music object and set this text on the
        // song name TextView
        songNameTextView.setText(currentItem.getSongName());

        // Find the TextView in the music_item.xml layout with the ID artist_name_textView
        TextView artistNameTextView = listItemView.findViewById(R.id.artist_name_textView);
        // Get the Artist of the song from the current Music object and set this text on the
        // artist name TextView
        artistNameTextView.setText(currentItem.getArtist());

        // Find the TextView in the music_item.xml layout with the ID album_name_textView
        TextView albumNameTextView = listItemView.findViewById(R.id.album_name_textView);
        // Get the Album of the song from the current Music object and set this text on the
        // on the album name TextView
        albumNameTextView.setText(currentItem.getAlbum());

        // Return the whole music item layout (containing 3 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }



}
