package info.finny.msvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WordClientFactory {
	
	@Autowired NounClient nounClient;
	@Autowired AdjectiveClient adjectiveClient;
	@Autowired ArticleClient articleClient;
	@Autowired VerbClient verbClient;
	@Autowired SubjectClient subjectClient;
	
	public WordFeignClient getClient(String wordType){
		switch (wordType) {
		case "noun":
			return nounClient;
		case "adjective":
			return adjectiveClient;
		case "article":
			return articleClient;
		case "verb":
			return verbClient;
		case "subject":
			return subjectClient;
		default:
			return null;
		}
	}
}
