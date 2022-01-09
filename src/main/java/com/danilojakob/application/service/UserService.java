package com.danilojakob.application.service;

import com.danilojakob.application.domain.Role;
import com.danilojakob.application.domain.User;
import com.danilojakob.application.dtos.SignUpDto;
import com.danilojakob.application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User Service
 * @copyright Danilo Jakob
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    /**
     * Repository to access data from service
     */
    private final UserRepository userRepository;

    public User createUserFrom(SignUpDto signUpDto) {

        List<Role> roles = roleService.findByNames(signUpDto.getRoles());
        if(roles.isEmpty()){
            roles.add(roleService.getDefaultRole());
        }

        return new User(
                signUpDto.getUsername(),
                passwordEncoder.encode(signUpDto.getPassword()),
                roles
        );
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
