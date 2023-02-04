package com.yavuzahmet.questionandanswerapp.service;

import com.yavuzahmet.questionandanswerapp.converter.QuestionConverter;
import com.yavuzahmet.questionandanswerapp.dto.QuestionDto;
import com.yavuzahmet.questionandanswerapp.response.QuestionResponse;
import com.yavuzahmet.questionandanswerapp.model.Question;
import com.yavuzahmet.questionandanswerapp.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionConverter converter;

    public QuestionService(QuestionRepository questionRepository, QuestionConverter converter) {
        this.questionRepository = questionRepository;
        this.converter = converter;
    }

    public Optional<Question> getQuestionById(String id) {
        return questionRepository.findById(Long.valueOf(id));
    }

    public Question saveQuestion(QuestionDto questionDto) {
        var kay= converter.toEntity(questionDto);


        return questionRepository.save(kay);
    }

    public List<QuestionResponse> getAllQuestions() {
        return questionRepository.findAll().stream().map(converter::toResource).collect(Collectors.toList());
    }
}
