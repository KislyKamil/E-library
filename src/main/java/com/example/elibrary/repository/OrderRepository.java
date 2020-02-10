package com.example.elibrary.repository;


import com.example.elibrary.entity.Order;
import com.example.elibrary.model.order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>, JpaSpecificationExecutor<Order> {


   String FIND_ORDERS = "SELECT * FROM orders WHERE userId=?1";

   @Query(value = FIND_ORDERS, nativeQuery = true)
   List<Order> showOrders(@Param("id") int id);



}
