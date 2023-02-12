package com.example.song_info.repository;

import com.example.song_info.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Integer> {
    Page<Song> findByNameContaining(String name, Pageable pageable);
}
