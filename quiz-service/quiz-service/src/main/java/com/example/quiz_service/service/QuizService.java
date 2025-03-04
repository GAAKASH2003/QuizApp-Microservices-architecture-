package com.example.quiz_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

// import com.example.quiz_service.dao.QuestionDao;
import com.example.quiz_service.dao.QuizDao;
import com.example.quiz_service.feign.QuizInterface;
import com.example.quiz_service.model.Question;
import com.example.quiz_service.model.QuestionWrapper;
import com.example.quiz_service.model.Quiz;
import com.example.quiz_service.model.Response;

@Service
public class QuizService {
    @Autowired
    QuizDao qd;

    @Autowired
    QuizInterface quizInterface;
    // @Autowired
    // QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numq, String title) {
        List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numq).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        qd.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        System.out.println(id);
        Quiz quiz = qd.findById(id).get();
        System.out.println(quiz);
        List<Integer> questionIds = quiz.getQuestions();
        ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);
        return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        ResponseEntity<Integer> score = quizInterface.getScore(responses);
        return score;
    }
}
