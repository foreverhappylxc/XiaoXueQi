package myJavaBean;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	public boolean send(String accept, String text)
	{
		Properties properties = new Properties();
		 properties.put("mail.transport.protocol", "smtp");
		 properties.put("mail.smtp.host", "smtp.qq.com");
		 properties.put("mail.smtp.port", 465);// 端口号
		 properties.put("mail.smtp.auth", "true");
		 properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
		 properties.put("mail.debug", "true");
		 Session session = Session.getInstance(properties);
		 Message message = new MimeMessage(session);
		 try {
			message.setFrom(new InternetAddress("1771583929@qq.com"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(accept));
			message.setSubject("验证码");
			message.setText(text);
			Transport transport = session.getTransport();
			transport.connect("1771583929@qq.com","dsfnvdespymtbgbe");
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			return true;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
