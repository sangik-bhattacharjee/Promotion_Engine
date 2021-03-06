package com.example.promotion.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.promotion.helper.RequestDetail;
import com.example.promotion.helper.ResponseDetail;

@Component
public class PromotionService {
	
	@Value("${promotion.properties.activePromotions_3A}")
	int activePromotions_3A;
	
	@Value("${promotion.properties.activePromotions_2B}")
	int activePromotions_2B;
	
	@Value("${promotion.properties.activePromotions_CD}")
	int activePromotions_CD;
	
	@Value("${promotion.properties.unitPriceofA}")
	int unitPriceofA;
	
	@Value("${promotion.properties.unitPriceofB}")
	int unitPriceofB;
	
	@Value("${promotion.properties.unitPriceofC}")
	int unitPriceofC;
	
	@Value("${promotion.properties.unitPriceofD}")
	int unitPriceofD;
	
	
	public ResponseDetail fetchFinalPriceOfProducts(RequestDetail requestDetail) {
		ResponseDetail response = new ResponseDetail();
		int finalAmount=0;
		int totalamount=0;
		
		
		int activePromotions_2B=45;
		int activePromotions_CD=30;
		int unitPriceofA=50;
		int unitPriceofB=30;
		int uniPriceofC=20;
		int unitPriceofD=15;
		
		int quantityofC=0;
		int quantityofD=0;
		if(requestDetail!=null) {
			if(requestDetail.getSKUDetails()!=null && requestDetail.getSKUDetails().size()>0) {
				for(int i=0; i<requestDetail.getSKUDetails().size(); i++) {
					
					if(requestDetail.getSKUDetails().get(i).getSKU_Id().equalsIgnoreCase("A")) {
						
						if(requestDetail.getSKUDetails().get(i).getSKU_Unit()>0) {
							if(requestDetail.getSKUDetails().get(i).getSKU_Unit()/3>0) {
								totalamount=totalamount+(activePromotions_3A*(requestDetail.getSKUDetails().get(i).getSKU_Unit()/3));
							}
							if(requestDetail.getSKUDetails().get(i).getSKU_Unit()%3!=0) {
								totalamount=totalamount+(unitPriceofA*(requestDetail.getSKUDetails().get(i).getSKU_Unit()%3));
							}
						}
						else {
							totalamount=totalamount+0;
						}
					}
					else if(requestDetail.getSKUDetails().get(i).getSKU_Id().equalsIgnoreCase("B")) {
						
						if(requestDetail.getSKUDetails().get(i).getSKU_Unit()>0) {
							if(requestDetail.getSKUDetails().get(i).getSKU_Unit()/2>0) {
								totalamount=totalamount+(activePromotions_2B*(requestDetail.getSKUDetails().get(i).getSKU_Unit()/2));
							}
							if(requestDetail.getSKUDetails().get(i).getSKU_Unit()%2!=0) {
								totalamount=totalamount+(unitPriceofB*(requestDetail.getSKUDetails().get(i).getSKU_Unit()%2));
							}
						}
						else {
							totalamount=totalamount+0;
						}
					}
					else if(requestDetail.getSKUDetails().get(i).getSKU_Id().equalsIgnoreCase("C")) {
						quantityofC=requestDetail.getSKUDetails().get(i).getSKU_Unit();
					}
					else if(requestDetail.getSKUDetails().get(i).getSKU_Id().equalsIgnoreCase("D")) {
						quantityofD=requestDetail.getSKUDetails().get(i).getSKU_Unit();
					}
				}
				if(quantityofC>0 && quantityofD>0) {
					if(quantityofC==quantityofD) {
						totalamount=totalamount+(quantityofC*activePromotions_CD);
					}
					else if(quantityofC>quantityofD) {
						int sumofamountCD=0;
						sumofamountCD=(quantityofD*activePromotions_CD)+((quantityofC-quantityofD)*uniPriceofC);
						totalamount=totalamount+sumofamountCD;
					}
					else if(quantityofD>quantityofC) {
						int sumofamountDC=0;
						sumofamountDC=(quantityofC*activePromotions_CD)+((quantityofD-quantityofC)*unitPriceofD);
						totalamount=totalamount+sumofamountDC;
					}
				}
				else if(quantityofC>0 && quantityofD==0) {
					totalamount=totalamount+(quantityofC*uniPriceofC);
					
				}
				else if (quantityofC==0 && quantityofD>0) {
					totalamount=totalamount+(quantityofD*unitPriceofD);
				}
			}
		}
		finalAmount=totalamount;
		response.setTotalAmount(finalAmount);
		return response;
	}

}
