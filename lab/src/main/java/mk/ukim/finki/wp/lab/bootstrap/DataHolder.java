package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataHolder implements CommandLineRunner {

    private final ArtistRepository artistRepository;
    private final SongRepository songRepository;

    public DataHolder(ArtistRepository artistRepository, SongRepository songRepository) {
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Artist artist1 = new Artist(1L, "Axl", "Rose", "Lead vocalist of Guns N' Roses");
        Artist artist2 = new Artist(2L, "Jon", "Bon Jovi", "Lead vocalist of Bon Jovi");
        Artist artist3 = new Artist(3L, "David", "Bowie", "Iconic British singer and songwriter");
        Artist artist4 = new Artist(4L, "Freddie", "Mercury", "Lead vocalist of Queen");
        Artist artist5 = new Artist(5L, "Elton", "John", "Legendary British musician and composer");

        artistRepository.saveAll(Arrays.asList(artist1, artist2, artist3, artist4, artist5));

        Song song1 = new Song("1", "Sweet Child O' Mine", "Rock", 1987, List.of(artist1));
        Song song2 = new Song("2", "Livin' on a Prayer", "Rock", 1986, List.of(artist2));
        Song song3 = new Song("3", "Heroes", "Rock", 1977, List.of(artist3));
        Song song4 = new Song("4", "Bohemian Rhapsody", "Rock", 1975, List.of(artist4));
        Song song5 = new Song("5", "Rocket Man", "Pop", 1972, List.of(artist5));

        songRepository.saveAll(Arrays.asList(song1, song2, song3, song4, song5));

        System.out.println("Sample data initialized.");
    }
}