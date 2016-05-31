package com.example.repository;

import com.example.Application;
import com.example.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Transactional
@IntegrationTest
public class UserRepositoryIT {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() {
        userRepository.save(new User("Name", "LastName"));

        assertFalse(userRepository.findByFirstNameAndLastName("Name", "LastName").isEmpty());
    }
}
