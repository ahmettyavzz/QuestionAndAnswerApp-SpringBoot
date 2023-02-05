package com.yavuzahmet.questionandanswerapp.service;

import com.yavuzahmet.questionandanswerapp.model.Option;
import com.yavuzahmet.questionandanswerapp.repository.OptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {
    private final OptionRepository repository;

    public OptionService(OptionRepository repository) {
        this.repository = repository;
    }
    public List<Option>  getOptionsByQuestionId(Long id){
       return repository.findByQuestionId(id);
    }
}
