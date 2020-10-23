package com.twuc.shopping.service;


import com.twuc.shopping.domain.OrderFromChart;
import com.twuc.shopping.dto.ChartDto;
import com.twuc.shopping.dto.GoodsDto;
import com.twuc.shopping.dto.OrderDto;
import com.twuc.shopping.dto.OrderFromChartDto;
import com.twuc.shopping.repository.ChartRespository;
import com.twuc.shopping.repository.GoodsRepository;
import com.twuc.shopping.repository.OrderFromChartRespository;
import com.twuc.shopping.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final GoodsRepository goodsRepository;
    private final ChartRespository chartRespository;
    private final OrderFromChartRespository orderFromChartRespository;

    public OrderService(OrderRepository orderRepository, GoodsRepository goodsRepository,
                        ChartRespository chartRespository, OrderFromChartRespository orderFromChartRespository) {
        this.orderRepository = orderRepository;
        this.goodsRepository = goodsRepository;
        this.chartRespository = chartRespository;
        this.orderFromChartRespository = orderFromChartRespository;
    }

    public ResponseEntity<List<OrderFromChartDto>> getOrders() {
        return ResponseEntity.ok(orderFromChartRespository.findAll());
    }

    public ResponseEntity addOrder(Integer id) {
        Optional<GoodsDto> goodsDto = goodsRepository.findById(id);
        if (goodsDto.isPresent()) {
            Optional<OrderDto> orderDtoExist = orderRepository.findByName(goodsDto.get().getName());
            //订单已有
            if (orderDtoExist.isPresent()) {
                orderDtoExist.get().setNumber(orderDtoExist.get().getNumber() + 1);
                orderRepository.save(orderDtoExist.get());
            } else {
                orderRepository.save(OrderDto.builder()
                        .id(id).name(goodsDto.get().getName())
                        .number(1).price(goodsDto.get().getPrice())
                        .unit(goodsDto.get().getUnit()).build());
            }
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }


    public ResponseEntity addOrderFromChart(Integer id) {
        Optional<ChartDto> chartDto = chartRespository.findById(id);
        orderFromChartRespository.save(OrderFromChartDto.builder()
                .id(id).name(chartDto.get().getName())
                .number(chartDto.get().getNumber())
                .price(chartDto.get().getPrice()).build());
        return ResponseEntity.ok().build();

    }

    public ResponseEntity deleteOrder(int id) {
        if (orderRepository.findById(id).isPresent()) {
            orderRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else
            return ResponseEntity.badRequest().build();
    }
}
