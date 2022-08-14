package com.example.springrestfulpractice.service;

import com.example.springrestfulpractice.controller.dto.request.CreateOrderRequest;
import com.example.springrestfulpractice.controller.dto.request.UpdateOrderRequest;
import com.example.springrestfulpractice.model.MealRepository;
import com.example.springrestfulpractice.model.OrderRepository;
import com.example.springrestfulpractice.model.entity.Meal;
import com.example.springrestfulpractice.model.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MealRepository mealRepository;
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrder(int seq) {
        return orderRepository.findBySeq(seq);
    }

    public String createOrder(CreateOrderRequest request) {
        Order order = new Order();

        //塞資料
        order.setSeq(request.getSeq());
        order.setWaiter(request.getWaiter());
        order.setTotalPrice(request.getTotalPrice());

        //儲存進DB
        orderRepository.save(order);

        for(int i = 0; i < request.getMealList().size(); i++){
            Meal meal =  request.getMealList().get(i);
            orderRepository.insertOrderMeal(order.getSeq(), meal.getId());
        }

        return "OK";
    }

    public String updateOrder(int seq, UpdateOrderRequest request) {
        //確認DB有沒有這筆資料
        Order order = orderRepository.findBySeq(seq);
        if(order == null){
            return "Fail";
        }
        //將要更改的值塞進去
        order.setTotalPrice(request.getTotalPrice());
        order.setWaiter(request.getWaiter());
        //儲存進DB
        orderRepository.save(order);

        orderRepository.deleteOrderMealBySeq(seq);

        for(int i = 0; i < request.getMealList().size(); i++){
            orderRepository.insertOrderMeal(seq, request.getMealList().get(i).getId());
        }

        //回傳OK告訴Controller完成儲存
        return "OK";
    }

    public String deleteOrderBySeq(int seq) {
        Order order = orderRepository.findBySeq(seq);
        if(null == order){
            return "Fail";
        }
        orderRepository.deleteOrderMealBySeq(seq);//先刪除order_meal，因為這張表有關連到order
        orderRepository.deleteOrderBySeq(seq);//再刪除order
        return "OK";
    }
    public int getOrderTotalPrice(List<Meal> mealList) {
        int sum = 0;
        for (Meal meal : mealList) {
            sum += meal.getPrice();
        }
        return sum;
    }
}
