package com.twuc.shopping;

import com.twuc.shopping.dto.GoodsDto;
import com.twuc.shopping.repository.GoodsRepository;
import com.twuc.shopping.repository.OrderRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppingApplication {
	static GoodsRepository goodsRepository = null;
	static OrderRepository orderRepository = null;



	public static void main(String[] args) {
		GoodsDto goodsDto = GoodsDto.builder()
				.name("apple")
				.price(5.3)
				.unit("kg")
				.imgUrl("")
				.build();
		goodsRepository.save(goodsDto);

		GoodsDto goodsDto2 = GoodsDto.builder()
				.name("fenda")
				.price(5.3)
				.unit("ting")
				.imgUrl("../images/cal.jpg")
				.build();
		goodsRepository.save(goodsDto);



		SpringApplication.run(ShoppingApplication.class, args);
	}

}
