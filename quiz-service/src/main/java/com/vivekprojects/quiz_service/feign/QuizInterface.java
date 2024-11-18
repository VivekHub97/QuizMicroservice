package com.vivekprojects.quiz_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.vivekprojects.quiz_service.model.QuestionWrapper;
import com.vivekprojects.quiz_service.model.Response;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
	
	// generate
	@GetMapping("generate")
	public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String categoryName, @RequestParam Integer numQuestions);
	
	// getQuestions (questionid) for Quiz (only title and options)
	@PostMapping("getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> questionIds);
	
	// getScore
	@PostMapping("getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
