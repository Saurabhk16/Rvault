package com.rse.service.impl;

import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rse.dao.EmailDetailsDao;
import com.rse.model.EmailDetails;
import com.rse.service.EmailDetailsService;

@Service
public class EmailDetailsServiceImpl implements EmailDetailsService {
	@Autowired
	EmailDetailsDao emailDetailsDao;

	@Override
	public boolean sendEmail(EmailDetails emailDetails) {

		Timestamp time = new java.sql.Timestamp(new Date().getTime());
		emailDetails.setDate(time);
		emailDetails.setFlag("N");
		emailDetailsDao.save(emailDetails);
		EmailDetails obj = emailDetailsDao.findByUser(emailDetails.getRequestedMid());

		String username = "rahul.bhingare@razorpay.com";
		String password = "rgwwpyqnvtowvkqk";
		String recipient = emailDetails.getEmail();
		String message = "Izealiant Technology Trying to access your " +emailDetails.getDocumentType() +" if that you then approve the Request.\n\n"
				+ "\n\n" + "http://localhost:8082/NiceAdmin/forms-validation.php?uid=" + obj.getId() + "\n"
				+ "Thanks & Regards\n" + "Razorpay Services PVT LTD\n" + "Kalyani Nagar Pune";

		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.from", "rahul.bhingare@razorpay.com");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "587");
		props.setProperty("mail.debug", "true");

		Session session = Session.getInstance(props, null);
		MimeMessage msg = new MimeMessage(session);

		try {
			msg.setRecipients(Message.RecipientType.TO, recipient);
			msg.setSubject("Action Needed");
			msg.setText(message);

			Transport transport = session.getTransport("smtp");

			transport.connect(username, password);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();

			Thread.sleep(15000);
			String flag = refreshDb(emailDetails.getRequestedMid());
			if(flag.equalsIgnoreCase("Y")) {
				return true;
			}else {
				return false;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

String refreshDb(String id) {
	  String DB_URL = "jdbc:mysql://10.82.2.100/PobodyNerfect";
	   String USER = "PobodyNerfect";
	   String PASS = "PobodyNerfect#1234";
	   String QUERY = "SELECT FLAG FROM emaildetails where REQ_MID="+id;
	   String flag = null;
	      // Open a connection
	      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(QUERY);) {
	         // Extract data from result set
	         while (rs.next()) {
	            // Retrieve by column name
	            System.out.print("Flag: " + rs.getString("FLAG"));
	            flag = rs.getString("FLAG");
	            
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
	      return flag;
}
}
