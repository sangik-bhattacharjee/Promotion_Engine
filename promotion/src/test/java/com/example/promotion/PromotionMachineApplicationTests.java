package com.example.promotion;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.promotion.controller.PromotionController;
import com.example.promotion.helper.ResponseDetail;



@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
class PromotionMachineApplicationTests {
	
	@Autowired
	private PromotionController promotionController;

	@Test
	void fetchFinalPriceTest_One() {
		Optional<Integer> sku_A = Optional.of(1);
		Optional<Integer> sku_B = Optional.of(1);
		Optional<Integer> sku_C = Optional.of(1);
		Optional<Integer> sku_D = Optional.of(0);
		
		ResponseDetail response=promotionController.fetchFinalPrice(sku_A, sku_B, sku_C, sku_D);
		Assert.assertEquals(response.getTotalAmount(), 100);
		
	}
	
	@Test
	void fetchFinalPriceTest_Two() {
		Optional<Integer> sku_A = Optional.of(1);
		Optional<Integer> sku_B = Optional.of(1);
		Optional<Integer> sku_C = Optional.of(1);
		Optional<Integer> sku_D = Optional.of(1);
		
		ResponseDetail response=promotionController.fetchFinalPrice(sku_A, sku_B, sku_C, sku_D);
		System.out.println(response.getTotalAmount());
		Assert.assertEquals(response.getTotalAmount(), 110);
		
	}
	
	@Test
	void fetchFinalPriceTest_Three() {
		Optional<Integer> sku_A = Optional.of(5);
		Optional<Integer> sku_B = Optional.of(5);
		Optional<Integer> sku_C = Optional.of(1);
		Optional<Integer> sku_D = Optional.of(0);
		
		ResponseDetail response=promotionController.fetchFinalPrice(sku_A, sku_B, sku_C, sku_D);
		Assert.assertEquals(response.getTotalAmount(), 370);
		
	}
	
	@Test
	void fetchFinalPriceTest_Four() {
		Optional<Integer> sku_A = Optional.of(3);
		Optional<Integer> sku_B = Optional.of(5);
		Optional<Integer> sku_C = Optional.of(1);
		Optional<Integer> sku_D = Optional.of(1);
		
		ResponseDetail response=promotionController.fetchFinalPrice(sku_A, sku_B, sku_C, sku_D);
		System.out.println(response.getTotalAmount());
		Assert.assertEquals(response.getTotalAmount(), 280);
		
	}
	
	@Test
	void fetchFinalPriceTest_Five() {
		Optional<Integer> sku_A = Optional.of(1);
		Optional<Integer> sku_B = Optional.of(1);
		Optional<Integer> sku_C = Optional.of(1);
		Optional<Integer> sku_D = Optional.of(1);
		
		ResponseDetail response=promotionController.fetchFinalPrice(sku_A, sku_B, sku_C, sku_D);
		Assert.assertNotEquals(response.getTotalAmount(), 115);
		
	}
	
	

}
