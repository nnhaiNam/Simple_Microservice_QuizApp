package com.harinem.question_service.controller;


import com.harinem.question_service.model.Question;
import com.harinem.question_service.model.QuestionWrapper;
import com.harinem.question_service.model.UserResponse;
import com.harinem.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();

    }

    @GetMapping("difficulty/{level}")
    public ResponseEntity<List<Question>> getQuestionByDifficultyLevel(@PathVariable String level){
        return questionService.getQuestionByDifficultyLevel(level);
    }



    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String difficulty,@RequestParam int numQ,@RequestParam String title){
        return questionService.getQuestionsForQuiz(difficulty,numQ,title);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromID(@RequestBody List<Integer> questionsId){
        return questionService.getQuestionsFromId(questionsId);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<UserResponse> responses){
        return questionService.getScore(responses);

    }
    //generate quiz

    //getQuestion

    //getScore


}
