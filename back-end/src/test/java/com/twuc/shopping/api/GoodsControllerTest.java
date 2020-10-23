package com.twuc.shopping.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.domain.Goods;
import com.twuc.shopping.dto.GoodsDto;
import com.twuc.shopping.dto.OrderDto;
import com.twuc.shopping.repository.ChartRespository;
import com.twuc.shopping.repository.GoodsRepository;
import com.twuc.shopping.repository.OrderFromChartRespository;
import com.twuc.shopping.repository.OrderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GoodsControllerTest {
    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    MockMvc mockMvc;
    @Autowired
    GoodsRepository goodsRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ChartRespository chartRespository;
    @Autowired
    OrderFromChartRespository orderFromChartRespository;

    @BeforeEach
    void setup(){
        goodsRepository.deleteAll();
        orderRepository.deleteAll();
        orderFromChartRespository.deleteAll();
        chartRespository.deleteAll();
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

    @AfterEach
    void set_clean(){
        goodsRepository.deleteAll();
        orderRepository.deleteAll();
    }
    @Test
    void should_get_good() throws Exception {
        mockMvc.perform(get("/goods"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("apple")))
                .andExpect(jsonPath("$[0].price", is(5.3)))
                .andExpect(status().isOk());
    }



    @Test
    void should_add_good() throws Exception {
       Goods goods = Goods.builder()
                .name("new")
                .price(100.3)
                .unit("ting")
                .imgUrl("../images")
                .build();
        String requestJson = objectMapper.writeValueAsString(goods);
        mockMvc.perform(post("/goods/").content(requestJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(get("/goods"))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].name", is("new")))
                .andExpect(jsonPath("$[2].price", is(100.3)))
                .andExpect(status().isOk());
    }

}
