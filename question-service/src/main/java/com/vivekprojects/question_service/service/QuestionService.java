package com.vivekprojects.question_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vivekprojects.question_service.dao.QuestionDao;
import com.vivekprojects.question_service.model.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;

//	public List<Question> getAllQuestions() {
//		// TODO Auto-generated method stub
//		return questionDao.findAll();
//	}

	public ResponseEntity<List<Question>> getAllQuestions() {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) {
		// TODO Auto-generated method stub
		questionDao.save(question);
		return new ResponseEntity<>("Question Added", HttpStatus.CREATED);
	}

}
