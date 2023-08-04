package com.marcos.lookify.controllers;

import com.marcos.lookify.models.Song;
import com.marcos.lookify.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
public class SongController {

    private final SongRepository songRepository;

    @Autowired
    public SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @GetMapping("/api/songs/{id}")
    public Song mostrarDetallesCancion(@PathVariable Long id) {
        return songRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de canción inválido: " + id));
    }

    @PostMapping("/api/songs")
    public Song guardarCancion(@Valid @RequestBody Song song) {
        return songRepository.save(song);
    }

    @DeleteMapping("/api/songs/{id}")
    public void eliminarCancion(@PathVariable Long id) {
        songRepository.deleteById(id);
    }
}
