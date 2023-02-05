package com.yavuzahmet.questionandanswerapp.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse {
    private String head;
    private List<OptionResponse> options;
}