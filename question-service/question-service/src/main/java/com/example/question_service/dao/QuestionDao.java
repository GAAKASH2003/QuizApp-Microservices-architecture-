package com.example.question_service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import com.example.question_service.model.Question;
import com.example.question_service.model.QuestionWrapper;

@Repository

public interface QuestionDao extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT q.id FROM questions q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numq", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(@Param("category") String category, @Param("numq") int numq);

}
