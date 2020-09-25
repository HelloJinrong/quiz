package com.twuc.shopping.api;


import com.twuc.shopping.domain.Goods;
import com.twuc.shopping.dto.GoodsDto;
import com.twuc.shopping.service.GoodsService;
import com.twuc.shopping.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class GoodsController {
    private final GoodsService goodsService;
    private final OrderService orderService;

    public GoodsController(GoodsService goodsService, OrderService orderService) {
        this.goodsService = goodsService;
        this.orderService = orderService;
    }

    @GetMapping("/goods")
    @CrossOrigin
    public ResponseEntity<List<GoodsDto>> getGoods(){
        return goodsService.getGoods();
    }

    @PostMapping("/goods/{id}")
    @CrossOrigin
    public ResponseEntity addGoodToOrder(@PathVariable int id){
        return orderService.addOrder(id);
    }

    @PostMapping("/goods")
    @CrossOrigin
    public ResponseEntity addGood(@RequestBody Goods good){
        return goodsService.addGood(good);
    }
}
