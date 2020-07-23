package com.example.cs.config;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class AddCookie {

    public static void addCookie(String userName, HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {
        if(userName!=null){
            //创建cookie
            Cookie nameCookie = new Cookie("userName", URLEncoder.encode(userName, "utf-8"));
            nameCookie.setPath(request.getContextPath()+"/");//设置cookie路径
            //设置cookie保存的时间 单位：秒
            nameCookie.setMaxAge(7*24*60*60);
            //将cookie添加到响应
            response.addCookie(nameCookie);
        }
    }
}
