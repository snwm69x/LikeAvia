package com.sneg.likevavo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import com.sneg.likevavo.entities.User;
import com.sneg.likevavo.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class RepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void userRepositoryAddUserCheck() {
        User user = new User("valya_testovich", "valentin@test.com", "123456789f", "ROLE_USER");
        entityManager.persist(user);
        entityManager.flush();
        Optional<User> found = userRepository.findByUsername(user.getUsername());
        if (found.isPresent()) {
            assert (found.get().getUsername().equals(user.getUsername()));
        } else {
            assert (false);
        }

    }

    @Test
    public void userRepositoryDeleteUserCheck() {
        User user = new User("valya_testovi4", "valentin4@test.com", "123456789f", "ROLE_USER");
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            userRepository.delete(user);
            assertTrue(userRepository.findByUsername(user.getUsername()).isEmpty());
        } else {
            entityManager.persist(user);
            entityManager.flush();
            entityManager.clear();
            userRepository.delete(user);
            assertTrue(userRepository.findByUsername(user.getUsername()).isEmpty());
        }
        assertTrue(true);
    }

    @Test
    public void userRepositoryUpdateTest() {
        User user = new User("test_user4", "test_user4@test.com", "password1", "ROLE_USER");
        entityManager.persist(user);
        entityManager.flush();
        user.setEmail("new_email@test.com");
        userRepository.save(user);
        Optional<User> found = userRepository.findByUsername(user.getUsername());
        assertTrue(found.isPresent());
        assertEquals(user.getEmail(), found.get().getEmail());
    }
}
