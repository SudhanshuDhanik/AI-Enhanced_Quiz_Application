package com.project.quiz.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String question;

    @NotBlank
    private String subject;

    @NotBlank
    private String questionType;

@ElementCollection
@CollectionTable(
    name = "question_choices",
    joinColumns = @JoinColumn(name = "question_id")
)
@Column(name = "choice")
private List<String> choices;

@ElementCollection
@CollectionTable(
    name = "question_correct_answers",
    joinColumns = @JoinColumn(name = "question_id")
)
@Column(name = "correct_answer")
private List<String> correctAnswers;
    // ✅ Default constructor (required by JPA)
    public Question() { }

    public Question(long id, String javaBasics, int i) {
        this.id = id;
        this.question = javaBasics;
    }
}
