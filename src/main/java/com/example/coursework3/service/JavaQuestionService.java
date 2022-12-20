package com.example.coursework3.service;

import com.example.coursework3.model.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Service
public class JavaQuestionService implements QuestionService{
    private final Set<Question> questions = new HashSet<>();
    private QuestionRandom randomQuestion;

    @PostConstruct
    private void listQuestions(){
        questions.add(new Question("Вопрос 1","Ответ 1"));
        questions.add(new Question("Вопрос 2","Ответ 2"));
        questions.add(new Question("Вопрос 3","Ответ 3"));
        questions.add(new Question("Вопрос 4","Ответ 4"));
        questions.add(new Question("Вопрос 5","Ответ 5"));
        questions.add(new Question("Вопрос 6","Ответ 6"));
    }

    @Override
    public Question add(String question, String answer) {
        if (question == null || question.isBlank()){
            throw new RuntimeException("Введите вопрос");
        }
        if (answer == null || answer.isBlank()){
            throw new RuntimeException("");
        }
        return new Question(question, answer);
    }

    @Override
    public Question add(Question question) {
        if (question == null){
            throw new RuntimeException("Введите вопрос");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)){
            throw new RuntimeException("Вопрос не найден в списке");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        return randomQuestion.getRandomQuestion(getAll());
    }
}
