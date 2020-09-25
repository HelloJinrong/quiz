package com.twuc.shopping.api;

import com.twuc.shopping.dto.GoodsDto;
import com.twuc.shopping.dto.OrderDto;
import com.twuc.shopping.repository.GoodsRepository;
import com.twuc.shopping.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    GoodsRepository goodsRepository;
    @Autowired
    OrderRepository orderRepository;

    @BeforeEach
    void setup(){
        goodsRepository.deleteAll();
        orderRepository.deleteAll();
        GoodsDto goodsDto = GoodsDto.builder()
                .name("apple")
                .price(5.3)
                .unit("kilogram")
                .imgUrl("../images/2")
                .build();
        goodsRepository.save(goodsDto);
        OrderDto orderDto=OrderDto.builder()
                .name("banana")
                .number(5)
                .price(4.0)
                .unit("kilogram")
                .build();
        orderRepository.save(orderDto);
        OrderDto orderDto2=OrderDto.builder()
                .name("watermanlon")
                .number(1)
                .price(45)
                .unit("kilogram")
                .build();
        orderRepository.save(orderDto2);
        GoodsDto goodsDto2 = GoodsDto.builder()
                .name("peach")
                .price(5.3)
                .unit("kilogram")
                .imgUrl("../images/1")
                .build();
        goodsRepository.save(goodsDto2);
    }
    @Test
    void should_get_order() throws Exception {
        mockMvc.perform(get("/order"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("banana")))
                .andExpect(jsonPath("$[0].number", is(5)))
                .andExpect(status().isOk());
    }

    @Test
    void should_delete_order() throws Exception {
        int orderIdToDelete = orderRepository.findAll().get(0).getId();
        mockMvc.perform(delete("/order/"+orderIdToDelete))
                .andExpect(status().isOk());
        assertEquals(1, orderRepository.findAll().size());
    }

    @Test
    void should_return_bad_request_when_delete_not_exist_order() throws Exception {
        int orderIdToDelete = -1;
        mockMvc.perform(delete("/order/"+orderIdToDelete))
                .andExpect(status().isBadRequest());
    }
}
