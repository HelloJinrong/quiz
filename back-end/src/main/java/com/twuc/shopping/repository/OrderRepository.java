package com.twuc.shopping.repository;


import com.twuc.shopping.dto.OrderDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<OrderDto,Integer> {
    List<OrderDto> findAll();
    Optional<OrderDto> findByName(String name);
}

