package com.haoke.user.hystrix;

import com.haoke.user.service.IDateService;
import org.springframework.stereotype.Component;

@Component
public class DateServiceHystrix implements IDateService {
    @Override
    public String getDateByMill(String mill) {
        return String.format("hi,your message is %s , but bad request",mill);
    }
}
