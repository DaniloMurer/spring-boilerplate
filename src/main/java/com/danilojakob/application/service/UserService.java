package com.danilojakob.application.service;

import com.danilojakob.application.domain.Role;
import com.danilojakob.application.domain.User;
import com.danilojakob.application.dtos.SignUpDto;
import com.danilojakob.application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * User Service
 * @copyright Danilo Jakob
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleService roleService;

    /**
     * Repository to access data from service
     */
    private final UserRepository userRepository;

    public User createUserFrom(SignUpDto signUpDto) {

        Set<Role> roles = roleService.findByNames(signUpDto.getRoles());
        if(roles.isEmpty()){
            roles.add(roleService.getDefaultRole());
        }

        return new User(
                signUpDto.getUsername(),
                bCryptPasswordEncoder.encode(signUpDto.getPassword()),
                roles
        );
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
