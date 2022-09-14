package com.example.inventory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.management.remote.JMXServerErrorException;
import javax.naming.NamingException;

@SpringBootApplication
public class InventoryApplication {

	private static Logger logger = LoggerFactory.getLogger(InventoryApplication.class);
	public static void main(String[] args) throws NamingException, JMXServerErrorException {
		logger.info("Iniciando a api controle de vagas");
		SpringApplication.run(InventoryApplication.class, args);
		logger.info("API de controle de vaga iniciada e pronta para receber requisições");
	}

}
