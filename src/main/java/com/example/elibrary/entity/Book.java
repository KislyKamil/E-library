package com.example.elibrary.entity;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Data
@Table(name = "book")
@DynamicUpdate
public class Book implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(insertable = false, name = "book_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer bookId;

  @Column(name = "name")
  private String name;

  @Column(name = "author")
  private String author;

  @Column(name = "status", nullable = false)
  private Boolean status;


}