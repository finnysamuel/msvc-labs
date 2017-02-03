package info.finny.msvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LuckyWordController {
	
	@Value("${lucky-word}") String luckyWord = "Hello";

	@RequestMapping ("/lucky")
	public String getLuckyWord(){
		return "The lucky word got from config server is: " + luckyWord;
	}
}
