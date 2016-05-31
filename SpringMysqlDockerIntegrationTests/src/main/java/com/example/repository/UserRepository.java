package com.example.repository;

import com.example.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByFirstNameAndLastName(String firstName, String lastName);

}
