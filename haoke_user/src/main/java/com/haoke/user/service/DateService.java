package com.haoke.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DateService {
    @Autowired
    private RestTemplate restTemplate;

    public String getDateByMill(String mill){
        return restTemplate.getForObject("http://haoke-service-util/getDateByMill?mill="+mill,String.class);
    }

}
