package com.yavuzahmet.questionandanswerapp.converter;

import com.yavuzahmet.questionandanswerapp.response.OptionResponse;
import com.yavuzahmet.questionandanswerapp.model.Option;
import com.yavuzahmet.questionandanswerapp.model.Question;
import org.springframework.stereotype.Component;

@Component
public class OptionConverter {
    public Option toEntity(String head, Question question) {
        var newOption = new Option();
        newOption.setHead(head);
        newOption.setQuestion(question);
        return newOption;
    }

    public OptionResponse toResponse(Option entity) {
        return new OptionResponse(
                entity.getId(),
                entity.getQuestion().getId(),
                entity.getHead(),
                entity.getQuestion().getHead());
    }
}