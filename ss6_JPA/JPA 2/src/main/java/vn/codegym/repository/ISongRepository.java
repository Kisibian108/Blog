package vn.codegym.repository;

import vn.codegym.model.Song;

import java.util.List;

public interface ISongRepository {

    List<Song> findAll();

    void create(Song song);

    void update(int id, Song song);

    void delete(int id);

    void save(Song song);

    Song findById(int id);
}
