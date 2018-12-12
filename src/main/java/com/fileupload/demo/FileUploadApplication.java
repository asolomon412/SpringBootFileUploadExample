package com.fileupload.demo;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileUploadApplication {

	public static void main(String[] args) {
		// added this in case the uploads folder does not exist -- calling the public variable from the HomeController
		new File(HomeController.uploadDirectory).mkdir();
		SpringApplication.run(FileUploadApplication.class, args);
	}
}
