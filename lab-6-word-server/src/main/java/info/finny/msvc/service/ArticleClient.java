package info.finny.msvc.service;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient ("get-article")
public interface ArticleClient extends WordFeignClient {

}
