package com.tuts.spring_security.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Authority")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id", nullable = false)
    private Long id;

    @Column(name = "name", length = 45)
    private String name;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users=new HashSet<>();


}
