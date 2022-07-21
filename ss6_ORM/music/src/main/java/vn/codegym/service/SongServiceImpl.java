package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Song;
import vn.codegym.repository.ISongRepository;
import vn.codegym.repository.SongRepositoryImpl;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService {

    ISongRepository songRepository = new SongRepositoryImpl();

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void create(Song song) {
        songRepository.create(song);
    }

    @Override
    public void update(int id, Song song) {
        songRepository.update(id, song);
    }

    @Override
    public void delete(int id) {
        songRepository.delete(id);
    }
}
