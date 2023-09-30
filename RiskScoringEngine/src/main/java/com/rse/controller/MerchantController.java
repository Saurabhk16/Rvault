package com.rse.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.rse.dao.EmailDetailsDao;
import com.rse.model.DocResponce;
import com.rse.model.Document;
import com.rse.model.DocumentSub;
import com.rse.model.EmailDetails;
import com.rse.model.Merchant;
import com.rse.model.Responce;
import com.rse.service.DocumentUploadService;
import com.rse.service.EmailDetailsService;
import com.rse.service.MerService;
import com.rse.service.PredictionService;

@RestController
@RequestMapping("/")
public class MerchantController {

	@Autowired
	PredictionService predictionService;

	@Autowired
	MerService merservice;
	
	@Autowired
	EmailDetailsDao emailDetailsDao;
	
	@Autowired
	private DocumentUploadService documentService;
	
	@Autowired
	EmailDetailsService emailDetailsService;

	@PostMapping("/boardMerchant")
	public Responce OnBoardMerchant(@RequestBody String request) {
		System.out.println("Request Received : " + request);
		Gson gson = new Gson();
		Merchant merchant = null;
		Responce responce = new Responce();
		merchant = gson.fromJson(request, Merchant.class);
		Merchant merOobject = merservice.saveTransaction(merchant);
		if (merOobject.getStatus().equals("200")) {
			responce.setResponceCode("200");
		} else {
			responce.setResponceCode("100");
		}
		return responce;
	}
	
	@PostMapping("/boardMerchant1")
	public Responce OnBoardMerchant(@RequestParam(value = "email") String email,@RequestParam(value = "password") String password) {
	
		System.out.println("Request Received : " + email +" "+password);
		Gson gson = new Gson();
		Merchant merchant = new Merchant();
		Responce responce = new Responce();
		merchant.setBusinessCategory("Information Technology");
		merchant.setBusinessName("Razorpay Business");
		merchant.setCityName("Pune");
		merchant.setContact("9657135080");
		merchant.setEmail(email);
		merchant.setName("Yash");
		merchant.setPassword(password);
		merchant.setStatus("A");
		Merchant merOobject = merservice.saveTransaction(merchant);
		if (merOobject.getStatus().equals("200")) {
			responce.setResponceCode("200");
			responce.setMid(merOobject.getId());
		} else {
			responce.setResponceCode("100");
		}
		return responce;
	}
	@PostMapping("/sendMail")
	public DocResponce sendMail(@RequestBody String request) {
		System.out.println("Request Received : " + request);
		Gson gson = new Gson();
		DocResponce doc = new DocResponce();
		EmailDetails emailDetails = null;
		emailDetails = gson.fromJson(request, EmailDetails.class);
		boolean result = emailDetailsService.sendEmail(emailDetails);
		if(result) {
			
		
		try {
			Document image = documentService.downloadImageExt(emailDetails.getRequestedMid(),emailDetails.getDocumentType());
			System.out.println("start-"+image.toString()+"-end");
			List<DocumentSub> docSub1 = new ArrayList<>();
			DocumentSub docSub = new DocumentSub();
			docSub.setDocData(image.getImageData().toString());
			docSub.setDocName(image.getDname());
			docSub.setRefNumber(image.getId().toString());
			
			doc.setMerchantEmail(emailDetails.getEmail());
			doc.setStatus(true);
			
			docSub1.add(docSub);
			doc.setDocument(docSub1);
			//return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		}
		return doc;
	}
}
