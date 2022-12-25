package com.example.coursework3.service;

import com.example.coursework3.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class JavaQuestionServiceTest {

    private Set<Question> expected = new HashSet<>();

    private Set<Question> actual = new HashSet<>();

    @BeforeEach
    void setUp(){
    expected.add(new Question("Вопрос 1","Ответ 1"));
    expected.add(new Question("Вопрос 2","Ответ 2"));
    expected.add(new Question("Вопрос 3","Ответ 3"));
    expected.add(new Question("Вопрос 4","Ответ 4"));

    actual.add(new Question("Вопрос 1","Ответ 1"));
    actual.add(new Question("Вопрос 2","Ответ 2"));
    actual.add(new Question("Вопрос 3","Ответ 3"));
    actual.add(new Question("Вопрос 4","Ответ 4"));

    }

    @Test
    void add() {
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testAdd() {
        expected.add(new Question("Вопрос 777", "Ответ 777"));
        actual.add(new Question("Вопрос 777", "Ответ 777"));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void remove() {
        expected.remove("test2");
        actual.remove("test2");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAll() {
        expected.size();
        actual.size();
        Assertions.assertEquals(expected, actual);
    }

}