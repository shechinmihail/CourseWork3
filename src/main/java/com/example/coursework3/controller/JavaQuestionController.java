package com.example.coursework3.controller;

import com.example.coursework3.model.Question;
import com.example.coursework3.service.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/add")
    public Question add(@PathVariable("question") String question,
                        @PathVariable("answer") String answer) {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(Question question) {
        return javaQuestionService.remove(question);
    }

    @GetMapping("/get")
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }

}
