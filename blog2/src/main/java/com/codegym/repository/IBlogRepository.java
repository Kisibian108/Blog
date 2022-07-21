package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findByName(String name);
    List<Blog> findByNameContaining(String name);

    /*tìm theo tên tương đối và id lớn hơn 2*/
    List<Blog> findByNameContainingAndIdGreaterThan(String name, int id);

    @Query(value = "select * from Blog where name = :keyword", nativeQuery = true)
    List<Blog> searchByName(@Param("keyword") String name);

    @Modifying
    @Transactional
    @Query(value = " delete from Blog b " +
            " where b.id = :id ", nativeQuery = true)
    void deleteBlog(@Param("id") int id);

    @Query(value = " select * " +
            " from Blog b where b.id = :id", nativeQuery = true)
    Blog getBlog(@Param("id") int id);

}
