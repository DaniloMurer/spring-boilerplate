package com.danilojakob.application.service;

import com.danilojakob.application.domain.ApplicationUser;
import com.danilojakob.application.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    /**
     * Repository to access data from service
     */
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Get User by it's username
     * @param username {@link String} username of the user
     * @return {@link ApplicationUser}
     */
    public ApplicationUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Add user to the database
     * @param applicationUser {@link ApplicationUser} user to add to the database
     */
    public void saveUser(ApplicationUser applicationUser) {
        userRepository.saveAndFlush(applicationUser);
    }
 }
