package com.example.coursework3.service;

import com.example.coursework3.exceptions.BadRequestException;
import com.example.coursework3.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

   private final JavaQuestionService javaQuestionServices;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionServices) {
        this.javaQuestionServices = javaQuestionServices;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> result = new HashSet<>();
        if (amount > javaQuestionServices.getAll().size() || amount <= 0) {
            throw new BadRequestException("Запрошено вопросов больше, чем есть в базе данных");
        }
        while (result.size() < amount) {
            result.add(javaQuestionServices.getRandomQuestion());
        }
        return result;
    }
}