package com.danilojakob.application.controller;

import com.danilojakob.application.domain.ApplicationUser;
import com.danilojakob.application.domain.Role;
import com.danilojakob.application.service.RoleService;
import com.danilojakob.application.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

/**
 * User Controller
 * @copyright Danilo Jakob
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private RoleService roleService;
    private BCryptPasswordEncoder encryption;

    public UserController(UserService userService, BCryptPasswordEncoder encryption, RoleService roleService) {
        this.userService = userService;
        this.encryption = encryption;
        this.roleService = roleService;
    }

    /**
     * Create a new User
     * @param applicationUser {@link ApplicationUser} user to create
     * @return {@link ResponseEntity} with Status Code and new created User
     */
    @PostMapping(value = "/signup")
    public ResponseEntity signUp(@Validated @RequestBody ApplicationUser applicationUser) {
        applicationUser.setPassword(encryption.encode(applicationUser.getPassword()));
        Set<Role> roles = new HashSet<>();

        // If no roles are provided, create standard Role User. Else create user with provided roles
        if (applicationUser.getRoles().isEmpty() || applicationUser.getRoles() == null) {
            Role newRole = roleService.findByName("USER");
            roles.add(newRole);
        } else {
            applicationUser.getRoles().forEach(role -> {
                Role tempRole = roleService.findByName(role.getName());
                roles.add(tempRole);
            });
        }
        applicationUser.setRoles(roles);
        userService.saveUser(applicationUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
