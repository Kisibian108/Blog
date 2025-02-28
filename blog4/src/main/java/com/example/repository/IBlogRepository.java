package com.example.repository;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    List<Blog> findByName(String name);
    List<Blog> findByNameContaining(String name);

    /*tìm theo tên tương đối và id lớn hơn 2*/
    List<Blog> findByNameContainingAndIdGreaterThan(String name, int id);

    @Query(value = "select * from blog where name = :keyword", nativeQuery = true)
    List<Blog> searchByName(@Param("keyword") String name);

    @Query(value = " select * from blog where name like :keyword ", nativeQuery = true,
            countQuery = " select count(*) from (select * from blog where name like :keyword ) temp_table ")
    Page<Blog> getAllBlog(@Param("keyword") String keyword , Pageable pageable);

//    Page<Blog> findAll(Pageable pageable);

    @Query(value = " select * " +
            " from blog b where b.id = :id", nativeQuery = true)
    Blog getBlog(@Param("id") int id);

    List<Blog> findBlogsByNameContains(String keyword);

    List<Blog> findBlogsByAuthorContains(String name);


}
