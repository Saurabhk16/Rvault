package com.rse.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

import com.rse.service.DocumentUploadService;


@RestController
public class DocumentController {
	
	@Autowired
	private DocumentUploadService documentService;
	
	@ResponseStatus(value = HttpStatus.OK)
	@PostMapping("upload")
	public void readDocument(@RequestParam(value = "image") byte[] file,@RequestParam(value = "id") String merId,@RequestParam(value = "dname") String dname) throws Exception{
		try {		
			documentService.uploadImage1(file,dname,merId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
/*	@PostMapping("/download1/{fileName}")
	public ResponseEntity<byte[]> downloadImage1(@PathVariable String fileName) {
		byte[] image = documentService.downloadImage1(fileName);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
	}*/
	@PostMapping("/download")
	public ResponseEntity<byte[]> downloadImage(@RequestParam(value = "merchantId") String merId,@RequestParam(value = "dname") String dname) throws Exception {
		System.out.println(merId +" "+ dname);
		byte[] image = documentService.downloadImage(merId,dname);

		System.out.println("start-"+image.toString()+"-end");
		
		//String str1 = new String(image);
		//System.out.println(str1);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
	}
	
	@GetMapping("test")
	public String testApplication() {
		
		return "test successfully";
	}


}
