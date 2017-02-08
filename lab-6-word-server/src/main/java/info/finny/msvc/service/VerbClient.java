package info.finny.msvc.service;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient ("get-verb")
public interface VerbClient extends WordFeignClient {

}
