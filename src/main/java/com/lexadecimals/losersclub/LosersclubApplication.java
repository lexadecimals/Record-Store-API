package com.lexadecimals.losersclub;

import com.lexadecimals.losersclub.dao.AlbumArtDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LosersclubApplication {

	public static void main(String[] args) {
		SpringApplication.run(LosersclubApplication.class, args);

		AlbumArtDAO.getWebClientResults();
	}

}
