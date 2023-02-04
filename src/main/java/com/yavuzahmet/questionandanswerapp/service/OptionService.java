package com.yavuzahmet.questionandanswerapp.service;

import com.yavuzahmet.questionandanswerapp.converter.OptionConverter;
import com.yavuzahmet.questionandanswerapp.dto.OptionDto;
import com.yavuzahmet.questionandanswerapp.exception.ErrorStatusCode;
import com.yavuzahmet.questionandanswerapp.exception.GeneralException;
import com.yavuzahmet.questionandanswerapp.model.Option;
import com.yavuzahmet.questionandanswerapp.repository.OptionRepository;
import com.yavuzahmet.questionandanswerapp.response.OptionResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OptionService {
    private final OptionRepository repository;
    private final OptionConverter converter;
    private final QuestionService questionService;

    public OptionService(OptionRepository repository, OptionConverter converter, QuestionService questionService) {
        this.repository = repository;
        this.converter = converter;
        this.questionService = questionService;
    }

    public OptionResponse getQuestionById(String id) {
        return converter.toResponse(repository.findById(Long.valueOf(id))
                .orElseThrow(() -> new GeneralException(ErrorStatusCode.INVALID_QUESTION_ID)));
    }

    public Option saveOption(OptionDto optionDto) {
        var getQuestionById = questionService.getQuestionById(optionDto.getQuestionId())
                .orElseThrow(() -> new GeneralException(ErrorStatusCode.INVALID_QUESTION_ID));
        return repository.save(converter.toEntity(optionDto.getHead(), getQuestionById));
    }

    public List<OptionResponse> getAllOptions() {
        return repository.findAll().stream().map(converter::toResponse).collect(Collectors.toList());
    }
}
