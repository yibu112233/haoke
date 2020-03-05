package com.haoke.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginFilter extends ZuulFilter {
    //routing:路由时 pre:路由前 post:路由后 error:发送错误调用
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currenContext=RequestContext.getCurrentContext();
        HttpServletRequest request=currenContext.getRequest();
        String token =request.getParameter("token");
        if(null==token){
            currenContext.setSendZuulResponse(false);
            currenContext.setResponseStatusCode(401);
            HttpServletResponse response=currenContext.getResponse();
            response.setContentType("text/html;charset=utf-8");
            try {
                response.getWriter().write("非法请求");
            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }


        return null;
    }
}
