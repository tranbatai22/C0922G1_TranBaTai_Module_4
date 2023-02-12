package com.example.song_info.service;

import com.example.song_info.model.Song;
import com.example.song_info.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Optional<Song> findById(int id) {
        return songRepository.findById(id);
    }

    @Override
    public Page<Song> search(String name, Pageable pageable) {
        return songRepository.findByNameContaining(name, pageable);
    }
}
