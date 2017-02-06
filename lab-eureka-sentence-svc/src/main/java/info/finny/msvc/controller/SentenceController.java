package info.finny.msvc.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SentenceController {
	@RequestMapping ("/string")
	public @ResponseBody String getSentence(){
		return getWord("get-subject") + " "
		        + getWord("get-verb") + " "
		        + getWord("get-article") + " "
		        + getWord("get-adjective") + " "
		        + getWord("get-noun") + "."
		        ;
	}
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	public String getWord(String serviceName) {
	    ServiceInstance serviceInstance = loadBalancerClient.choose(serviceName);
	    URI uri = serviceInstance.getUri();
	    return (new RestTemplate()).getForObject(uri,String.class);
	}
}
