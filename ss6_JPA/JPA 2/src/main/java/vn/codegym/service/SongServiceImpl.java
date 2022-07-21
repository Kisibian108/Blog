package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Song;
import vn.codegym.repository.ISongRepository;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    private ISongRepository repository;

    @Override
    public List<Song> findAll() {
        return repository.findAll();
    }

    @Override
    public void create(Song song) {
        repository.create(song);
    }

    @Override
    public void update(int id, Song song) {
        repository.update(id, song);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public void save(Song song) {
        repository.save(song);
    }

    @Override
    public Song findById(int id) {
        return repository.findById(id);
    }
}
