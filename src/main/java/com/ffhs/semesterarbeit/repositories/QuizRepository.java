package com.ffhs.semesterarbeit.repositories;

import com.ffhs.semesterarbeit.models.Question;
import com.ffhs.semesterarbeit.models.Quiz;
import jakarta.annotation.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    @Nullable
    List<Quiz> findByHash(String hash);
}
