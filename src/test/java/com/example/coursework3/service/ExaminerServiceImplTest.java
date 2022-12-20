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

import java.util.Collection;
import java.util.Set;


@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @InjectMocks
    private ExaminerServiceImpl service;

    @Mock
    JavaQuestionService javaQuestionService;

    @BeforeEach
    void setUp(){
        service = new ExaminerServiceImpl(javaQuestionService);
    }

    @Test
    void getQuestions() {
        Question expected = new Question("Вопрос 1", "Ответ 1");
        Collection<Question> expectedList = Set.of(expected);
        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(expected);
        Mockito.when(javaQuestionService.getAll()).thenReturn(expectedList);
        Collection<Question> actualList = service.getQuestions(1);
        Assertions.assertThat(actualList).isEqualTo(expectedList);
    }
}