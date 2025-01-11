package com.harinem.question_service.repository;


import com.harinem.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository  extends JpaRepository<Question,Integer> {

    List<Question> findByDifficultyLevel (String level);


    @Query(value = "SELECT id FROM question WHERE question.difficulty_level = :difficulty ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Integer> findRandomQuestionByDifficulty(String difficulty, int numQ);
}
