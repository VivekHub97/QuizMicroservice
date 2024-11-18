package com.vivekprojects.quiz_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vivekprojects.quiz_service.dao.QuizDao;
import com.vivekprojects.quiz_service.feign.QuizInterface;
import com.vivekprojects.quiz_service.model.QuestionWrapper;
import com.vivekprojects.quiz_service.model.Quiz;
import com.vivekprojects.quiz_service.model.Response;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuizInterface quizInterface;
	
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		// TODO Auto-generated method stub
		// quizService needs to interact with questionService
		
		List<Integer> questions = quizInterface.getQuestionForQuiz(category, numQ).getBody();
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionIds(questions);
		quizDao.save(quiz);	
		
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		// TODO Auto-generated method stub
		
		Quiz quiz = quizDao.findById(id).get();
		List<Integer> questionIds = quiz.getQuestionIds();

		ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionFromId(questionIds);
		
		return questions;
				
	}

	public ResponseEntity<Integer> getResult(Integer id, List<Response> responses) {
		// TODO Auto-generated method stub

		ResponseEntity<Integer> result = quizInterface.getScore(responses);
		
		return result;	
	}
	
}
