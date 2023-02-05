package com.yavuzahmet.questionandanswerapp.repository;

import com.yavuzahmet.questionandanswerapp.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findByQuestionId(Long questionId);
}