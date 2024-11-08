package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepository {
    private final List<Artist> artists = new ArrayList<>();

    public ArtistRepository() {
        artists.add(new Artist(1L, "John", "Doe", "Bio 1"));
        artists.add(new Artist(2L, "Jane", "Smith", "Bio 2"));
        artists.add(new Artist(3L, "Alice", "Brown", "Bio 3"));
        artists.add(new Artist(4L, "Bob", "White", "Bio 4"));
        artists.add(new Artist(5L, "Charlie", "Green", "Bio 5"));
    }

    public List<Artist> findAll() {
        return artists;
    }

    public Optional<Artist> findById(Long id) {
        return artists.stream().filter(artist -> artist.getId().equals(id)).findFirst();
    }

    public void saveAll(List<Artist> list) {
        artists.addAll(list);
    }
}