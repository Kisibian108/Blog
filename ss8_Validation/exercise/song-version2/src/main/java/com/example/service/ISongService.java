package com.example.service;

import com.example.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {

    List<Song> findAll();

    void delete(int id);

    void save(Song song);

    Optional<Song> findById(int id);
}
