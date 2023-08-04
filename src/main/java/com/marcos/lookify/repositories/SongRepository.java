package com.marcos.lookify.repositories;

import com.marcos.lookify.models.Song;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SongRepository extends CrudRepository<Song, Long> {
    Iterable<Song> findByArtistaContainingIgnoreCase(String artista);

    List<Song> findTop10ByOrderByClasificacionDesc();
}
