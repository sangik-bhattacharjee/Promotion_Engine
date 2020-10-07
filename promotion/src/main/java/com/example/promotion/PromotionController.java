package com.example.promotion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromotionController {
	@GetMapping("/findPrice")
	public int fetchFinalPrice() {
		
		return 0;
	}

}
