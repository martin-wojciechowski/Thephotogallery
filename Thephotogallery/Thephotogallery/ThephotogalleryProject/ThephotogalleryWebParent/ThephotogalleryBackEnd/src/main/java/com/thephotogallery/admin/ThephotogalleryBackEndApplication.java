package com.thephotogallery.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.thephotogallery.common.entity", "com.thephotogallery.admin.user"})

public class ThephotogalleryBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThephotogalleryBackEndApplication.class, args);
	}

}
