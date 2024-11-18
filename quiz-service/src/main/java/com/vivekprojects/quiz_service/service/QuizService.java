package com.vivekprojects.quiz_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vivekprojects.quiz_service.dao.QuizDao;
import com.vivekprojects.quiz_service.model.QuestionWrapper;
import com.vivekprojects.quiz_service.model.Quiz;
import com.vivekprojects.quiz_service.model.Response;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	
//	@Autowired
//	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		// TODO Auto-generated method stub
		// quizService needs to interact with questionService
		
//		List<Integer> questions = //
//		
//		Quiz quiz = new Quiz();
//		quiz.setTitle(title);
//		quiz.setQuestions(questions);
//		quizDao.save(quiz);
		
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		// TODO Auto-generated method stub
//		Optional<Quiz> quiz = quizDao.findById(id);
//		List<Question> questionsFromDB = quiz.get().getQuestions();
		List<QuestionWrapper> questionsForUser = new ArrayList<QuestionWrapper>();
//		
//		for(Question q : questionsFromDB) {
//			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
//			questionsForUser.add(qw);
//		}
		
		return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
				
	}

	public ResponseEntity<Integer> getResult(Integer id, List<Response> responses) {
		// TODO Auto-generated method stub
//		Quiz quiz = quizDao.findById(id).get();
//		List<Question> questions = quiz.getQuestions();
//		
//		int i = 0;
		int right = 0;
//		for(Response response : responses){
//			if(response.getResponse().equals(questions.get(i).getRightAnswer())) {
//				right++;
//			}			
//			i++;
//		}
		return new ResponseEntity<>(right, HttpStatus.OK);		
	}
	
}
