package com.twuc.shopping;

import com.twuc.shopping.dto.GoodsDto;
import com.twuc.shopping.repository.GoodsRepository;
import com.twuc.shopping.repository.OrderRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppingApplication {
	static GoodsRepository goodsRepository = null;


	public ShoppingApplication(GoodsRepository goodsRepository) {
		this.goodsRepository=goodsRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);
		GoodsDto goodsDto = GoodsDto.builder()
				.name("apple")
				.price(5.32)
				.unit("kg")
				.imgUrl("/Users/HJR/Desktop/quiz/images/apple.jpeg")
				.build();
		goodsRepository.save(goodsDto);

		GoodsDto goodsDto2 = GoodsDto.builder()
				.name("banana")
				.price(9.64)
				.unit("kg")
				.imgUrl("/Users/HJR/Desktop/quiz/images/banana.jpeg")
				.build();
		goodsRepository.save(goodsDto2);




	}

}
