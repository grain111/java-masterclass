package me.suski;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dev on 18/09/15.
 */
public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration) {
        if(songs.findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }


    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber -1;
        if((index >= 0) && (index <= this.songs.size())) {
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = songs.findSong(title);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }


    private class SongList {
        private List<Song> list = new LinkedList<>();

        public Song get(int index) {
            return list.get(index);
        }

        public Song findSong(String title) {
            for(Song checkedSong: this.list) {
                if(checkedSong.getTitle().equals(title)) {
                    return checkedSong;
                }
            }
            return null;
        }

        public int size() {
            return this.list.size();
        }

        public void add(Song song) {
            this.list.add(song);
        }
    }



















}
