package com.yavuzahmet.questionandanswerapp.response;

import com.yavuzahmet.questionandanswerapp.model.Option;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class QuestionResponse {
    private String head;
    private List<Option> options;
}