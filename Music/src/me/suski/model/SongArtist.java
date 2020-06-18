package me.suski.model;

public class SongArtist {

    private String artistName;
    private String albumName;
    private int track;

    public SongArtist(String artistName, String albumName, int track) {
        this.artistName = artistName;
        this.albumName = albumName;
        this.track = track;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SongArtist{");
        sb.append("artistName='").append(artistName).append('\'');
        sb.append(", albumName='").append(albumName).append('\'');
        sb.append(", track=").append(track);
        sb.append('}');
        return sb.toString();
    }
}
