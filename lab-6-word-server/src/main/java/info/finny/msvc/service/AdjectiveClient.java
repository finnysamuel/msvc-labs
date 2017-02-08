package info.finny.msvc.service;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient ("get-adjective")
public interface AdjectiveClient extends WordFeignClient {

}
