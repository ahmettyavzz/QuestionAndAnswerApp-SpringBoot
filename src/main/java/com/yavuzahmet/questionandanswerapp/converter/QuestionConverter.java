package com.yavuzahmet.questionandanswerapp.converter;

import com.yavuzahmet.questionandanswerapp.model.Question;
import com.yavuzahmet.questionandanswerapp.response.OptionResponse;
import com.yavuzahmet.questionandanswerapp.response.QuestionResponse;
import org.springframework.stereotype.Component;

@Component
public class QuestionConverter {

    public QuestionResponse toResponse(Question entity) {
        var optionResponseList =
                entity.getOptions().stream().map(option -> new OptionResponse(option.getHead())).toList();

        return new QuestionResponse(entity.getHead(), optionResponseList);
    }
}
