package com.sneg.likevavo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.sneg.likevavo.entities.User;
import com.sneg.likevavo.repository.UserRepository;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegistrationProcessControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    private static final String REGISTRATION_URL = "/registration/process";
    private int count = 0;
    private int count2 = 0;

    @Test
    public void testRegistration() throws Exception {
        mockMvc.perform(post(REGISTRATION_URL)
                .param("username", "testuser" + count)
                .param("email", "testuser" + count + "@example.com")
                .param("password", "testpassword" + count));


        Optional<User> user = userRepository.findByUsername("testuser" + count);
        assertTrue(user.isPresent());
        assertEquals("testuser"+ count + "@example.com", user.get().getEmail());

        mockMvc.perform(get("/login"))
            .andExpect(status().isOk());

        mockMvc.perform(post("/login/process")
                .param("username", "testuser" + count)
                .param("password", "testpassword" + count))
            .andExpect(status().is3xxRedirection());

        count++;
    }

    @Test
    public void testInvalidUser() throws Exception {
        mockMvc.perform(post(REGISTRATION_URL)
                .param("username", "3213123")
                .param("email", "323133")
                .param("password", "12345"));

        Optional<User> user = userRepository.findByUsername("3213123");
    
        assertFalse(user.isPresent());
    }

    @Test
    public void testUsernameValidation() throws Exception {
        mockMvc.perform(post(REGISTRATION_URL)
                .param("username", "us")
                .param("email", "testuser" + count + "@example.com")
                .param("password", "testpassword" + count));

            
        Optional<User> user = userRepository.findByUsername("us"); 
        assertFalse(user.isPresent());
        
        mockMvc.perform(post(REGISTRATION_URL)
                .param("username", "usernamewithmorethan15characters")
                .param("email", "testuser" + count + "@example.com")
                .param("password", "testpassword" + count));
        
        Optional<User> user1 = userRepository.findByUsername("usernamewithmorethan15characters"); 
        assertFalse(user1.isPresent());
        
        mockMvc.perform(post(REGISTRATION_URL)
                .param("username", "user@name")
                .param("email", "testuser" + count + "@example.com")
                .param("password", "testpassword" + count));

        Optional<User> user2 = userRepository.findByUsername("user@name"); 
        assertFalse(user2.isPresent());
    }
    
    @Test
    public void testEmailValidation() throws Exception {
        mockMvc.perform(post(REGISTRATION_URL)
                .param("username", "testusertest")
                .param("email", "invalidemailformat")
                .param("password", "testpassword"));

        Optional<User> user2 = userRepository.findByEmail("invalidemailformat"); 
        assertFalse(user2.isPresent());
    }
    
    @Test
    public void testPasswordValidation() throws Exception {
        mockMvc.perform(post(REGISTRATION_URL)
                .param("username", "testuseruser")
                .param("email", "testusertest@example.com")
                .param("password", "password"));

        Optional<User> user = userRepository.findByUsername("testuseruser"); 
        assertFalse(user.isPresent());
        
        mockMvc.perform(post(REGISTRATION_URL)
                .param("username", "testuseruber")
                .param("email", "testuseruber@example.com")
                .param("password", "12345678"));
            
        Optional<User> user1 = userRepository.findByUsername("testuseruber"); 
        assertFalse(user1.isPresent());
        
        mockMvc.perform(post(REGISTRATION_URL)
                .param("username", "testuser" + count2)
                .param("email", "testuser" + count2 + "@example.com")
                .param("password", "password123"));

        Optional<User> user2 = userRepository.findByUsername("testuser" + count2); 
        assertTrue(user2.isPresent());
    }
}
    

