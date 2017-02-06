package info.finny.msvc.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
	private DiscoveryClient discoveryClient;

	public String getWord(String serviceName) {
	    List<ServiceInstance> list = discoveryClient.getInstances(serviceName);
	    if (list != null && list.size() > 0 ) {
	        URI uri = list.get(0).getUri();
	        if (uri !=null ) {
	      	  	return (new RestTemplate()).getForObject(uri,String.class);
	      	}
	    }
	    return null;
	}
}
