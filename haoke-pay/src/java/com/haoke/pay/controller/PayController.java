package com.haoke.pay.controller;

import com.haoke.pay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@RestController
public class PayController {

    @Autowired
    private PayService payService;
    @ResponseBody
    @RequestMapping(value="/pay",method = RequestMethod.GET)
    public String pay(HttpServletResponse resp, HttpServletRequest req)  {
        resp.setContentType("text/html;charset=utf-8");
        String html=payService.pay(resp,req);
        Writer writer= null;
        try {
            writer = resp.getWriter();
            writer.write(html);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "pay";
    }
}
