package com.ffhs.semesterarbeit.models;

import jakarta.persistence.*;


@Entity
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;
    private String text;
    private Boolean isCorrect;
}
