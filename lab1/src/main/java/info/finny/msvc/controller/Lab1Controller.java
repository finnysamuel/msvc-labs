package info.finny.msvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lab1Controller {
	

	@RequestMapping("/")
	public String lab1Hi(){
		return "hello";
	}
}
