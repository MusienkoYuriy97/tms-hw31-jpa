package com.teachmeskills.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Table(name = "users_table")
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "select u from User u"),
        @NamedQuery(name = "User.existByUsername", query = "select count(u) from User u where u.username = :username"),
        @NamedQuery(name = "User.existById", query = "select count(u) from User u where u.id = :id"),
        @NamedQuery(name = "User.getById", query = "select u from User u where u.id = :id")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String username;
    private String password;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;
}
