package com.example.song_info.service;

import com.example.song_info.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    Optional<Song> findById(int id);
}
