package me.suski;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);
    private static ArrayList<Album> albums = new ArrayList<>();
    private static LinkedList<Song> playlist = new LinkedList<>();

    public static void main(String[] args) {
        Album lona1 = new Album("Nawiasem mówiąc");
        albums.add(lona1);
        lona1.addSong("Hałas", 15);
        lona1.addSong("Gdzie tak pięknie", 25);
        lona1.addSong("Błąd", 36);

        Album ezra2 = new Album("Staying at Tamara's");
        albums.add(ezra2);
        ezra2.addSong("Pretty Shining people", 25);
        ezra2.addSong("Don't matter now", 26);
        ezra2.addSong("Get away", 24);

        playlist.add(ezra2.getSong(0));
        playlist.add(ezra2.getSong(1));
        playlist.add(ezra2.getSong(2));
        playlist.add(lona1.getSong(0));
        playlist.add(lona1.getSong(1));

        ListIterator<Song> iter = playlist.listIterator();


        boolean quit = false;
        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = s.nextInt();
            s.nextLine();
            switch (choice) {
                case 1:
                    // print list of albums
                    System.out.println("Albums:");
                    for (int i = 0; i < albums.size(); i++) {
                        System.out.println(i + " --> " + albums.get(i).getName());
                    }
                    break;
                case 2:
                    // add song to playlist
                    System.out.print("Specify album number: ");
                    int albumNum = s.nextInt();
                    s.nextLine();
                    Album album = albums.get(albumNum);
                    album.printSongs();
                    System.out.print("Specify song number: ");
                    int songNum = s.nextInt();
                    s.nextLine();
                    iter.add(album.getSong(songNum));
                    break;
                case 3:
                    // print playlist
                    ListIterator<Song> j = playlist.listIterator();
                    int num = 0;
                    System.out.println("Playlist");
                    while (j.hasNext()) {
                        System.out.println(num + " --> " + j.next().getTitle());
                        num++;
                    }
                    break;
                case 4:
                    // next song
                    if (iter.hasNext()) {
                        iter.next();
                    } else {
                        System.out.println("You are at the end of the list.");
                    }
                    break;
                case 5:
                    // previous song
                    if (iter.hasPrevious()) {
                        iter.previous();
                    } else {
                        System.out.println("You are at the beginning of the list");
                    }
                    break;
                case 7:
                    // current song
                    getCurrentSong(iter);

                    break;
                case 8:
                    getCurrentSong(iter);
                    System.out.println("Current playing song deleted.");
                    iter.remove();
                    getCurrentSong(iter);
                    break;
                case 9:
                    quit = true;
                    break;
            }
        }


    }

    public static void getCurrentSong(ListIterator<Song> iter) {
        if (iter.hasNext()) {
            Song song = iter.next();
            System.out.print("Currently playing: ");
            System.out.println(song.getTitle());
            iter.previous();
        } else {
            System.out.println("You are at the end of the list. No more songs to play.");
        }
    }


}
