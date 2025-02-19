package com.investor.utilities;


import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.investor.base.PropertiesReader;
public class SendEmail {
	final static String username = "";
	final static String password = "";

	
	public static void SendEmailNow(String body,String url) {
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("usman@vestedfinance.co"));
            
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(
                		"ali@vestedfinance.co,"
                		));
            String currentDateTime = new SimpleDateFormat("dd-MMM-yyyy_h:mm a z").format(Calendar.getInstance().getTime());
            message.setSubject("Vested Finance IOS "+PropertiesReader.getPropertyValue("env").toUpperCase()+ " Automation Tests Run Report on "+currentDateTime);
            message.setText("Report is attached as a zip file, download, extract in a folder and you can see report files there.");
            Multipart multipart = new MimeMultipart();
            BodyPart textPart = new MimeBodyPart(); 
            textPart.setText(body);
            BodyPart linkPart = new MimeBodyPart(); 
            String content="<br/><br/><a href='http://182.180.172.81:8082/IOS/Index'>View on Dashboard</a><br/><br/><a href='"+url+"'>Click Here to Download Report</a>";
            linkPart.setContent(content,"text/html; charset=utf-8");
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(linkPart);
            // Send the complete message parts
            message.setContent(multipart );
            Transport.send(message);
            System.out.println("Email Sent");

        } catch (MessagingException e) {
        	System.out.println("Email Error: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
	
	public static void main(String [] args) {
		SendEmailNow("Fixing Email Issue", "testUrl");
	}
	
	
	public static void SendEmailNow(String body) {

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("usman@vestedfinance.co"));
            
            message.setRecipients(Message.RecipientType.TO,
            		InternetAddress.parse("ali@vestedfinance.co"
	                		)
            		);
            String currentDateTime = new SimpleDateFormat("dd-MMM-yyyy_h:mm a z").format(Calendar.getInstance().getTime());
            message.setSubject("Vested Finance IOS "+PropertiesReader.getPropertyValue("env").toUpperCase()+ "Automation Tests Run Report on "+currentDateTime);
            message.setText("Report is attached as a zip file, download, extract and you can see report files there.");
            Multipart multipart = new MimeMultipart();
            BodyPart textPart = new MimeBodyPart(); 
            textPart.setText(body);
            
            BodyPart filePart = new MimeBodyPart();
         // Part two is attachment
            filePart = new MimeBodyPart();
            String filename = ZipUtils.OUTPUT_ZIP_FILE;
            DataSource source = new FileDataSource(filename);
            filePart.setDataHandler(new DataHandler(source));
            filePart.setFileName(source.getName());
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(filePart);

            // Send the complete message parts
            message.setContent(multipart );
            Transport.send(message);
            System.out.println("Email Sent");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
	

}
