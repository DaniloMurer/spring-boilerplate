package com.danilojakob.application.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * User Entity
 * @copyright Danilo Jakob
 */
@Entity
@Data
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Role> roles;

}
