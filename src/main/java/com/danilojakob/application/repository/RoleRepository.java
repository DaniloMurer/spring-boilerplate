package com.danilojakob.application.repository;

import com.danilojakob.application.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Role Repository
 * @copyright Danilo Jakob
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    List<Role> findByNameIn(List<String> roles);
}
