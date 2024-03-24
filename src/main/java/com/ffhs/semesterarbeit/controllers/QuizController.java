package com.ffhs.semesterarbeit.controllers;

import com.ffhs.semesterarbeit.dto.AnswerSubmission;
import com.ffhs.semesterarbeit.models.Player;
import com.ffhs.semesterarbeit.models.Question;
import com.ffhs.semesterarbeit.models.Quiz;
import com.ffhs.semesterarbeit.repositories.QuizRepository;
import com.ffhs.semesterarbeit.services.QuizService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/createQuiz")
    public String createQuiz(String username) {
        Quiz quiz = new Quiz();
        quiz.setHash(RandomStringUtils.randomAlphanumeric(10));
        List<Player> players = quiz.getPlayers();
        players.add(new Player(username));
        quiz.setPlayers(players);
        quizRepository.saveAndFlush(quiz);
        return quiz.getHash();
    }

    @PostMapping("/joinQuiz")
    public Boolean joinQuiz(Player player, String hash) {
        List<Quiz> quizList = quizRepository.findByHash(hash);
        if (quizList.isEmpty() || quizList.size() > 1) {
            return false;
        }
        Quiz quiz = quizList.get(0);
        List<Player> players = quiz.getPlayers();
        players.add(player);
        quizList.get(0).setPlayers(players);
        return true;
    }

    // Endpoint to get a random question
    @GetMapping("/question")
    public ResponseEntity<Question> getRandomQuestion() {
        Question question = quizService.getRandomQuestion();
        return ResponseEntity.ok(question);
    }

    // Endpoint for a player to submit an answer
    @PostMapping("/submitAnswer")
    public ResponseEntity<?> submitAnswer(@RequestBody AnswerSubmission submission) {
        boolean isCorrect = quizService.submitAnswer(submission.getPlayerId(), submission.getQuestionId(), submission.getAnswer());
        if (isCorrect) {
            return ResponseEntity.ok().body("Correct Answer");
        } else {
            return ResponseEntity.ok().body("Incorrect Answer");
        }
    }

    // Endpoint to get the current score of a player
    @GetMapping("/score")
    public ResponseEntity<Integer> getPlayerScore(@RequestParam Long playerId) {
        int score = quizService.getPlayerScore(playerId);
        return ResponseEntity.ok(score);
    }
}
