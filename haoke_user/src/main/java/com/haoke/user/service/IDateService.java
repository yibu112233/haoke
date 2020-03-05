package com.haoke.user.service;


import com.haoke.user.hystrix.DateServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="haoke-service-util",fallback = DateServiceHystrix.class)
public interface IDateService {

    @RequestMapping(value="getDateByMill",method = RequestMethod.GET)
    public String getDateByMill(@RequestParam(value="mill") String mill);
}
