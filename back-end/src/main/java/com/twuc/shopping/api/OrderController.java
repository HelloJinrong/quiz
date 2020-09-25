package com.twuc.shopping.api;


import com.twuc.shopping.dto.OrderDto;
import com.twuc.shopping.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/order")
    @CrossOrigin
    public ResponseEntity<List<OrderDto>> getOrders(){
        return orderService.getOrders();
    }

    @DeleteMapping("/order/{id}")
    @CrossOrigin
    public ResponseEntity<List<OrderDto>> deleteOrder(@PathVariable int id){
        return orderService.deleteOrder(id);
    }

}
