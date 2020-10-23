package com.twuc.shopping.api;


import com.twuc.shopping.domain.Goods;
import com.twuc.shopping.dto.GoodsDto;
import com.twuc.shopping.service.ChartService;
import com.twuc.shopping.service.GoodsService;
import com.twuc.shopping.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class GoodsController {
    private final GoodsService goodsService;
    private final ChartService chartService;

    public GoodsController(GoodsService goodsService, ChartService chartService) {
        this.goodsService = goodsService;
        this.chartService = chartService;
    }

    @GetMapping("/goods")
    @CrossOrigin
    public ResponseEntity<List<GoodsDto>> getGoods(){
        return goodsService.getGoods();
    }

    @PostMapping("/goods/{id}")
    @CrossOrigin
    public ResponseEntity addGoodToChart(@PathVariable int id){
        return chartService.addCharts(id);
    }

    @PostMapping("/goods")
    @CrossOrigin
    public ResponseEntity addGood(@RequestBody Goods good){
        return goodsService.addGood(good);
    }
}
