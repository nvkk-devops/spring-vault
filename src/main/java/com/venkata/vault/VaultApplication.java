package com.venkata.vault;

import com.venkata.vault.configuration.VenkatVaultConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class VaultApplication {

	private static Logger logger = LoggerFactory.getLogger(VaultApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(VaultApplication.class, args);

		VenkatVaultConfiguration venkatVault = applicationContext.getBean(VenkatVaultConfiguration.class);
		logger.info("Login :: "+ venkatVault.getLogin());
		logger.info("Password :: "+ venkatVault.getPassword());
	}

}
