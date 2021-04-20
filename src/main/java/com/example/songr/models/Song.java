package com.example.songr.models;

import javax.persistence.*;

@Entity
public class Song {
    private String title;
    private Double length;

    @ManyToOne
    private Album album;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Song(String title, Double length, int trackNumber,Album album) {
        this.album = album;
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
    }
    public Song() {
    }
    public int trackNumber;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }


    public Integer getId() {
        return id;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
