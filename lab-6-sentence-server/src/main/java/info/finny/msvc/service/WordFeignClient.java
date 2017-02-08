package info.finny.msvc.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.finny.msvc.domain.Word;

@FeignClient("get-word")
public interface WordFeignClient {
	@RequestMapping (method= RequestMethod.POST, 
					 value = "/",
					 consumes = "application/json")
	public Word getWord(Word wordType);
}
