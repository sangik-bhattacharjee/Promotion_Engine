package com.example.promotion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.promotion.service.PromotionService;


@RestController
public class PromotionController {
	
	@Autowired
	private PromotionService promotionService;
	
	@GetMapping("/findPrice")
	public String fetchFinalPrice() {
		return "Books";
	}

}
