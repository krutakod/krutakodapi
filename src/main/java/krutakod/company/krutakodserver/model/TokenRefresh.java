package krutakod.company.krutakodserver.model;

import lombok.Data;

import javax.persistence.*;


public class TokenRefresh {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String tokenRefresh;
    private String username;

    @OneToOne
    @JoinColumn(name = "username")
    private User user;
}
