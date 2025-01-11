package com.harinem.question_service.service;


import com.harinem.question_service.model.Question;
import com.harinem.question_service.model.QuestionWrapper;
import com.harinem.question_service.model.UserResponse;
import com.harinem.question_service.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {


    @Autowired
    QuestionRepository questionRepository;
    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }


    }

    public ResponseEntity<List<Question>> getQuestionByDifficultyLevel(String level){
        try{
            return new ResponseEntity<>(questionRepository.findByDifficultyLevel(level), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }


    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionRepository.save(question);
        return new ResponseEntity<>("Sucsess",HttpStatus.CREATED);
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String difficulty, int numQ, String title) {
        List<Integer> questions=questionRepository.findRandomQuestionByDifficulty(difficulty,numQ);
        return new ResponseEntity<>(questions,HttpStatus.OK);


    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionsId) {
        List<QuestionWrapper> wrappers=new ArrayList<>();
        List<Question> questions=new ArrayList<>();
        for(Integer id:questionsId){
            questions.add(questionRepository.findById(id).get());
        }
        for(Question q:questions){
            QuestionWrapper questionWrapper=new QuestionWrapper(q.getId(),q.getQuestion_title(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            wrappers.add(questionWrapper);

        }

        return new ResponseEntity<>(wrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<UserResponse> responses) {
        int rightTotal=0;
        for(UserResponse userResponse:responses){
            Optional<Question> question=questionRepository.findById(userResponse.getId());
            if(userResponse.getAnswer().equals(question.get().getRight_answer())){
                rightTotal++;
            }

        }

        return new ResponseEntity<>(rightTotal,HttpStatus.OK);
    }
}
