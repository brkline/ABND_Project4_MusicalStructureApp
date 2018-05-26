package com.example.android.abnd_project4_musicalstructureapp;

public class Music {
    private String mSongName;

    private String mArtistName;

    private String mAlbumName;

    private String mAlbumArt;

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
     * Get the name of the Artist
     */
    public String getArtist() {
        return mArtistName;
    }

    /**
     * Get the name of the Album
     */
    public String getAlbum() {
        return mAlbumName;
    }

    /**
     * Get the name of the Album Art Resource     *
     */
    public String getAlbumArt() {
        return mAlbumArt;
    }

}
