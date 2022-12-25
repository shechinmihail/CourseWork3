package com.example.coursework3.controller;

import com.example.coursework3.model.Question;
import com.example.coursework3.service.JavaQuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam("question") String question,
                        @RequestParam("answer") String answer) {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping( "/remove")
    public Question remove(@RequestParam("question") String question,
                           @RequestParam("answer") String answer) {
        Question questions= new Question(question, answer);
        return javaQuestionService.remove(questions);
    }

    @GetMapping("/get")
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }

}
