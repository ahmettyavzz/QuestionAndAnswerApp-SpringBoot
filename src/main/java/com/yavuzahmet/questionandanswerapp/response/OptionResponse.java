package com.yavuzahmet.questionandanswerapp.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OptionResponse {
    private Long id;
    private Long questionId;
    private String head;
    private String questionHead;
}