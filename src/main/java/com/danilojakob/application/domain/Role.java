package com.danilojakob.application.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Role Entity
 * @copyright Danilo Jakob
 */
@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 256)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<ApplicationUser> applicationUsers;

}
