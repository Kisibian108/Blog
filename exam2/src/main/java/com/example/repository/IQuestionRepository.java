package com.example.repository;

import com.example.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IQuestionRepository extends JpaRepository<Question,Integer> {

    @Query(value = " select * from question join question_type on question.question_type_id = question_type.id where title like :keyword or name like :keyword ", nativeQuery = true,
            countQuery = " select count(*) from (select * from question join question_type on question.question_type_id = question_type.id where title like :keyword or name like :keyword where title like :keyword or questionType like :keyword ) temp_table ")
    Page<Question> findAllQuestion(@Param("keyword") String keyword , Pageable pageable);

    List<Question> findByTitle(String keyword);

    List<Question> findQuestionByTitle(String keyword);

    @Modifying
    @Query(value = " insert into question(title, question, question_type ) values (:title, :question, :question_type ", nativeQuery = true )
    void insert(@Param("title") String title, @Param("question") String question, @Param("questionType") String questionType );
}

