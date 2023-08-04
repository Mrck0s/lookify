package com.marcos.lookify.controllers;

import com.marcos.lookify.models.Song;
import com.marcos.lookify.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@Controller
public class LookifyController {

    private final SongRepository songRepository;

    @Autowired
    public LookifyController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }
    @GetMapping("/songs/all")
    public String mostrarListaCanciones(Model model) {
        List<Song> listaCanciones = (List<Song>) songRepository.findAll();
        model.addAttribute("listaCanciones", listaCanciones);
        return "lista_canciones";
    }

    @GetMapping("/songs/{id}")
    public String mostrarDetallesCancion(@PathVariable Long id, Model model) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de canción inválido: " + id));
        model.addAttribute("song", song);
        return "detalles_cancion";
    }

    @GetMapping("/songs/new")
    public String mostrarFormularioNuevaCancion(Model model) {
        model.addAttribute("song", new Song());
        return "agregar_cancion";
    }

    @PostMapping("/songs/new")
    public String guardarCancion(@Valid @ModelAttribute Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "agregar_cancion";
        }

        songRepository.save(song);
        return "redirect:/songs/all";
    }

    @GetMapping("/search")
    public String buscarPorArtista(@RequestParam("artist") String artist, Model model) {
        Iterable<Song> listaCanciones = songRepository.findByArtistaContainingIgnoreCase(artist);
        model.addAttribute("listaCanciones", listaCanciones);
        model.addAttribute("artist", artist);
        return "busqueda_artista";
    }

    @GetMapping("/search/topTen")
    public String mostrarTopTen(Model model) {
        List<Song> topTen = songRepository.findTop10ByOrderByClasificacionDesc();
        model.addAttribute("topTen", topTen);
        return "top_ten";
    }

    @PostMapping("/songs/{id}/delete")
    public String eliminarCancion(@PathVariable Long id) {
        songRepository.deleteById(id);
        return "redirect:/songs/all";
    }
}
