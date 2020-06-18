package com.kbc.dao.jpa;

import com.kbc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();
}