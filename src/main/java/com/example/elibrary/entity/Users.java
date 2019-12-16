package com.example.elibrary.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Table(name = "users")
@Entity
@Data
public class Users implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(insertable = false, name = "user_id", nullable = false)
  private Integer userId;

  @Column(name = "login", nullable = false)
  private String login;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "type")
  private String type = "NULL";

  
}