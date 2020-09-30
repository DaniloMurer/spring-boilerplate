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

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    public List<Role> findAll() {
        return this.roleRepository.findAll();
    }
}
