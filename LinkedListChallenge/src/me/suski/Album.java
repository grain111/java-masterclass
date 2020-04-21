package me.suski;

import java.util.ArrayList;

public class Album {
    private String name;
    private ArrayList<Song> songs;

    public Album(String name) {
        this.name = name;
        songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void printSongs() {
        System.out.println("Songs:");
        for (int i=0; i<songs.size(); i++) {
            System.out.println(i + " --> " + songs.get(i).getTitle());
        }
    }

    public boolean addSong(String title, double dur) {
        Song song = getSong(title);
        if (song == null) {
            songs.add(new Song(title, dur));
            return true;
        }
        return false;
    }

    public Song getSong(String songTitle) {
        for (int i=0; i<songs.size(); i++) {
            if (songs.get(i).getTitle().equals(songTitle)) {
                return songs.get(i);
            }
        }
        return null;
    }

    public Song getSong(int i) {
        if (i < songs.size()) {
            return songs.get(i);
        }
        return null;
    }
}
