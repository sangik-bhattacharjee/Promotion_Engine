package com.example.promotion;

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
	void contextLoads() {
		ResponseDetail response=promotionController.fetchFinalPrice(1, 1, 1, 0);
		Assert.assertEquals(response.getTotalAmount(), 100);
		
	}
	
	

}
