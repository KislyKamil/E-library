package com.example.elibrary.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "orders")
@DynamicUpdate
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(insertable = false, name = "orderid", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    @Column(name = "bookname", nullable = false)
    private String bookName;

    @Column(name = "userid", nullable = false)
    private int userId;

    @Column(name = "date", nullable = false)
    private String date;


}
