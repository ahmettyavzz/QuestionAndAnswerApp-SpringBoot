package com.yavuzahmet.questionandanswerapp.converter;

import com.yavuzahmet.questionandanswerapp.dto.QuestionDto;
import com.yavuzahmet.questionandanswerapp.response.QuestionResponse;
import com.yavuzahmet.questionandanswerapp.model.Question;
import org.springframework.stereotype.Component;

@Component
public class QuestionConverter {
    public Question toEntity(QuestionDto dto) {
        return new Question(dto.getHead(), dto.getOptions(), dto.getAnswerNo());
    }

    public QuestionResponse toResource(Question entity) {
        return new QuestionResponse(entity.getHead(), entity.getOptions());
    }
}
