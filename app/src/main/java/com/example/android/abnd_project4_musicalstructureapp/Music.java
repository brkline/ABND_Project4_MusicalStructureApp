package com.example.android.abnd_project4_musicalstructureapp;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Music {
    private String mSongName;

    private String mArtistName;

    private String mAlbumName;

    private boolean mPlaying;

    private ArrayAdapter<String> mNowPlaying;

    /* Default Constructor */
    public Music() {
        mSongName = "";
        mArtistName = "";
        mAlbumName = "";
        mPlaying = false;
    }

    /**
     * Create a new Music object.
     *
     * @param songName           is the name of the song
     * @param artistName         is the name of the Artist
     * @param albumName          is the name of the Album
     */
    public Music(String songName, String artistName, String albumName) {
        mSongName = songName;
        mArtistName = artistName;
        mAlbumName = albumName;
        mPlaying = false;
    }

    public Music(String songName, String artistName, String albumName, boolean playing) {
        mSongName = songName;
        mArtistName = artistName;
        mAlbumName = albumName;
        mPlaying = playing;
    }

    /**
     * Get the name of the song
     */
    public String getSongName() {
        return mSongName;
    }

    /**
     * Get the name of the Artist
     */
    public String getArtist() {
        return mArtistName;
    }

    /**
     * Set the name of the Artist
     */
    public String getAlbum() {
        return mAlbumName;
    }
    /**
     * Set the name of the song
     */
    public void setSongName(String songName) {
        mSongName = songName;
    }

    /**
     * Set the name of the Artist
     */
    public void setArtist(String artistName) {
        mArtistName = artistName;
    }

    /**
     * Get the name of the Album
     */
    public void setAlbum(String albumName)
    {
        mAlbumName = albumName;

    }
    /**
     * Get the current Play/Pause status
     */
    public boolean getPlayingStatus() {
        return mPlaying;
    }

    /**
     * Set the current Play/Pause Status
     */
    public void setPlayingStatus(boolean pauseStatus) {

        if (pauseStatus) {
            mPlaying = true;
        } else {
            mPlaying = false;
        }
    }
}
