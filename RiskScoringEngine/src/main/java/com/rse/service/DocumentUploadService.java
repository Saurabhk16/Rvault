package com.rse.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rse.model.Document;
import com.rse.repo.DocumentRepo;
import com.rse.utility.ImageUtil;
import com.rse.vault.VaultService;


@Service
public class DocumentUploadService {

	@Autowired
	private DocumentRepo documentRepo;
	
	public Document uploadImage(byte[] file,String dName,String merId) throws IOException {
		Document pImage = new Document();
		pImage.setName("test1");
		pImage.setType("test2");
		pImage.setImageData(ImageUtil.compressImage(file));
		pImage.setMerchant(merId);
		pImage.setDname(dName);
		System.out.println(file.length);
		return documentRepo.save(pImage);
	}
	public Document uploadImage1(byte[] file,String dname,String merId) throws Exception {
		VaultService vault=new VaultService("password123");
		Document pImage = new Document();
		//pImage.setName(file.getOriginalFilename());
		//pImage.setType(file.getContentType());
		pImage.setDname(dname);
		pImage.setMerchant(merId);
		byte[] compressImage=ImageUtil.compressImage(file);
		pImage.setImageData(file);
		pImage.setSecure(vault.encryptData(compressImage, "3707305520134158"));
		System.out.println("Before compress:- "+file.length);
		System.out.println("after compress:- "+pImage.getImageData().length);
		return documentRepo.save(pImage);
	}

	public byte[] downloadImage1(String fileName){
        Optional<Document> imageData = documentRepo.findByName(fileName);
        return ImageUtil.decompressImage(imageData.get().getImageData());
    }
	
	public byte[] downloadImage(String merchant,String dname) throws Exception{
        Document imageData = documentRepo.findBymerchant(merchant, dname);//documentRepo.findByName(fileName);
		VaultService vault=new VaultService("password123");
		byte[] image=vault.decryptData(imageData.getSecure().toString(), "3707305520134158");
        return  ImageUtil.decompressImage(image);
    }
	public Document downloadImageExt(String merchant,String dname) throws Exception{
        Document imageData = documentRepo.findBymerchant(merchant, dname);//documentRepo.findByName(fileName);
		
		return  imageData;
    }
	}
