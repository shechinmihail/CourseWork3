package com.example.coursework3.service;

import com.example.coursework3.model.Question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;


class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService;

    @BeforeEach
    void setUp(){
        javaQuestionService = new JavaQuestionService();
        javaQuestionService.add("Вопрос 1","Ответ 1");
        javaQuestionService.add("Вопрос 2","Ответ 2");
        javaQuestionService.add("Вопрос 3","Ответ 3");
        javaQuestionService.add("Вопрос 4","Ответ 4");
        javaQuestionService.add("Вопрос 5","Ответ 5");
    }

    @Test // add(String question, String answer)
    void questionAlreadyExists() {
        javaQuestionService.add("Вопрос 1","Ответ1 ");
        Throwable thrown = catchThrowable(() -> javaQuestionService.add("Вопрос 1","Ответ 1"));
       assertThat(thrown.getMessage()).isNotBlank();
    }

    @Test // add(String question, String answer)
    void addQuestion() {
        Question expected = new Question("Вопрос 1","Ответ 1");
        assertEquals(expected, javaQuestionService.add(expected));
        assertFalse(javaQuestionService.getAll().isEmpty());
    }

    @Test // add(Question question)
    void testAdd() {
        Question expected = new Question("Вопрос 1");
        assertEquals(expected, javaQuestionService.add(expected));
        assertFalse(javaQuestionService.getAll().isEmpty());
    }

    @Test // remove
    void shouldRemoveQuestion() {
        Question expected = new Question("Вопрос 1","Ответ 1");
        javaQuestionService.add(expected);
        Question actual = javaQuestionService.remove(expected);
        assertEquals(expected, actual);
        assertTrue(javaQuestionService.getAll().isEmpty());
    }

    @Test // remove
    void ifThereIsAQuestionRemove() {
        Question expected = new Question("Вопрос 1","Ответ 1");
        Throwable thrown = catchThrowable(() -> javaQuestionService.remove(expected));
        assertThat(thrown.getMessage()).isNotBlank();
    }

    @Test // getAll
    void showCollectionOfExistingQuestions() {
        Question expected = javaQuestionService.add("Вопрос 1","Ответ 1");
        assertTrue(javaQuestionService.getAll().contains(expected));
    }

    @Test // getAll
    void returnEmptyCollection() {
        assertTrue(javaQuestionService.getAll().isEmpty());
    }

    @Test // getRandomQuestion
    void showRandomQuestion() {
        Question expected = javaQuestionService.add("Вопрос 1","Ответ 1");
        assertEquals(javaQuestionService.getRandomQuestion(), expected);
    }


}