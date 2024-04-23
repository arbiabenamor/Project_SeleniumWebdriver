package com.qacart.todo.utils;

import io.restassured.http.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {

    public static List<org.openqa.selenium.Cookie> convertRestAssuredCookiesToSelinuimCookies(List<Cookie> restAssuredcookies)
    {
        List<org.openqa.selenium.Cookie> ListofcookiesSelinuim=new ArrayList<>();
        for (io.restassured.http.Cookie i : restAssuredcookies) {
            org.openqa.selenium.Cookie Selinuimecookie = new org.openqa.selenium.Cookie(i.getName(), i.getValue());

            ListofcookiesSelinuim.add(Selinuimecookie);
        }
        return ListofcookiesSelinuim ;
    }
}
