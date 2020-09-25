package com.twuc.shopping.repository;

import com.twuc.shopping.dto.GoodsDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GoodsRepository extends CrudRepository<GoodsDto,Integer> {
    List<GoodsDto> findAll();
    Optional<GoodsDto> findByName(String name);
    Optional<GoodsDto> findById(Integer id);
}
