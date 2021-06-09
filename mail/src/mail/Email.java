package mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


//http://www.gisdeveloper.co.kr/?p=6916
public class Email {

	public static class MainEntry {
		
		static final String FROM = "보내는사람이메일";
		static final String FROMNAME = "보내는사람";
		static final String TO = "받는사람이메일";
		
		static final String SMTP_USERNAME = "보내는사람이메일";
		static final String SMTP_PASSWORD = "비밀번호";
		
		static final String HOST = "smtp.naver.com";
		static final int PORT = 465;
		
		static final String SUBJECT = "메일제목";
		static final String BODY = 
				String.join(System.getProperty("line.separator"), 
							"<h1>메일 내용</h1>", 
							"<p>내용</p>");
		
		
		public static void main(String[] args) {

			Properties p = System.getProperties();
			p.put("mail.transport.protocol", "smtp");
			p.put("mail.smtp.port", PORT);
			p.put("mail.smtp.starttls.enable", "true");
			p.put("mail.smtp.auth", "true");
			
			Session session = Session.getDefaultInstance(p);
			
			MimeMessage msg = new MimeMessage(session);
			try {
				msg.setFrom(new InternetAddress(FROM, FROMNAME));
				msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
				msg.setSubject(SUBJECT);
				msg.setContent(BODY, "text/html;charset=euc-kr");
				
				Transport transport = session.getTransport();
				
				System.out.println("Sending...");
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		} // end of main

	} // end of MainEntry
}
