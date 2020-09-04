package com.eshop.api.identity.model;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "application_user")
@Data
public class SysUser {

    @Column(name = "card_holder_name")
    private String cardHolderName;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "card_type")
    private Integer cardType;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
    @Column(name = "email")
    private String email;
    @Column(name = "expiration")
    private String expiration;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "state")
    private String state;
    @Column(name = "street")
    private String street;
    @Column(name = "security_number")
    private String securityNumber;
    @Column(name = "normalized_email")
    private String normalizedEmail;
    @Column(name = "normalized_user_name")
    private String normalizedUserName;
    @Column(name = "security_stamp")
    private String securityStamp;
    @Column(name = "create_time")
    private Instant createTime;
    @Column(name = "update_time")
    private Instant updateTime;
}
