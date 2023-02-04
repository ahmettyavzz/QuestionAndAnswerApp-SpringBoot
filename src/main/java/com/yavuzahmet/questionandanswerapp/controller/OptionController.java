package com.yavuzahmet.questionandanswerapp.controller;

import com.yavuzahmet.questionandanswerapp.dto.OptionDto;
import com.yavuzahmet.questionandanswerapp.response.OptionResponse;
import com.yavuzahmet.questionandanswerapp.model.Option;
import com.yavuzahmet.questionandanswerapp.service.OptionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/option")
public class OptionController {
    private final OptionService optionService;

    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping("/{id}")
    public OptionResponse getQuestionById(@PathVariable String id) {
        return optionService.getQuestionById(id);
    }

    @PostMapping
    public Option saveQuestion(@RequestBody OptionDto optionDto) {
        return optionService.saveOption(optionDto);
    }

    @GetMapping
    public List<OptionResponse> getAllOptions(){
        return optionService.getAllOptions();
    }
}
