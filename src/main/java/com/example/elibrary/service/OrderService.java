package com.example.elibrary.service;


import com.example.elibrary.entity.Order;
import com.example.elibrary.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order getOrder(int id){

        return orderRepository.findById(id).get();
    }

    public void addOrder(Order order){

        orderRepository.save(order);
    }

    public void deleteOrder(int id){

        orderRepository.deleteById(id);
    }

    public List<Order> listOrders(){

        List<Order> orders = new ArrayList<>();
        orders.addAll(orderRepository.findAll());

        return orders;
    }

    public List<Order> listByUserId(List<Integer> ids){

        List<Order> userOrders = new ArrayList<>();
        userOrders.addAll(orderRepository.findAllById(ids));

        return userOrders;
    }

}
