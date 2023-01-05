package com.example.coursework3.service;

import com.example.coursework3.exceptions.BadRequestException;
import com.example.coursework3.exceptions.QuestionNotFoundException;
import com.example.coursework3.model.Question;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService;

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
        javaQuestionService.add("Вопрос 1", "Ответ 1");
        javaQuestionService.add("Вопрос 2", "Ответ 2");
        javaQuestionService.add("Вопрос 3", "Ответ 3");
        javaQuestionService.add("Вопрос 4", "Ответ 4");
        javaQuestionService.add("Вопрос 5", "Ответ 5");
    }

    @Test
        // add(String question, String answer)
    void questionAlreadyExists() throws BadRequestException {
        Assertions.assertThatExceptionOfType(BadRequestException.class).isThrownBy(() -> {
            javaQuestionService.add(null, "Ответ 1");
        });
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            throw new BadRequestException("Введите вопрос");
        });
        assertEquals("Введите вопрос", exception.getMessage());
        assertThat(exception.getMessage()).isNotBlank();
    }

    @Test
        // add(String question, String answer)
    void addQuestion() {
        Question expected = new Question("Вопрос 1", "Ответ 1");
        assertEquals(expected, javaQuestionService.add(expected));
        assertFalse(javaQuestionService.getAll().isEmpty());
        assertThat(javaQuestionService.getAll()).contains(expected);
    }

    @Test
        // add(Question question)
    void testAdd() {
        Question expected = new Question("Вопрос 1", "Ответ 1");
        assertEquals(expected, javaQuestionService.add(expected));
        assertFalse(javaQuestionService.getAll().isEmpty());
        assertThat(javaQuestionService.getAll()).contains(expected);
    }

    @Test
        // remove
    void shouldRemoveQuestion() {
        Question expected = new Question("Вопрос 1", "Ответ 1");
        javaQuestionService.add(expected);
        Question actual = javaQuestionService.remove(expected);
        assertEquals(expected, actual);
        assertTrue(javaQuestionService.getAll().isEmpty());
        assertThat(javaQuestionService.getAll());
    }

    @Test
        // remove
    void ifThereIsAQuestionRemove() {
        Assertions.assertThatExceptionOfType(QuestionNotFoundException.class).isThrownBy(() -> {
            javaQuestionService.remove(null);
        });
        QuestionNotFoundException exception = assertThrows(QuestionNotFoundException.class, () -> {
            throw new QuestionNotFoundException("Вопрос не найден в списке");
        });
        assertEquals("Вопрос не найден в списке", exception.getMessage());
        assertThat(exception.getMessage()).isNotBlank();
    }

    @Test
        // getAll
    void showCollectionOfExistingQuestions() {
        Collection<Question> expected = new HashSet<>();
        Collection<Question> actual = javaQuestionService.getAll();
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
        // getRandomQuestion
    void showRandomQuestion() {
        Question expected = new Question("Вопрос 1", "Ответ 1");
        Collection<Question> questionCollection = List.of(expected);
        javaQuestionService.add((Question) questionCollection);
        Question actual = javaQuestionService.getRandomQuestion();
        assertThat(actual).isEqualTo(expected);
    }


}