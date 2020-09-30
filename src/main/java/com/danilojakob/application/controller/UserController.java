package com.danilojakob.application.controller;

import com.danilojakob.application.domain.User;
import com.danilojakob.application.dtos.SignUpDto;
import com.danilojakob.application.service.RoleService;
import com.danilojakob.application.service.UserService;
import com.danilojakob.application.validator.SignUpValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * User Controller
 * @copyright Danilo Jakob
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final RoleService roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final SignUpValidator signUpValidator;

    @InitBinder("signUpDto")
    public void initChangeCommuneBinder(WebDataBinder binder) {
        binder.setValidator(signUpValidator);
    }

    /**
     * Create a new User
     * @param user {@link User} user to create
     * @return {@link ResponseEntity} with Status Code
     */
    @PostMapping(value = "/signup")
    public ResponseEntity signUp(@Validated @RequestBody SignUpDto signUpDto) {

        if(signUpDto.getRoles() == null){
            signUpDto.setRoles(new ArrayList<>());
        }

        User createdUser = userService.createUserFrom(signUpDto);
        userService.save(createdUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
