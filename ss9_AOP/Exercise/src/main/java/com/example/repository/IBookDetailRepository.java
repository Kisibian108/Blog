package com.example.repository;

import com.example.model.DetailBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IBookDetailRepository extends JpaRepository<DetailBook,Integer> {
    @Modifying
    @Transactional
    @Query(value = " UPDATE detail_book SET status = 1 WHERE (id = :detailID); " ,nativeQuery = true)
    void setStatus(@Param("detailID") int detailID);

    @Query(value = " SELECT * FROM detail_book where (book_code = :bookCode); " ,nativeQuery = true)
    DetailBook getByBookCode(@Param("bookCode") Integer bookCode);

    @Modifying
    @Transactional
    @Query(value = " UPDATE detail_book SET status = 0 WHERE (id = :id); " ,nativeQuery = true)
    void updateStatus(@Param("id") Integer id);
}
