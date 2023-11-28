package com.marcos.lookify.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="songs")
public class Song {
        // Attributes
        @Id
        @GeneratedValue(strategy= IDENTITY)
        private Long id;

        @Column(nullable=false, length=80)
        private String title;
        @Column(nullable=false, length=80)
        private String artist;
        @Column(nullable=false)
        @Min(1)
        @Max(10)
        private Double rating;

        public Song() {

        }

        public Song(String title, String artist, Double rating) {
            this.title = title;
            this.artist = artist;
            this.rating = rating;
        }

        // Getters
        public String getTitle() {
            return title;
        }

        public String getArtist() {
            return artist;
        }

        public Double getRating() {
            return rating;
        }

        // Setters
        public void setTitle(String title) {
            this.title = title;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }

        public void setRating(Double rating) {
            this.rating = rating;
        }
}
