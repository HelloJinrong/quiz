package com.twuc.shopping.service;


import com.twuc.shopping.domain.Goods;
import com.twuc.shopping.dto.GoodsDto;
import com.twuc.shopping.repository.GoodsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    private final GoodsRepository goodsRepository;

    public GoodsService(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    public ResponseEntity addGood(Goods good){
        if(goodsRepository.findByName(good.getName()).isPresent()){
            return ResponseEntity.badRequest().build();
        }
        goodsRepository.save(GoodsDto.builder()
                .name(good.getName())
                .price(good.getPrice())
                .unit(good.getUnit())
                .imgUrl(good.getImgUrl()).build());
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<GoodsDto>> getGoods(){
        return ResponseEntity.ok(goodsRepository.findAll());
    }
}
