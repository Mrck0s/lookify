package com.marcos.lookify.repositories;

import com.marcos.lookify.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    Optional<Song> findByTitle(String title);

    void deleteById(Long id);
    Iterable<Song> findByArtistContainingIgnoreCase(String artist);

    List<Song> findTop10ByOrderByRatingDesc();

}
