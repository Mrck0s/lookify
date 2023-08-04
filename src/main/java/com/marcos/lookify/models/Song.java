package com.marcos.lookify.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El título es requerido")
    @Size(min = 5, message = "El título debe tener al menos 5 caracteres")
    private String titulo;

    @NotEmpty(message = "El artista es requerido")
    @Size(min = 5, message = "El artista debe tener al menos 5 caracteres")
    private String artista;

    @Min(value = 1, message = "La clasificación debe ser al menos 1")
    @Max(value = 10, message = "La clasificación debe ser como máximo 10")
    private int clasificacion;

    public Song() {
    }

    public Song(String titulo, String artista, int clasificacion) {
        this.titulo = titulo;
        this.artista = artista;
        this.clasificacion = clasificacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }
}
