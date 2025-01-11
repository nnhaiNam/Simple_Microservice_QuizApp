package com.harinem.quiz_service.service;

import com.harinem.quiz_service.feign.QuizInterface;
import com.harinem.quiz_service.model.QuestionWrapper;
import com.harinem.quiz_service.model.Quiz;
import com.harinem.quiz_service.model.UserResponse;

import com.harinem.quiz_service.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String difficulty, int numQ,String title) {

//        List<Question> questions=questionRepository.findRandomQuestionByDifficulty(difficulty,numQ);
//
//        Quiz quiz=new Quiz();
//        quiz.setTitle(title);
//        quiz.setQuestions(questions);
//        quizRepository.save(quiz);

        List<Integer> questions=quizInterface.getQuestionsForQuiz(difficulty,numQ,title).getBody();
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsIds(questions);
        quizRepository.save(quiz);


        return new ResponseEntity<>("Success", HttpStatus.CREATED);


    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {

//        Optional<Quiz> quiz=quizRepository.findById(id);
//        List<Question> questionsFromDB=quiz.get().getQuestions();

//
//        for(Question q:questionsFromDB){
//            QuestionWrapper questionWrapper=new QuestionWrapper(q.getId(),q.getQuestion_title(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
//            questionForUser.add(questionWrapper);
//        }
        Quiz quiz=quizRepository.findById(id).get();
        List<Integer> questionIds=quiz.getQuestionsIds();
        ResponseEntity<List<QuestionWrapper>> questions= quizInterface.getQuestionsFromID(questionIds);


        //List<QuestionWrapper> questionForUser=new ArrayList<>();


        return new ResponseEntity<>(questions.getBody(),HttpStatus.OK);


    }


    public ResponseEntity<Integer> submitQuiz(Integer id, List<UserResponse> userResponse) {
//        Optional<Quiz> quiz=quizRepository.findById(id);
//        List<Question> questions=quiz.get().getQuestions();
          int rightTotal=0;
//        for(int i=0;i<questions.size();i++){
//            if(questions.get(i).getRight_answer().equals(userResponse.get(i).getAnswer())){
//                rightTotal++;
//            }
//        }
        rightTotal=quizInterface.getScore(userResponse).getBody();

        return new ResponseEntity<>(rightTotal,HttpStatus.OK);
    }
}
