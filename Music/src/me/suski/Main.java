package me.suski;

import me.suski.model.Artist;
import me.suski.model.DataSource;
import me.suski.model.SongArtist;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DataSource dataSource = new DataSource();
        if (!dataSource.open()) {
            System.out.println("Can't open data source");
            return;
        }

        List<Artist> artists = dataSource.queryArtists(DataSource.ORDER_BY_NONE);
        if (artists == null) {
            System.out.println("No artists");
        }

        for (Artist artist :
                artists) {
            System.out.printf("ID = %d, Name = %s%n",
                    artist.getId(), artist.getName());
        }

        List<String> albumsForArtist =
                dataSource.queryAlbumsForArtist(
                        "Pink Floyd",
                        DataSource.ORDER_BY_DESC);

        for (String album :
                albumsForArtist) {
            System.out.println(album);
        }

        List<SongArtist> songByArtist =
                dataSource.queryArtistForSong(
                        "Go Your Own Way",
                        DataSource.ORDER_BY_ASC);

        for (SongArtist songArtist :
                songByArtist) {
            System.out.println(songArtist);
        }

        dataSource.querySongsMetadata();

        System.out.println(dataSource.getCount(dataSource.TABLE_SONGS));

        dataSource.createViewForSongArtist();

        Scanner s = new Scanner(System.in);
        System.out.print("Enter song title: ");
        String title = s.nextLine();


        songByArtist =  dataSource.querySongInfoView(title);

        for (SongArtist songArtist :
                songByArtist) {
            System.out.println(songArtist);
        }

        System.out.println("---------------");

        dataSource.insertSong(
                "Bird Dog",
                "Everly Brothers",
                "All-Time Greatest Hits",
                7);

        dataSource.close();


    }
}
