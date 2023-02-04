package com.yavuzahmet.questionandanswerapp.repository;

import com.yavuzahmet.questionandanswerapp.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long> {
}