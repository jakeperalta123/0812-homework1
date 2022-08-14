package com.example.springrestfulpractice.controller;

import com.example.springrestfulpractice.controller.dto.request.CreateOrderRequest;
import com.example.springrestfulpractice.controller.dto.request.UpdateOrderRequest;
import com.example.springrestfulpractice.controller.dto.response.StatusResponse;
import com.example.springrestfulpractice.model.entity.Order;
import com.example.springrestfulpractice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping()
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{seq}")
    public Order getOrderBySeq(@PathVariable int seq) {
        Order response = orderService.getOrder(seq);
        return response;
    }

    @PostMapping()
    public StatusResponse createOrder(@RequestBody CreateOrderRequest request) {
        String response = orderService.createOrder(request);
        return new StatusResponse(response);
    }

    @PutMapping("/{seq}")
    public StatusResponse updateOrder(@PathVariable int seq, @RequestBody UpdateOrderRequest request) {
        String response = orderService.updateOrder(seq, request);
        return new StatusResponse(response);
    }

    @DeleteMapping("/{seq}")
    public StatusResponse deleteOrderBySeq(@PathVariable int seq) {
       String response = orderService.deleteOrderBySeq(seq);
       return new StatusResponse(response);
    }
}
