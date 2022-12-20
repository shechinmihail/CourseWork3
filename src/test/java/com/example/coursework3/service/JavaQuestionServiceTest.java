package com.example.coursework3.service;

import com.example.coursework3.model.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @InjectMocks
    private JavaQuestionService service;

    @Mock
    Question question;

    @BeforeEach
    void setUp(){

    }

    @Test
    void add() {
        Question expected = new Question("Вопрос 1", "Ответ 1");
        Question actual = service.add("Вопрос 1", "Ответ 1");
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testAdd() {
        Question expected = new Question("Вопрос 1", "Ответ 1");
        Question actual = service.add("Вопрос 1", "Ответ 1");
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void remove() {
        Question expected = new Question("Вопрос 1", "Ответ 1");
        //Question actual = service.remove(expected);
        //Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getAll() {
        assertTrue(service.getAll().isEmpty());
    }

    @Test
    void getRandomQestion() {
        Question expected = new Question("Вопрос 1", "Ответ 1");
        //assertEquals(QuestionService.getRandomQuestion(), expected);
    }
}