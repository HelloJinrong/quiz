package com.twuc.shopping.repository;


import com.twuc.shopping.dto.OrderFromChartDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderFromChartRespository extends CrudRepository<OrderFromChartDto,Integer> {
    List<OrderFromChartDto> findAll();
    Optional<OrderFromChartDto> findByName(String name);
}
