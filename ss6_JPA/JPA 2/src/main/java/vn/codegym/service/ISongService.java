package vn.codegym.service;

import vn.codegym.model.Song;

import java.util.List;

public interface ISongService {

    List<Song> findAll();

    void create(Song song);

    void update(int id, Song song);

    void delete(int id);

    void save(Song song);

    Song findById(int id);
}
