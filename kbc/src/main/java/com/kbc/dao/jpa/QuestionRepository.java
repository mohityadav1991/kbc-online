package com.kbc.dao.jpa;

import com.kbc.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findAll();
}
