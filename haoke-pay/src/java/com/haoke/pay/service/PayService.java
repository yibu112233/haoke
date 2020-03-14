package com.haoke.pay.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PayService  {
    public String pay(HttpServletResponse resp, HttpServletRequest resq);
}
