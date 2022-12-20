package com.example.coursework3.service;

import com.example.coursework3.model.Question;

import java.util.Collection;
import java.util.Random;

public class QuestionRandom {

    private Random random;

    public void setQuestionRandom(Random random) {
        this.random = random;
    }

    public int getRandomInt(int end) {
        return random.nextInt(end);
    }

    public Question getRandomQuestion(Collection<Question> questions){
        int questionNumber = getRandomInt(questions.size());
        int questionCurrent = 0;
        for (Question question : questions){
            if (questionCurrent == questionNumber){
                return question;
            }
            questionCurrent++;
        }
        return null;
    }
}
