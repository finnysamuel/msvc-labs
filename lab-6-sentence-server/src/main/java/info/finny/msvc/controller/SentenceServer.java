package info.finny.msvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.finny.msvc.domain.Word;
import info.finny.msvc.service.WordFeignClient;

@RestController
public class SentenceServer {
//	@Autowired
//	private LoadBalancerClient loadBalancerClient;
	
	@Autowired
	private WordFeignClient wordClient;
	
	String [] componentOrder = {"subject","verb","article","adjective","noun"};
	
	@RequestMapping("/")
	public String getSentence(){
		StringBuilder sentence = new StringBuilder();
//		ServiceInstance serviceInstance = null;
		Word resultWord = null;
		for (int i = 0; i < componentOrder.length; i++) {
			if (!"".equals(sentence) && resultWord !=null){
				sentence.append(" ");
			}
//			serviceInstance = loadBalancerClient.choose("get-word");
//			URI uri = serviceInstance.getUri();
//			resultWord = (new RestTemplate()).postForObject(uri, new Word(componentOrder[i]), Word.class);
			resultWord = wordClient.getWord(new Word(componentOrder[i]));
			sentence.append(resultWord.getWord());
		}
		return sentence.toString();
	}
}
