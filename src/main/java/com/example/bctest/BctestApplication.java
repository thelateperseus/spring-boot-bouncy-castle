package com.example.bctest;

import java.security.Security;
import javax.crypto.Cipher;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BctestApplication {

	public static void main(String[] args) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		Cipher.getInstance("AES/CBC/PKCS5Padding","BC");
		SpringApplication.run(BctestApplication.class, args);
	}

}
