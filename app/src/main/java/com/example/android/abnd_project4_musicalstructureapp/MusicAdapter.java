package com.example.android.abnd_project4_musicalstructureapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.music_item, parent, false);
        }

        // Get the Music object located at this position in the list
        Music currentSong = getItem(position);

        // Find the TextView in the music_item.xml layout with the ID song_name_textView
        TextView songNameTextView = (TextView) listItemView.findViewById(R.id.song_name_textView);
        // Get the name of the Song from the current Music object and
        // set this text on the name TextView
        songNameTextView.setText(currentSong.getSongName());

        // Find the TextView in the music_item.xml layout with the ID artist_name_textView
        TextView artistNameTextView = (TextView) listItemView.findViewById(R.id.artist_name_textView);
        // Get the default translation from the current Word object and
        // set this text on the number TextView
        artistNameTextView.setText(currentSong.getArtist());

        // Find the TextView in the music_item.xml layout with the ID album_name_textView
        TextView albumNameTextView = (TextView) listItemView.findViewById(R.id.album_name_textView);
        // Get the default translation from the current Word object and
        // set this text on the number TextView
        albumNameTextView.setText(currentSong.getAlbum());

        // Return the whole music item layout (containing 3 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
