package com.example.promotion.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.promotion.helper.RequestDetail;
import com.example.promotion.helper.ResponseDetail;
import com.example.promotion.helper.SKU;
import com.example.promotion.service.PromotionService;


@RestController
public class PromotionController {
	
	@Autowired
	private PromotionService promotionService;
	
	private List<SKU> skudetails = new ArrayList<>();
	
	@GetMapping("/findPrice")
	public ResponseDetail fetchFinalPrice(@QueryParam("skuA") int quantityofA,
			@QueryParam("skuB") int quantityofB,
			@QueryParam("skuC") int quantityofC,
			@QueryParam("skuD") int quantityofD) {
		
		RequestDetail request = new RequestDetail();
		
		if(quantityofA>0) {
			SKU skuA=new SKU();
			skuA.setSKU_Id("A");
			skuA.setSKU_Unit(quantityofA);
			skudetails.add(skuA);
		}
		if(quantityofB>0) {
			SKU skuB=new SKU();
			skuB.setSKU_Id("B");
			skuB.setSKU_Unit(quantityofB);
			skudetails.add(skuB);
		}
		if(quantityofC>0) {
			SKU skuC=new SKU();
			skuC.setSKU_Id("B");
			skuC.setSKU_Unit(quantityofC);
			skudetails.add(skuC);
		}
		if(quantityofD>0) {
			SKU skuD=new SKU();
			skuD.setSKU_Id("B");
			skuD.setSKU_Unit(quantityofD);
			skudetails.add(skuD);
		}
		request.setSKUDetails(skudetails);
		ResponseDetail response=promotionService.fetchFinalPriceOfProducts(request);
		
		return response;
	}

}
