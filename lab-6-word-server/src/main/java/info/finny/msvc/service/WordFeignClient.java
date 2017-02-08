package info.finny.msvc.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface WordFeignClient {
	
	@RequestMapping (method= RequestMethod.GET, value = "/")
	public String getWord();
}
