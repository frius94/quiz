package com.ffhs.semesterarbeit.dto;

public class AnswerSubmission {

    private Long playerId;
    private Long questionId;
    private String answer;

    // Constructors
    public AnswerSubmission() {
        // Default constructor
    }

    public AnswerSubmission(Long playerId, Long questionId, String answer) {
        this.playerId = playerId;
        this.questionId = questionId;
        this.answer = answer;
    }

    // Getters and setters
    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
