package com.twuc.shopping.service;


import com.twuc.shopping.dto.ChartDto;
import com.twuc.shopping.dto.GoodsDto;
import com.twuc.shopping.dto.OrderDto;
import com.twuc.shopping.repository.ChartRespository;
import com.twuc.shopping.repository.GoodsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChartService {
    private final ChartRespository chartRepository;
    private final GoodsRepository goodsRepository;

    public ChartService(ChartRespository chartRepository, GoodsRepository goodsRepository) {
        this.chartRepository = chartRepository;
        this.goodsRepository = goodsRepository;
    }

    public ResponseEntity<List<ChartDto>> getCharts() {
        return ResponseEntity.ok(chartRepository.findAll());
    }

    public ResponseEntity deleteCharts(int id) {
        if (chartRepository.findById(id).isPresent()) {
            chartRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else
            return ResponseEntity.badRequest().build();
    }

    public ResponseEntity deleteAll() {
        chartRepository.deleteAll();
        return ResponseEntity.ok().build();

    }

    public ResponseEntity addCharts(int id) {
        Optional<GoodsDto> goodsDto = goodsRepository.findById(id);
        if (goodsDto.isPresent()) {
            Optional<ChartDto> chartDtoExist = chartRepository.findByName(goodsDto.get().getName());
            //已有
            if (chartDtoExist.isPresent()) {
                chartDtoExist.get().setNumber(chartDtoExist.get().getNumber() + 1);
                chartRepository.save(chartDtoExist.get());
            } else {
                chartRepository.save(ChartDto.builder()
                        .id(id).name(goodsDto.get().getName()).price(goodsDto.get().getPrice())
                        .number(1).build());
            }
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
