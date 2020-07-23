package com.example.cs.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户实体类
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Table(name="user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //用户名
    @Column(name = "user_name")
    private String userName;
    //密码
    @Column(name = "password")
    private String password;
    //角色
    @Column(name = "role")
    private String role;
    //email
    @Column(name = "email")
    private String email;

}
