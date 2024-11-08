package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SongRepository {
    private final List<Song> songs = new ArrayList<>();

    public SongRepository() {
        songs.add(new Song("1", "Song A", "Rock", 2020, new ArrayList<>()));
        songs.add(new Song("2", "Song B", "Pop", 2019, new ArrayList<>()));
        songs.add(new Song("3", "Song C", "Jazz", 2021, new ArrayList<>()));
        songs.add(new Song("4", "Song D", "Classical", 2022, new ArrayList<>()));
        songs.add(new Song("5", "Song E", "Hip-Hop", 2023, new ArrayList<>()));
    }

    public List<Song> findAll() {
        return songs;
    }

    public Optional<Song> findByTrackId(String trackId) {
        return songs.stream().filter(song -> song.getTrackId().equals(trackId)).findFirst();
    }

    public Artist addArtistToSong(Artist artist, Song song) {
        song.getPerformers().add(artist);
        return artist;
    }

    public void saveAll(List<Song> list) {
        songs.addAll(list);
    }
}