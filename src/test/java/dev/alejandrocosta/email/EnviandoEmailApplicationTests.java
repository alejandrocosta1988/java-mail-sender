package dev.alejandrocosta.email;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EnviandoEmailApplicationTests {

	/*PrivateData is a class that holds the user mail and password data. The class is omitted here for security purposes.*/
	private PrivateData privateData = new PrivateData();
	private UserMailData userMailData = new UserMailData(privateData.mail, privateData.password);
	
	@Test
	public void testeEmail() throws Exception {
		
		EnvioDeEmail envioDeEmail = new EnvioDeEmail(userMailData, "alejandroesfc@gmail.com", "Alejandro Costa - Desenvolvedor de Sistemas", "Teste de envio de email automático", "Esse texto é a descrição do meu e-mail enviado utilizando Java");
		
		envioDeEmail.enviarEmail();
		/**Se o e-mail não estiver chegando, pode ser que o processo de envio esteja morrendo antes do envio, já que é um teste unitário. Com esse sleep, o processo ainda segura por 5 segundos. Tempo sufiente.*/
		//Thread.sleep(5000);
		
		
	}

}
