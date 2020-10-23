package com.twuc.shopping.api;

import com.twuc.shopping.dto.ChartDto;
import com.twuc.shopping.dto.OrderDto;
import com.twuc.shopping.service.ChartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChartController {
    private final ChartService chartService;

    public ChartController(ChartService chartService) {
        this.chartService = chartService;
    }
    @GetMapping("/chart")
    @CrossOrigin
    public ResponseEntity<List<ChartDto>> getOrders(){
        return chartService.getCharts();
    }

    @DeleteMapping("/chart/{id}")
    @CrossOrigin
    public ResponseEntity<List<ChartDto>> deleteOrder(@PathVariable int id){
        return chartService.deleteCharts(id);
    }

    @DeleteMapping("/chart/all")
    @CrossOrigin
    public ResponseEntity<List<ChartDto>> deleteAllChart(){
        return chartService.deleteAll();
    }
}

