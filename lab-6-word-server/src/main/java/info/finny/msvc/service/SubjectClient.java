package info.finny.msvc.service;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient ("get-subject")
public interface SubjectClient extends WordFeignClient {

}
