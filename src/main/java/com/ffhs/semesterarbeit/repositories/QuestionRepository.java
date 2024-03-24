package com.ffhs.semesterarbeit.repositories;

import com.ffhs.semesterarbeit.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    // Example custom query if needed
    Optional<Question> findFirstByOrderByIdAsc();

    // Example: Find a random question
    // Note: The implementation of this query might depend on your database type and version.
    @Query(value = "SELECT * FROM question ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Question findRandomQuestion();

    // Example: Find questions by a certain criteria (e.g., difficulty level)
    // List<Question> findByDifficulty(String difficulty);

    // You can add more custom query methods here
}
