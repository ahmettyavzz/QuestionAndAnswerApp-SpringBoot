package com.yavuzahmet.questionandanswerapp.controller;

import com.yavuzahmet.questionandanswerapp.dto.QuestionDto;
import com.yavuzahmet.questionandanswerapp.response.QuestionResponse;
import com.yavuzahmet.questionandanswerapp.model.Question;
import com.yavuzahmet.questionandanswerapp.service.QuestionService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/question")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable String id) {
        return questionService.getQuestionById(id);
    }

    @PostMapping
    public Question saveQuestion(@RequestBody @Valid QuestionDto questionDto) {
        return questionService.saveQuestion(questionDto);
    }

    @GetMapping
    public List<QuestionResponse> getAllQuestions(){
        return questionService.getAllQuestions();
    }
}
