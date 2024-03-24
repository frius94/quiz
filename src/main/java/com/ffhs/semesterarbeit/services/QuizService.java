package com.ffhs.semesterarbeit.services;

import com.ffhs.semesterarbeit.models.Question;
import com.ffhs.semesterarbeit.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class QuizService {

    private final QuestionRepository questionRepository;
    private final Map<Long, Integer> playerScores = new HashMap<>();

    @Autowired
    public QuizService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question getNextQuestion() {
        return questionRepository.findRandomQuestion();
    }

    public Question getRandomQuestion() {
        return questionRepository.findRandomQuestion();
    }

    public synchronized int getPlayerScore(Long playerId) {
        return playerScores.getOrDefault(playerId, 0);
    }

    public synchronized boolean submitAnswer(Long playerId, Long questionId, String answer) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
//        if (optionalQuestion.isPresent() && optionalQuestion.get().getCorrectAnswer().equals(answer)) {
//            playerScores.put(playerId, playerScores.getOrDefault(playerId, 0) + 1);
//            return true;
//        }
        return false;
    }
}
