package com.example.elibrary.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "book")
public class Book implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(insertable = false, name = "book_id", nullable = false)
  private Integer bookId;

  @Column(name = "name")
  private String name = "'NULL'";

  @Column(name = "author")
  private String author = "NULL";

  @Column(name = "status", nullable = false)
  private Boolean status;

  
}