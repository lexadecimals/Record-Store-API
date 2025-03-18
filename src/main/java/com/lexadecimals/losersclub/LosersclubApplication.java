package com.lexadecimals.losersclub;

import com.lexadecimals.losersclub.service.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LosersclubApplication {

	public static void main(String[] args) {
		SpringApplication.run(LosersclubApplication.class, args);
		Utils.fetchAlbumFromItunes("the cure");
	}

}
