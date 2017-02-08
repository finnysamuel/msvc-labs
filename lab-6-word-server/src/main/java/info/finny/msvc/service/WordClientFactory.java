package info.finny.msvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WordClientFactory {
	
	NounClient nounClient;
	AdjectiveClient adjectiveClient;
	ArticleClient articleClient;
	VerbClient verbClient;
	SubjectClient subjectClient;
	
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
	
	@Autowired
	public void setVerbClient(VerbClient verbClient) {
		this.verbClient = verbClient;
	}

	@Autowired
	public void setSubjectClient(SubjectClient subjectClient) {
		this.subjectClient = subjectClient;
	}

	@Autowired
	public void setArticleClient(ArticleClient articleClient) {
		this.articleClient = articleClient;
	}

	@Autowired
	public void setAdjectiveClient(AdjectiveClient adjectiveClient) {
		this.adjectiveClient = adjectiveClient;
	}

	@Autowired
	public void setNounClient(NounClient nounClient) {
		this.nounClient = nounClient;
	}	
}
