package vn.codegym.repository;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Song;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class SongRepositoryImpl implements ISongRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Song> findAll() {
        TypedQuery<Song> query = entityManager
                .createQuery("SELECT s FROM Song as s", Song.class);
        return query.getResultList();
    }

    @Override
    public void create(Song song) {
        entityManager.persist(song);
    }

    @Override
    public void update(int id, Song song) {
        entityManager.merge(song);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Song.class, id));
    }

    @Override
    public void save(Song song) {
        entityManager.persist(song);
//        entityManager.remove(entityManager.merge(student));
//        entityManager.find(Student.class, 5); // tìm kiếm
    }

    @Override
    public Song findById(int id) {
        return entityManager.find(Song.class, id);
    }
}
