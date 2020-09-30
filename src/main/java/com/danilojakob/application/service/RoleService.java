package com.danilojakob.application.service;

import com.danilojakob.application.domain.Role;
import com.danilojakob.application.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Role Service
 * @copyright Danilo Jakob
 */
@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public List<Role> findByNames(List<String> roles) {
        return roleRepository.findByNameIn(roles);
    }

    public Role getDefaultRole() {
        return roleRepository.findByName("USER");
    }
}
