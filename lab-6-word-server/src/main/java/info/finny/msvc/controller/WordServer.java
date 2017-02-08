package info.finny.msvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.finny.msvc.domain.Word;
import info.finny.msvc.service.WordClientFactory;
import info.finny.msvc.service.WordFeignClient;

@RestController
public class WordServer {
	
	/*@Autowired
	private LoadBalancerClient loadBalancerClient;*/
	@Autowired
	private WordClientFactory clientFactory;
	
	@RequestMapping ("/")
	public Word getWord(@RequestBody Word type){
//		ServiceInstance serviceInstance = loadBalancerClient.choose("get-"+ type.getWord());
//	    URI uri = serviceInstance.getUri();
//	    return new Word((new RestTemplate()).getForObject(uri,String.class));
		WordFeignClient client = clientFactory.getClient(type.getWord());
		return new Word(client.getWord());
	}
}
