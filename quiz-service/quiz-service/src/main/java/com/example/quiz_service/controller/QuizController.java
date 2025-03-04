package com.example.quiz_service.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.quiz_service.model.QuestionWrapper;
import com.example.quiz_service.model.QuizDto;
import com.example.quiz_service.model.Response;
import com.example.quiz_service.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService qs;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto) {
        return qs.createQuiz(quizDto.getCategoryName(), quizDto.getNumQ(), quizDto.getTitle());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {

        return qs.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> SubmitQuiz(@PathVariable Integer id, @RequestBody List<Response> resps) {
        return qs.calculateResult(id, resps);
    }
}
