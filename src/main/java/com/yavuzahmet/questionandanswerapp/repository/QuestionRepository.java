package com.yavuzahmet.questionandanswerapp.repository;

import com.yavuzahmet.questionandanswerapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}