package dev.alejandrocosta.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnvioDeEmail {

	private UserMailData userMailData;
	
	private String identificacaoDoRemetente = "";
	private String destinatarios = "";
	
	private String assuntoDoEmail = "";
	private String textoDoEmail = "";
	
	
	public EnvioDeEmail(UserMailData userMailData, String destinatarios, String identificacaoDoRemetente, String assuntoDoEmail, String textoDoEmail) {
		
		this.userMailData = userMailData;
		this.destinatarios = destinatarios;
		this.identificacaoDoRemetente = identificacaoDoRemetente;
		this.assuntoDoEmail = assuntoDoEmail;
		this.textoDoEmail = textoDoEmail;
		
	}
	
	/**
	 * Authenticates the connection with the mailing server, configures the message and sends the e-mail. 
	 * This method will be broken up into smaller methods to clean up the code.
	 * @param	isHtml A boolean indicating if there is HTML tags in the message to be sent.
	 * @version 0.1 2022-04-01
	 * @author Alejandro Costa
	 * */
	public void enviarEmail(boolean isHtml) throws Exception {
		
		//Configuração das propriedades
		Properties properties = new Properties();
		properties.put("mail.smtp.ssl.trus", "*");
		properties.put("mail.smtp.auth", "true"); //autorização
		properties.put("mail.smtp.starttls", "true"); //autenticação
		properties.put("mail.smtp.host", "smtp.gmail.com"); //servidor gmail do google
		properties.put("mail.smtp.port", "465"); //porta do servidor
		properties.put("mail.smtp.socketFactory.port", "465"); //especifica a porta a ser conectada pelo socket
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //classe socket de conexão ao smtp
		
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userMailData.getUserMailAddress(), userMailData.getUserMailPassword());
			}
		});
		
		Address[] toUser = InternetAddress.parse(destinatarios);
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userMailData.getUserMailAddress(), identificacaoDoRemetente));
		message.setRecipients(Message.RecipientType.TO, toUser);
		message.setSubject(assuntoDoEmail);
		
		if (isHtml) {
			message.setContent(textoDoEmail, "text/html; charset=utf-8");
		} else {			
			message.setText(textoDoEmail);
		}
		
		Transport.send(message);
		
	}
}
