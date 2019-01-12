package com.mybusiness.filmclub.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @Column(name = "registration")
    private Date registrationDate;

    @PrePersist
    protected void onCreate() {
        registrationDate =  new Date();
    }
}
