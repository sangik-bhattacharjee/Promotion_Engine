package com.example.promotion.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.promotion.helper.RequestDetail;
import com.example.promotion.helper.ResponseDetail;
import com.example.promotion.helper.SKU;
import com.example.promotion.service.PromotionService;


@RestController
@ComponentScan({"com.example.promotion.service"})
public class PromotionController {
	
	@GetMapping("/welcome")
	public String welcomepage() {
		return "Welcome to Yawin Tutor";
	}
	
	@Autowired
	private PromotionService promotionService;
	
	@GetMapping("/findPrice")
	@ResponseBody
	public ResponseDetail fetchFinalPrice(
			@RequestParam(name="skuA", defaultValue = "0") Optional<Integer> quantityofA,
			@RequestParam(name="skuB", defaultValue = "0") Optional<Integer> quantityofB,
			@RequestParam(name="skuC", defaultValue = "0") Optional<Integer> quantityofC,
			@RequestParam(name="skuD", defaultValue = "0") Optional<Integer> quantityofD) {
		ResponseDetail response=null;
		List<SKU> skudetails = null;
		
		try {
			
			RequestDetail request = new RequestDetail();
			skudetails=new ArrayList<>();
			
			if(quantityofA.isPresent() && quantityofA.get()>0) {
				SKU skuA=new SKU();
				skuA.setSKU_Id("A");
				skuA.setSKU_Unit(quantityofA.get());
				skudetails.add(skuA);
			}
			if(quantityofB.isPresent() && quantityofB.get()>0) {
				SKU skuB=new SKU();
				skuB.setSKU_Id("B");
				skuB.setSKU_Unit(quantityofB.get());
				skudetails.add(skuB);
			}
			if(quantityofC.isPresent() && quantityofC.get()>0) {
				SKU skuC=new SKU();
				skuC.setSKU_Id("C");
				skuC.setSKU_Unit(quantityofC.get());
				skudetails.add(skuC);
			}
			if(quantityofD.isPresent() && quantityofD.get()>0) {
				SKU skuD=new SKU();
				skuD.setSKU_Id("D");
				skuD.setSKU_Unit(quantityofD.get());
				skudetails.add(skuD);
			}
			request.setSKUDetails(skudetails);
			response=promotionService.fetchFinalPriceOfProducts(request);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
