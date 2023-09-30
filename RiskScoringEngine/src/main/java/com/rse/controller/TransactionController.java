package com.rse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.rse.model.RseTransactionDetails;
import com.rse.service.PredictionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

		@Autowired
		PredictionService predictionService;

		@PostMapping("/getPrediction")
		public String getPrediction(@RequestBody String request) {
			
			Gson gson = new Gson();
			RseTransactionDetails rseTransactionDetails = null;
			rseTransactionDetails=gson.fromJson(request,RseTransactionDetails.class);
			return predictionService.getPrediction(rseTransactionDetails) ;
		}

		@PostMapping("/postTransaction")
		public RseTransactionDetails postTransaction(@RequestBody String request ) {
			System.out.println("FROM PHP : "+request);
			Gson gson = new Gson();
			RseTransactionDetails rseTransactionDetails = null;
			rseTransactionDetails=gson.fromJson(request,RseTransactionDetails.class);
			return predictionService.saveTransaction(rseTransactionDetails);
		}
}
