package dev.alejandrocosta.email;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EnviandoEmailApplicationTests {

	/*PrivateData is a class that holds the user mail and password data. The class is omitted here for security purposes.*/
	private PrivateData privateData = new PrivateData();
	private UserMailData userMailData = new UserMailData(privateData.mail, privateData.password);
	
//	@Test
//	public void sendSimpleTextEmail() throws Exception {
//		
//		StringBuilder simpleTextEmailContent = new StringBuilder();
//		simpleTextEmailContent.append("Este é um e-mail enviado pelo Java. O conteúdo está escrito como texto simples.");
//		
//		EnvioDeEmail envioDeEmail = new EnvioDeEmail(userMailData, "alejandroesfc@gmail.com", "Alejandro Costa - Desenvolvedor de Sistemas", "Teste de envio de email automático", simpleTextEmailContent.toString());
//		
//		envioDeEmail.enviarEmail(false);
//		/**Se o e-mail não estiver chegando, pode ser que o processo de envio esteja morrendo antes do envio, já que é um teste unitário. Com esse sleep, o processo ainda segura por 5 segundos. Tempo sufiente.*/
//		//Thread.sleep(5000);
//		
//	}
	
	@Test
	public void sendHtmlTextEmail() throws Exception {
		
		StringBuilder htmlTextEmailContent = new StringBuilder();
		htmlTextEmailContent.append("<h3>Olá!</h3> </br></br>");
		htmlTextEmailContent.append("<p>Nesse e-mail existem tags html que devem ser corretamente exibidas.</p></br>");
		htmlTextEmailContent.append("<p>Por exemplo, logo abaixo será exibido um botão. Clique nesse botão para visitar o meu LinkedIn.</p></br></br>");
		htmlTextEmailContent.append("<hr style=\"width:10em; color:#303030\" >");
		htmlTextEmailContent.append("<a target=\"_blank\" href=\"https://www.linkedin.com/in/alejandro-costa-640bb4195/\" style=\"color: #2525a7; padding: 1em .5em; text-align: center; text-decoration: none; border: .1em solid green; border-radius: 1em; font-size: 1.2em; font-family: courier; display: inline-block; background-color: #99da39; \" >Meu LinkedIn</a><br><br>");
		htmlTextEmailContent.append("<span style=\"font-size: .8em\" >Alejandro Costa</span><br>");
		htmlTextEmailContent.append("<span style=\"font-size: .8em\" >Desenvolvedor de Sistemas</span><br>");
		
		EnvioDeEmail envioDeEmail = new EnvioDeEmail(userMailData, "alejandroesfc@gmail.com", "Alejandro Costa - Desenvolvedor de Sistemas", "Teste de envio de email automático utilizando html", htmlTextEmailContent.toString());
		
		envioDeEmail.enviarEmail(true);
		/**Se o e-mail não estiver chegando, pode ser que o processo de envio esteja morrendo antes do envio, já que é um teste unitário. Com esse sleep, o processo ainda segura por 5 segundos. Tempo sufiente.*/
		//Thread.sleep(5000);
		
	}

}
