package com.twuc.shopping.repository;

import com.twuc.shopping.dto.ChartDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ChartRespository extends CrudRepository<ChartDto,Integer> {
    List<ChartDto> findAll();
    Optional<ChartDto> findByName(String name);
    void deleteAll();
}
