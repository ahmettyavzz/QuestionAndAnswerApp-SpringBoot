package com.yavuzahmet.questionandanswerapp.dto;

import com.yavuzahmet.questionandanswerapp.model.Option;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
    private String head;
    private List<Option> options;
    private Integer answerNo;
}