package com.fileupload.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	// needed to reference later, and used to add a folder to the root of our project
	// ****also added a make directory method to the application main if the uploads folder does not exist****
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

	@RequestMapping("/")
	public ModelAndView index() {

		return new ModelAndView("index");
	}

	@PostMapping("/test")
	// this lets us add multiple files that get added to an array
	public String upload(Model model, @RequestParam("files") MultipartFile[] files) {
		StringBuilder fileNames = new StringBuilder();
		// loop in case there are multiple files
		for (MultipartFile file : files) {
			
			Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
			// appending the file name to the file path so that it's saved with a name, if it exists already, it overwrites the file
			fileNames.append(file.getOriginalFilename() + " ");
			try {
				// this line is writing to the file 
				// LHS only used here to print the file path to the page, RHS only needed if you don't care to print
				Path file1 = Files.write(fileNameAndPath, file.getBytes());
				// testing for AWS - this doesn't work there
				model.addAttribute("filep", file1.toUri().toURL().toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("msg", "Successfully uploaded files " + fileNames.toString());

		return "uploadview";
	}
}
