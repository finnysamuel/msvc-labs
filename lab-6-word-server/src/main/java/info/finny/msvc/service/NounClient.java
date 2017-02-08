package info.finny.msvc.service;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient ("get-noun")
public interface NounClient extends WordFeignClient {

}
