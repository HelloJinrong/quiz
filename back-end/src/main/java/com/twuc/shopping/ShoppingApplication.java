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
				.imgUrl("https://s1.ax1x.com/2020/09/25/0CFznI.th.jpg")
				.build();
		goodsRepository.save(goodsDto);

		GoodsDto goodsDto2 = GoodsDto.builder()
				.name("banana")
				.price(9.64)
				.unit("kg")
				.imgUrl("https://s1.ax1x.com/2020/09/25/0CEG01.th.jpg")
				.build();
		goodsRepository.save(goodsDto2);




	}

}
