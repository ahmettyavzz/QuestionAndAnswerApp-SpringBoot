package com.yavuzahmet.questionandanswerapp.service;

import com.yavuzahmet.questionandanswerapp.converter.QuestionConverter;
import com.yavuzahmet.questionandanswerapp.dto.QuestionDto;
import com.yavuzahmet.questionandanswerapp.exception.ErrorStatusCode;
import com.yavuzahmet.questionandanswerapp.exception.GeneralException;
import com.yavuzahmet.questionandanswerapp.model.Option;
import com.yavuzahmet.questionandanswerapp.model.Question;
import com.yavuzahmet.questionandanswerapp.repository.QuestionRepository;
import com.yavuzahmet.questionandanswerapp.response.QuestionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionConverter converter;
    private final OptionService optionService;

    public QuestionService(QuestionRepository questionRepository, QuestionConverter converter, OptionService optionService) {
        this.questionRepository = questionRepository;
        this.converter = converter;
        this.optionService = optionService;
    }

    public QuestionResponse getQuestionById(String id) {
        if (questionRepository.findById(Long.valueOf(id)).isEmpty()) {
            throw new GeneralException(ErrorStatusCode.INVALID_QUESTION_ID);
        }
        var optionList = optionService.getOptionsByQuestionId(Long.valueOf(id));
        var data = questionRepository.findById(Long.valueOf(id)).get();
        data.setOptions(optionList);
        return converter.toResponse(data);
    }

    public QuestionResponse saveQuestion(QuestionDto dto) {

        Question forSaveQuestion = new Question();
        forSaveQuestion.setHead(dto.getHead());
        forSaveQuestion.setAnswerNo(dto.getAnswerNo());

        List<Option> options = dto.getOptions();
        for (Option option : options) {
            option.setQuestion(forSaveQuestion);
        }
        forSaveQuestion.setOptions(options);

        questionRepository.save(forSaveQuestion);

        return converter.toResponse(forSaveQuestion);
    }

    public String answer(Long questionId, Long optionNo) {
        var realAnswerNo = questionRepository.findById(questionId).orElseThrow(() -> new GeneralException(ErrorStatusCode.USER_NOT_FOUND))
                .getAnswerNo();

        var option = optionService.getOptionsByQuestionId(questionId).stream().filter(o -> o.getOptionNo() == optionNo).toList();

        if (realAnswerNo == optionNo) {
            return "Correct! " + " : " + option.get(0).getHead();
        }
        return "Wrong! " + " : " + option.get(0).getHead();
    }
}
