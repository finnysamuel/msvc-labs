package info.finny.msvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {
	
	//@Value ("${words}") String[] words;
	String[] words = {"Icicle", "SnowBall"};
	
	@RequestMapping ("/")
	public @ResponseBody String getWord(){
		return words[(int) Math.round(Math.random() * (words.length - 1))];
	}
}
