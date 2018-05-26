package com.example.android.abnd_project4_musicalstructureapp;

import android.graphics.drawable.Drawable;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Music {
    private String mSongName;

    private String mArtistName;

    private String mAlbumName;

    private String mAlbumArt;

    /* Default Constructor
     * @param songName   is the name of the song
     * @param artistName is the name of the Artist
     * @param albumName  is the name of the Album
     * @param albumArt   is the name of the Album Art resource
     */
    public Music() {
        mSongName = "";
        mArtistName = "";
        mAlbumName = "";
        mAlbumArt = "";
    }

    /**
     * Create a new Music object.
     *
     * @param songName   is the name of the song
     * @param artistName is the name of the Artist
     * @param albumName  is the name of the Album
     * @param albumArt   is the name of the Album Art resource
     */
    public Music(String songName, String artistName, String albumName, String albumArt) {
        mSongName = songName;
        mArtistName = artistName;
        mAlbumName = albumName;
        mAlbumArt = albumArt;
    }

    /**
     * Get the name of the song
     */
    public String getSongName() {
        return mSongName;
    }

    /**
     * Set the name of the song
     *
     * @param songName is the name of the Song
     */
    public void setSongName(String songName) {
        mSongName = songName;
    }

    /**
     * Get the name of the Artist
     */
    public String getArtist() {
        return mArtistName;
    }

    /**
     * Set the name of the Artist
     *
     * @param artistName is the name of the Artist
     */
    public void setArtist(String artistName) {
        mArtistName = artistName;
    }

    /**
     * Get the name of the Album
     */
    public String getAlbum() {
        return mAlbumName;
    }

    /**
     * Set the name of the Album
     *
     * @param albumName is the name of the Album
     */
    public void setAlbum(String albumName) {
        mAlbumName = albumName;

    }

    /**
     * Get the name of the Album Art Resource     *
     */
    public String getAlbumArt() {
        return mAlbumArt;
    }

    /**
     * Set the name of the Album Art Resource
     *
     * @param albumArt is the name of the album art asset
     */
    public void setAlbumArt(String albumArt) {
        mAlbumArt = albumArt;
    }

}
