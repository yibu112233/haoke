package com.haoke.user.controller;

import com.haoke.user.service.DateService;
import com.haoke.user.service.IDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller
{
    @Autowired
    private DateService dateService;

    @Autowired
    private IDateService iDateService;

    @RequestMapping(value="getDateByMill",method = RequestMethod.GET )
    public String  getDateByMill(String mill){
        return iDateService.getDateByMill(mill);
    }

    @RequestMapping(value="getUsername",method = RequestMethod.GET )
    public String  getUsername(String name){
        return name;
    }
}
