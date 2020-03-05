package com.haoke.util.DateUtil;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class DateController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value="getDateByMill",method = RequestMethod.GET)
    public String transateMsToDate(long mill){

        Date date = new Date(mill);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String formDate =sdf.format(date);
        return  formDate+"  "+port;
    }
}
