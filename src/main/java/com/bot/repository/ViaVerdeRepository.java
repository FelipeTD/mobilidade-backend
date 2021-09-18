package com.bot.repository;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bot.entity.viaverde.CardPayments;
import com.bot.factory.ConnectionFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Component
public class ViaVerdeRepository {
	
	@Autowired
	private ConnectionFactory connection;
	
	public CardPayments getViaVerdeData() {
		
		connection.setViaVerdeCookie(".ASPXANONYMOUS=yU9iSS1Ty-BQum2GSi0x11x9gfifFAHGZyTU7LtQHeqcJMVzTqD60NDvYrwi-tfZWD6iwt715zTeyVvTqtrQISdaHNXgk7RhSMPWW31EXLjXkcMc0; __ft_referrer=direct; __lt_referrer=direct; _ga=GA1.2.286053774.1629078285; _fbp=fb.1.1629078284832.709997839; cookieBarDontShow=true; dnn_IsMobile=False; language=pt-PT; ASP.NET_SessionId=0tq3raac1py0cd4kp5nl3qhr; dtCookie=v_4_srv_1_sn_14E22CA1EBDAF624147F3E57806A93C6_perc_100000_ol_0_mul_1_app-3A94ba0896033f05e1_0; rxVisitor=16314067601704U7GJH9I6BQVRJV92BKTMHNM0Q9HV0UP; __utm_tracking_session=true; at_check=true; AMCVS_8B7B35B95CF65A600A495F85%40AdobeOrg=1; AMCV_8B7B35B95CF65A600A495F85%40AdobeOrg=-1124106680%7CMCIDTS%7C18883%7CMCMID%7C33779232462033098723505644298536747663%7CMCAAMLH-1632011561%7C4%7CMCAAMB-1632011561%7CRKhpRz8krg2tLO6pguXWp5olkAcUniQYPHaMWWgdJ3xzPWQmdj0y%7CMCOPTOUT-1631413961s%7CNONE%7CvVersion%7C5.2.0; s_cc=true; _gid=GA1.2.1306557405.1631406765; .DOTNETNUKE=A374E03F58D9843E0F40E9394351EC1A3AE283679BD8B0AD420641251919E288A7D7A7B0EC550DE8FFB88B6DBB4C9F8CD538A47B0BA27DA4000EA5D57E341FDDF4E4B2D260C36EE7A31CFD74B83433294B107E31A357EB7B25935830C8F017D6B990445F; SiteGroup=viaverde.pt; VV=02ed0abb-38ef-4663-926e-b084b2bae64d; LastPageId=2:3201; dtSa=-; dtLatC=4; mbox=PC#e374047b725a4cc3bcf960dfc340f637.34_0#1694651602|session#a8fe775a5e3c45d69a0519fbca955595#1631408622; s_sq=%5B%5BB%5D%5D; rxvt=1631408602321|1631406760171; dtPC=1$6801209_203h-vCMBCCCUQJHKRCROIAVGKUHGCVMBSHCUQ-0e0; _gat_UA-68715520-1=1");
		String cookie = connection.getViaVerdeCookie();
		
		String urlText = "https://www.viaverde.pt/empresas/DesktopModules/MVC/Transactions/Default/GetTransactions";
		
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = null;
		try {
			response = Unirest.post(urlText)
			  .header("Cookie", cookie)
			  .header("moduleid", "4202")
			  .header("tabid", "3201")
			  .header("Content-Type", "application/json")
			  .body("{\r\n    \"contractList\":[516818247],\r\n    \"serviceTypeList\":[4,-1,5,10,6,2,3,11,8,7],\r\n    \"paymentMethodList\":[1,2,4,3],\r\n    \"paymentStatusList\":[0,1,2],\r\n    \"maxRows\":1000,\r\n    \"currentRow\":1,\r\n    \"fromDate\":\"2021-02-16T03:00:00.000Z\",\r\n    \"toDate\":\"2021-08-16T03:00:00.000Z\",\r\n    \"identifiers\":[]\r\n}")
			  .asString();
		} catch (UnirestException e) {
			System.out.println("Erro ao executar requisição para a API");
			e.printStackTrace();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		CardPayments cardPayments = null;
		
		String responseTratado = response.getBody().toString().toLowerCase();
		
		InputStream responseStream = new ByteArrayInputStream(responseTratado.getBytes(StandardCharsets.UTF_8)); 
		
		try {
			cardPayments = mapper.readValue(responseStream, CardPayments.class);
		} catch (JsonParseException e) {
			System.out.println("Erro ao realizar parse do JSON");
			e.printStackTrace();
		} catch (JsonMappingException e) {
			System.out.println("Erro ao realizar mapeamento do JSON");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro generico ao trabalhar JSON");
			e.printStackTrace();
		}
		
		return cardPayments;
		
	}

}
