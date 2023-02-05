package com.yavuzahmet.questionandanswerapp.controller;

import com.yavuzahmet.questionandanswerapp.dto.QuestionDto;
import com.yavuzahmet.questionandanswerapp.response.QuestionResponse;
import com.yavuzahmet.questionandanswerapp.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/question")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponse> getQuestionById(@PathVariable String id) {
        return ResponseEntity.ok(questionService.getQuestionById(id));
    }

    @GetMapping("/answer/{id}")
    public ResponseEntity<String> answer(@PathVariable Long id,
                                         @RequestParam Long no) {
        return ResponseEntity.ok(questionService.answer(id, no));
    }

    @PostMapping
    public ResponseEntity<QuestionResponse> saveQuestion(@RequestBody QuestionDto dto) {
        return ResponseEntity.ok(questionService.saveQuestion(dto));
    }
}
